package board;

import java.util.ArrayList;
import java.util.List;

import utils.GameAction;

import agents.Agent;

public class ClassicGameBoard extends GameBoard {

	public ClassicGameBoard() {
		this.list = new ArrayList<Agent>();
	}
	
	@Override
	public void registerAgent(Agent agent) {
		if(agent != null && !this.list.contains(agent)){
			this.list.add(agent);
			agent.notifyEvent(GameAction.Added);
		}

	}

	@Override
	public void deRegisterAgent(Agent agent) {
		if(agent != null && this.list.contains(agent)){
			this.list.remove(agent);
			agent.notifyEvent(GameAction.Removed);
		}
	}

	@Override
	public void play() {
		if(this.list == null || this.list.isEmpty()){
			 // don't do anything
		}
		
		List<Agent> purgeList = new ArrayList<Agent>();
		
		while(this.list.size() > 1){
			System.out.println("List size is "+this.list.size());
			purgeList.clear();
			for(Agent current : this.list){
				if(purgeList.contains(current))
					continue;
				
				String msg = current.getMsg();
				printAgentMessage(current, msg);	// print the msg to console
				boolean isTrue = parseMsg(msg);	// parse it to verify if its correct ?
				
				if(!isTrue){		// if its incorrect disqualified and its over
					purgeList.add(current);
				}
				
			}// end of for loop
			
			for(Agent e : purgeList){
				this.list.remove(e);
				e.deRegister();
			}
		}// while loop
		
		if(this.list.isEmpty()){
			System.out.println("All lost :D");
		}
		
		if(this.list.size() == 1){
			for(Agent e : this.list){
				printWinMessage(e);
			}
		}
	}

	private void printWinMessage(Agent e) {
		System.out.println("--------------------------------");
		System.out.println(e+" has won the message");
		System.out.println("---------------------------------");
	}

	private boolean parseMsg(String msg) {
		msg = msg.trim();	// leading and lagging spaces removed
		
		if(!msg.startsWith("@")){
			return true;		// its general conversation message
		}
		else if(msg.contains(" ") || msg.contains("\t")){	// must be user id without spaces
			return false;
		}
		String agentId = msg.substring(1);
		for(Agent e : this.list){
			if(e.getId().equals(agentId)){
				return e.isBotTest();
			}
		}
		return false;	// claimed some invalid user-id
	}

	private void printAgentMessage(Agent e, String msg) {
		System.out.println(e+": "+msg);		
	}

}

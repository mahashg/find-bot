package agents;

import utils.GameAction;
import utils.Reader;
import board.GameBoard;

public class BotAgent extends Agent{

	public BotAgent(GameBoard g){
		this.id = (System.nanoTime()%10000)+"";
		this.isBot = true;
		this.game = g;
	}
	
	@Override
	public void configure() {
		//Nothing to do here.
	}

	@Override
	public String getMsg() {
		
		return Reader.readNextLine();
	}


	@Override
	public void notifyEvent(GameAction action) {
		if(action == GameAction.Added){
			System.out.println("Added to the Game for Agent #"+id);
			
		}else if(action == GameAction.Removed){
			System.out.println("Removed from the Game for Agent #"+id);
		}
		
	}
}

package agents;

import board.GameBoard;
import utils.GameAction;
import utils.Reader;

public class NonBotAgent extends Agent {

	public NonBotAgent(GameBoard g){
		this.id = (System.nanoTime()%10000)+"";
		this.isBot = false;
		this.game = g;
	}
	
	@Override
	public void configure() {

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

package agents;

import board.GameBoard;
import utils.GameAction;

public abstract class Agent {
	protected GameBoard game;
	protected boolean isBot;
	protected String id;

	public abstract void configure();
	public abstract String getMsg();
	public abstract void notifyEvent(GameAction action);

	public void register() {
		this.game.registerAgent(this);
	}

	public void deRegister() {
		this.game.deRegisterAgent(this);		
	}

	public String getId() {
		return this.id;
	}
	
	public boolean isBotTest(){
		return isBot;
	}
	
	@Override
	public String toString(){
		return "Agent#"+id+"";
	}
}

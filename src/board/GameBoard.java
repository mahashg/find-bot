package board;

import java.util.List;

import agents.Agent;

public abstract class GameBoard {
	protected List<Agent> list;
	
	public abstract void registerAgent(Agent agent);
	public abstract void deRegisterAgent(Agent agent);
	
	public abstract void play();
}

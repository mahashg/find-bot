package game;

import java.util.ArrayList;
import java.util.List;

import board.ClassicGameBoard;

import agents.Agent;
import agents.BotAgent;
import agents.NonBotAgent;

public class Game {
	public static void main(String[] args) {
		int bot_count = 1;
		int non_bot_count = 1;
		
		ClassicGameBoard board = new ClassicGameBoard();
		
		List<Agent> bots = new ArrayList<Agent>();
		List<Agent> nonbots = new ArrayList<Agent>();
		
		for(int i= 0 ; i<bot_count ; ++i){
			Agent agent = new BotAgent(board);
			agent.register();
			bots.add(agent);
		}
		
		for(int i=0 ; i<non_bot_count ; ++i){
			Agent agent = new NonBotAgent(board);
			agent.register();			
			nonbots.add(agent);
		}
		
		System.out.println("Configured Successfully.\nGame Begins.");
		board.play();
		System.out.println("Game Ends.");
	}
}

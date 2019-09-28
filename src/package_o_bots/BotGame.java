package package_o_bots;

import java.util.HashMap;
import java.util.Scanner;

public class BotGame {

	public static void main(String[] args) throws InterruptedException {
		BotGameUI ui = new BotGameUI();
		BotTracker botTracker = new BotTracker();
		HashMap<String, String> botMap = new HashMap<String, String>();
		int numOfBots = ui.getNumBots();
		botMap = ui.getRobotParts(numOfBots);
		BotFactory factory = new BotFactory(botMap, botTracker);
		int fastestTime = 10000000;
		RobotImpl winner = null;
		for (int i = 0; i < botTracker.getRobotRoster().size(); i++) {
			int temp = botTracker.getRobotRoster().get(i).performTasks();
			if (temp < fastestTime) { 
				fastestTime = temp;
				winner = botTracker.getRobotRoster().get(i);
			}
		}
		System.out.println("And the winner is: " + winner.getBotName());
		
		

	}

}
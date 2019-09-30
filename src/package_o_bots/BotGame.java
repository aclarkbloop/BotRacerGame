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
		
		BotFactory factory = new BotFactory(botMap, botTracker, ui);
		
		ui.printBotInfo(botTracker);
		
		for (RobotImpl bot : botTracker.getRobotRoster()) {
			bot.start();
		}
		
		boolean allTasksComplete = false;
		
		while (allTasksComplete == false) {
			for (RobotImpl bot : botTracker.getRobotRoster()) {
				if (!bot.isAlive()) {
					allTasksComplete = true;
				}
			}
		}
		
		RobotImpl fastestBot = null;
		int fastestTime = 10000000;
		for (RobotImpl bot : botTracker.getRobotRoster()) {
			if (bot.getTotalTime() < fastestTime) {
					fastestBot = bot;
			}
		}
		ui.printWinner(fastestBot);
		ui.insertGIF();

	}

}
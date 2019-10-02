package package_o_bots;

import java.awt.Color;
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
		
		// the following lines set a color for each bot so that they are distinct on the UI
		Color[] botColors = {new Color(255,99,71), new Color(100,149,237), 
				new Color(255,255,153), new Color(152,251,152)};
		
		for (RobotImpl bot : botTracker.getRobotRoster()) {
			bot.setColor(botColors[botTracker.getRobotRoster().indexOf(bot)]);
			// start each bot's thread so that they can begin their tasks
			bot.start();
		}
		
		ui.printBotInfo(botTracker);
		
		// boolean remains false until at least one robot thread has completed its tasks
		boolean allTasksComplete = false;
		
		while (allTasksComplete == false) {
			// loops over all bots and checks if thread has completed yet
			for (RobotImpl bot : botTracker.getRobotRoster()) {
				if (!bot.isAlive()) {
					allTasksComplete = true;
				}
			}
		}
		
		// if there is only one bot, then just print how fast it completed its tasks
		if (botTracker.getRobotRoster().size() == 1) {
			ui.printSingleRobot(botTracker.getRobotRoster().get(0));
		} else {
		
		// find which bot had the shortest combined eta and print that bot as the winner
		RobotImpl fastestBot = null;
		int fastestTime = 10000000;
		for (RobotImpl bot : botTracker.getRobotRoster()) {
			if (bot.getTotalTime() < fastestTime) {
					fastestBot = bot;
			}
		}
		ui.printWinner(fastestBot);
	     }
	}

}

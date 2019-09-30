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
		for (int i = 0; i < botTracker.getRobotRoster().size(); i++) {
			botTracker.getRobotRoster().get(i).start();	
		}
		
		

	}

}
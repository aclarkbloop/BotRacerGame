package package_o_bots;

import java.util.HashMap;
import java.util.Scanner;

public class BotGame {

	public static void main(String[] args) {
		BotTracker botTracker = new BotTracker();
		HashMap<String, String> botMap = new HashMap<String, String>();
		Scanner inputCollector = new Scanner(System.in);
		System.out.println("How many robots would you like to build?");
		int numOfBots = inputCollector.nextInt();
		for (int i = 0; i < numOfBots; i++) {
			System.out.println("Pick a type of robot:");
			System.out.println("unipedal\nbipedal\nquadrapedal\nradial");
			String type = inputCollector.next();
			System.out.println("Great! Now give your bot a name!");
			String name = inputCollector.next();
			botMap.put(type, name);
		}
		BotFactory factory = new BotFactory(botMap, botTracker);
		for (int i = 0; i < botTracker.getRobotRoster().size(); i++) {
			System.out.println(botTracker.getRobotRoster().get(i).getBotName() + ", " +
					(botTracker.getRobotRoster().get(i).getBotType()));
		}
		
		

	}

}
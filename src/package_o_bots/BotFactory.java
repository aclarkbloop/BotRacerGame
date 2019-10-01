package package_o_bots;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import package_o_bots.Robot.RobotType;

public class BotFactory {
	
	HashMap<String, String> robotParts;
	
	public BotFactory(HashMap<String, String> robotParts, BotTracker tracker, BotGameUI ui) {
		this.robotParts = robotParts;
		
		// loops over the map of robot fields to construct each robot of the correct type
		for (Map.Entry<String,String> entry : robotParts.entrySet()) {
			// add each new robot to the tracker object passed in
			tracker.addRobot(buildNewBot(entry.getKey(), entry.getValue(), ui));
		}
	}
	
	/* buildNewBot() determines type of robot by using the string passed in from user preferences and
	 *  matches it with the correct enum value. Then creates an instance
	 *  of a robot of that type.
	 */
	public RobotImpl buildNewBot(String type, String name, BotGameUI ui) {
		switch (type) {
        case "unipedal": 
        	return new UnipedalBot(name, createTaskList(), ui);
        case "bipedal": 
        	return new BipedalBot(name, createTaskList(), ui);
        case "aeronautical": 
        	return new AeronauticalBot(name, createTaskList(), ui);
        case "quadrupedal": 
        	return new QuadrupedalBot(name, createTaskList(), ui);
        case "radial": 
        	return new RadialBot(name, createTaskList(), ui);
        case "arachnid":
        	return new ArachnidBot(name, createTaskList(), ui);
        }
		// if user hits cancel button then close the program
		System.exit(0);
		throw new IllegalArgumentException("User did not make a selection.");
     }
	
	
	/* creates task list for each robot by generating random integers from 0-9
	 *  and matching those to numbers in Task class
	 */
	public Task[] createTaskList() {
		Task[] taskList = new Task[5];
		Random random_int = new Random();
		for (int i = 0; i < 5; i++) {
			taskList[i] = new Task(random_int.nextInt(10));
		}
		return taskList;
	}

}

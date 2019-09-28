package package_o_bots;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import package_o_bots.Robot.RobotType;

public class BotFactory {
	
	HashMap<String, String> robotParts;
	
	public BotFactory(HashMap<String, String> robotParts, BotTracker tracker) {
		this.robotParts = robotParts;
		for (Map.Entry<String,String> entry : robotParts.entrySet()) {
			tracker.addRobot(buildNewBot(entry.getKey(), entry.getValue()));
		}
	}
	
	public RobotImpl buildNewBot(String type, String name) {
		switch (type) {
        case "unipedal": 
        	return new UnipedalBot(name, createTaskList());
        case "bipedal": 
        	return new BipedalBot(name, createTaskList());
        case "aeronautical": 
        	return new AeronauticalBot(name, createTaskList());
        case "quadrupedal": 
        	return new QuadrupedalBot(name, createTaskList());
        case "radial": 
        	return new RadialBot(name, createTaskList());
        case "arachnid":
        	return new ArachnidBot(name, createTaskList());
        }
		throw new IllegalArgumentException("There exists no robot of the given type :(");
     }
	
	
	public Task[] createTaskList() {
		Task[] taskList = new Task[5];
		Random random_int = new Random();
		for (int i = 0; i < 5; i++) {
			taskList[i] = new Task(random_int.nextInt(10));
		}
		return taskList;
	}

}

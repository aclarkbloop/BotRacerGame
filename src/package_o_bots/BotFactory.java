package package_o_bots;

import java.util.HashMap;
import java.util.Map;

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
        	return new UnipedalBot(name);
        case "bipedal": 
        	return new BipedalBot(name);
        case "aernautical": 
        	return new AeronauticalBot(name);
        case "quadrupedal": 
        	return new QuadrupedalBot(name);
        case "radial": 
        	return new RadialBot(name);
        case "arachnid":
        	return new ArachnidBot(name);
        }
		throw new IllegalArgumentException("There exists no robot of the given type :(");
     }

}

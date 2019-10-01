package package_o_bots;

import java.util.ArrayList;

// class encapsulates an ArrayList to keep track of all robots in the current game

public class BotTracker {
	
	ArrayList<RobotImpl> robotRoster;
	
	public BotTracker() {
		robotRoster = new ArrayList<RobotImpl>();
	}
	
	public void addRobot(RobotImpl newBot) {
		robotRoster.add(newBot);
	}
	
	public ArrayList<RobotImpl> getRobotRoster() {
		return robotRoster;
	}

}

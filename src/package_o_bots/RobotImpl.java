package package_o_bots;

public class RobotImpl implements Robot {
	
	String botName;
	RobotType botType;
	
	
	public RobotImpl(String name) {
		this.botName = name;
	}
	
	public String getBotName() {
		return this.botName;
	}
	
	public RobotType getBotType() {
		return this.botType;
	}
	
	

}

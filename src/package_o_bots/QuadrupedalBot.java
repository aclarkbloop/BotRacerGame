package package_o_bots;

public class QuadrupedalBot extends RobotImpl{
	
	String botName;
	
	public QuadrupedalBot(String name) {
		super(name);
		this.botType = RobotType.QUADRUPEDAL;
	}

}

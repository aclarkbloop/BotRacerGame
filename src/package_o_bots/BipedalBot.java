package package_o_bots;

public class BipedalBot extends RobotImpl{
	
	String botName;
	
	public BipedalBot(String name) {
		super(name);
		this.botType = RobotType.BIPEDAL;
	}

}

package package_o_bots;

public class AeronauticalBot extends RobotImpl{
	
	String botName;
	
	public AeronauticalBot(String name) {
		super(name);
		this.botType = RobotType.AERONAUTICAL;
	}

}

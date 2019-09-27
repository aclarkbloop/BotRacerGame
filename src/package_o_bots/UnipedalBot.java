package package_o_bots;

public class UnipedalBot extends RobotImpl {
	
	String botName;
	
	public UnipedalBot(String name) {
		super(name);
		this.botType = RobotType.UNIPEDAL;
	}

}

package package_o_bots;

public class UnipedalBot extends RobotImpl {
	
	String botName;
	
	public UnipedalBot(String name, Task[] taskList) {
		super(name, taskList);
		this.botType = RobotType.UNIPEDAL;
	}

}

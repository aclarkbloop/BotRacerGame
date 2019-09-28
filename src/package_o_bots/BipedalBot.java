package package_o_bots;

public class BipedalBot extends RobotImpl{
	
	String botName;
	
	public BipedalBot(String name, Task[] taskList) {
		super(name, taskList);
		this.botType = RobotType.BIPEDAL;
	}

}

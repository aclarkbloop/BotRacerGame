package package_o_bots;

public class QuadrupedalBot extends RobotImpl{
	
	String botName;
	
	public QuadrupedalBot(String name, Task[] taskList) {
		super(name, taskList);
		this.botType = RobotType.QUADRUPEDAL;
	}

}

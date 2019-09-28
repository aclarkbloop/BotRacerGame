package package_o_bots;

public class ArachnidBot extends RobotImpl{

	String botName;
	
	public ArachnidBot(String name, Task[] taskList) {
		super(name, taskList);
		botType = RobotType.ARACHNID;
	}
}

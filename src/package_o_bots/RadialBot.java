package package_o_bots;

public class RadialBot extends RobotImpl {
	
	String botName;
	
	public RadialBot(String name, Task[] taskList) {
		super(name, taskList);
		this.botType = RobotType.RADIAL;
	}

}

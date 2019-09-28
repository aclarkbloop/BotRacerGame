package package_o_bots;

public class AeronauticalBot extends RobotImpl{
	
	public AeronauticalBot(String name, Task[] taskList) {
		super(name, taskList);
		this.botType = RobotType.AERONAUTICAL;
		
	}

}

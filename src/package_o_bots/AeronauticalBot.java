package package_o_bots;

import javax.swing.JFrame;

public class AeronauticalBot extends RobotImpl{
	
	public AeronauticalBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		this.botType = RobotType.AERONAUTICAL;
		
	}

}

package package_o_bots;

import javax.swing.JFrame;

public class QuadrupedalBot extends RobotImpl{
	
	String botName;
	
	public QuadrupedalBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		this.botType = RobotType.QUADRUPEDAL;
	}

}

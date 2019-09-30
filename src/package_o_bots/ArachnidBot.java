package package_o_bots;

import javax.swing.JFrame;

public class ArachnidBot extends RobotImpl{
	
	public ArachnidBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		botType = RobotType.ARACHNID;
	}
}

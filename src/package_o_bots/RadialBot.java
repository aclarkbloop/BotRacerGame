package package_o_bots;

import javax.swing.JFrame;

public class RadialBot extends RobotImpl {
	
	String botName;
	
	public RadialBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		this.botType = RobotType.RADIAL;
	}

}

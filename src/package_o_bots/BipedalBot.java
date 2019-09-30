package package_o_bots;

import javax.swing.JFrame;

public class BipedalBot extends RobotImpl{
	
	public BipedalBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		this.botType = RobotType.BIPEDAL;
	}

}

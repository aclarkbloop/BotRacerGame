package package_o_bots;

import javax.swing.JFrame;

public class UnipedalBot extends RobotImpl {
	
	String botName;
	
	public UnipedalBot(String name, Task[] taskList, BotGameUI ui) {
		super(name, taskList, ui);
		this.botType = RobotType.UNIPEDAL;
	}

}

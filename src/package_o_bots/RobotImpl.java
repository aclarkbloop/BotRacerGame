package package_o_bots;

import javax.swing.JFrame;

public class RobotImpl extends Thread implements Robot {
	
	String botName;
	RobotType botType;
	Task[] taskList;
	BotGameUI ui;
	
	
	public RobotImpl(String name, Task[] taskList, BotGameUI ui) {
		this.taskList = taskList;
		this.botName = name;
		this.ui = ui;
	}
	
	public String getBotName() {
		return this.botName;
	}
	
	public RobotType getBotType() {
		return this.botType;
	}
	
	public Task[] getTaskList() {
		return this.taskList;
	}
	
	public BotGameUI getUI() {
		return this.ui;
	}
	
	// robot completes their tasks one by one and their thread sleeps for the duration of the eta of the task.
	public void run() {
		for (int i = 0; i < getTaskList().length; i++) {
			try {
				Thread.sleep(getTaskList()[i].getEta());
				ui.printTaskCompletions(getTaskList()[i], this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ui.printWinner(this);
	}
	
	public int getTotalTime() {
		int totalTime = 0;
		for (int i = 0; i < taskList.length; i++) {
			totalTime += taskList[i].getEta();
		}
		return totalTime;
	}
	
	

}

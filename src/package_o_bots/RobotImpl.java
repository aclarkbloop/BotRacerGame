package package_o_bots;

public class RobotImpl implements Robot {
	
	String botName;
	RobotType botType;
	Task[] taskList;
	
	
	public RobotImpl(String name, Task[] taskList) {
		this.taskList = taskList;
		this.botName = name;
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
	
	public int performTasks() throws InterruptedException {
		int totalTime = 0;
		for (int i = 0; i < taskList.length; i++) {
			Thread.sleep(taskList[i].getEta());
			totalTime += taskList[i].getEta();
		}
		return totalTime;
	}
	
	

}

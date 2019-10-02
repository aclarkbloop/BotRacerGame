package package_o_bots;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

// RobotImpl extends Thread so that multiple robots may work on their tasks simultaneously and be in a 'race' to complete them
public class RobotImpl extends Thread implements Robot {
	
	String botName;
	RobotType botType;
	Task[] taskList;
	BotGameUI ui;
	Color color;
	
	
	// Encapsulates the current UI in order to manipulate it from RobotImpl
	public RobotImpl(String name, Task[] taskList, BotGameUI ui) {
		this.taskList = taskList;
		this.botName = name;
		this.ui = ui;
	}
	
	// set after Robots are constructed from main method
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getRobotColor() {
		return this.color;
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
				// if one thread is preventing another from continuing we throw an exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// returns the sum of all the task's etas on the robot's list
	public int getTotalTime() {
		int totalTime = 0;
		for (int i = 0; i < taskList.length; i++) {
			totalTime += taskList[i].getEta();
		}
		return totalTime;
	}
	
	

}

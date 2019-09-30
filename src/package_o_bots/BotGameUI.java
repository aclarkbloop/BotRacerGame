package package_o_bots;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BotGameUI {
	
	JFrame uiFrame;
	JPanel mainPanel;
	
	
	
	
	public BotGameUI() {
		this.uiFrame = new JFrame();
		uiFrame.setBackground(Color.PINK);
		uiFrame.setTitle("Bot Game");
		uiFrame.setSize(1000, 800);
		this.mainPanel = new JPanel();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.PINK);
		
		JLabel title = new JLabel("Bot Racer 1.0");
		title.setFont(new Font("Courier", Font.BOLD,75));
		title.setBackground(Color.PINK);
		mainPanel.add(title);
		
		uiFrame.add(mainPanel);
		
		uiFrame.setVisible(true);
	}
	
	public int getNumBots() {
		JFrame frame = new JFrame();
		Integer[] possibilities = {1, 2, 3, 4};
		Integer numOfBots = (Integer)JOptionPane.showInputDialog(
                frame,
                "How many robots would you like to build?",
                "Customized Dialog",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "1");
		if (numOfBots == null) { numOfBots = 1; }
		return numOfBots;
	}
	
	public HashMap<String, String> getRobotParts(int numRobots) {
		JFrame frame = new JFrame();
		HashMap<String, String> botParts = new HashMap<String, String>();
		String[] possibilities = {"unipedal", "bipedal", 
				"quadrupedal", "radial", "arachnid", "aeronautical"};
		for (int i = 0; i < numRobots; i++) {
			String robotType = (String)JOptionPane.showInputDialog(
                    frame,
                    "Please choose type of robot #" + (i+1),
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "unipedal");
			if (robotType == null) { robotType = "unipedal"; }
			String name = (String)JOptionPane.showInputDialog(
                    frame,
                    "Please name robot #" + (i+1),
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
			if (name == null) { robotType = "bloop"; }
			botParts.put(robotType, name);
		}
		return botParts;
		
	}
	
	public void printBotInfo(BotTracker robotTracker) {
		String info = "";
		for (RobotImpl bot : robotTracker.getRobotRoster()) {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			info = bot.getBotName() + " the " + bot.getBotType() + " Bot";
			JLabel botInfo = new JLabel(info);
			panel.add(botInfo);
			for (Task task : bot.getTaskList()) {
				info = task.getDescription() + "\n";
				JLabel tasks = new JLabel(info);
				panel.add(tasks);
			}
			mainPanel.add(panel);
			mainPanel.updateUI();
		}
		
	}
	
	public void printWinner(RobotImpl robot) {
		JLabel winner = new JLabel(robot.getBotName() + " the " + robot.getBotType() + 
				" robot finished their tasks in " + robot.getTotalTime() + " milliseconds!", 
				SwingConstants.CENTER);
		mainPanel.add(winner);
		mainPanel.updateUI();
	}
	
	public void printTaskCompletions(Task task, RobotImpl robot) {
		JLabel taskComplete = new JLabel(robot.getBotName() + " just completed task: " +
				task.getDescription() + " in " + task.getEta() + "milliseconds!", SwingConstants.CENTER);
		taskComplete.setFont(new Font("Courier", Font.BOLD,15));
		mainPanel.add(taskComplete);
		mainPanel.updateUI();
	}
	
	
}
	
	
	
	




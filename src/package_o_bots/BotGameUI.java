package package_o_bots;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		uiFrame.setSize(1100, 600);
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
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		for (RobotImpl bot : robotTracker.getRobotRoster()) {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			info = bot.getBotName() + " the " + bot.getBotType() + " Bot";
			JLabel botInfo = new JLabel(info);
			botInfo.setFont(new Font("Courier", Font.BOLD,15));
			panel.add(botInfo);
			for (int i = 0; i < bot.getTaskList().length; i++) {
				info = (i + 1) + ". " + bot.getTaskList()[i].getDescription() + "\n";
				JLabel tasks = new JLabel(info);
				tasks.setFont(new Font("Courier", Font.BOLD,10));
				panel.add(tasks);
			}
			infoPanel.add(panel);
			infoPanel.add(Box.createHorizontalStrut(30));
			infoPanel.updateUI();
		}
		mainPanel.add(infoPanel);
		mainPanel.updateUI();
		
	}
	
	public void printWhenFinished(RobotImpl robot) {
		JLabel done = new JLabel(robot.getBotName() + " the " + robot.getBotType() + 
				" robot finished their tasks in " + robot.getTotalTime() + "  milliseconds!", 
				SwingConstants.CENTER);
		mainPanel.add(done);
		mainPanel.updateUI();
	}
	
	public void printTaskCompletions(Task task, RobotImpl robot) {
		JLabel taskComplete = new JLabel(robot.getBotName() + " just completed task: " +
				task.getDescription() + " in " + task.getEta() + "milliseconds!", SwingConstants.CENTER);
		taskComplete.setFont(new Font("Courier", Font.BOLD, 15));
		mainPanel.add(taskComplete);
		mainPanel.updateUI();
	}
	
	public void printWinner(RobotImpl bot) {
		JLabel winnerLabel = new JLabel(bot.getBotName() + " the " + bot.getBotType() + " bot finished their chores the fastest!");
		winnerLabel.setFont(new Font("Courier", Font.BOLD, 25));
		JPanel winnerPanel = new JPanel();
		winnerPanel.add(winnerLabel);
		mainPanel.add(winnerPanel);
		mainPanel.updateUI();
	}
	
	public void insertGIF() {
		URL url = BotGameUI.class.getResource("robotGif.gif");
		ImageIcon imageIcon = new ImageIcon(url);
		JLabel label = new JLabel(imageIcon);
		mainPanel.add(label);
	}
	
	
}
	
	
	
	




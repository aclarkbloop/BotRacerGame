package package_o_bots;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
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
	
	// constructor sets up the basic layout of the game board by setting a JFrame and a main JPanel
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
	
	// prompts user with a dialog box to choose 1-4 robots to create
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
	
	// prompts user with a dialog box to choose the type and name of each of their robots
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
			// if user does not choose a type, set to unipedal
			if (robotType == null) { robotType = "unipedal"; }
			String name = (String)JOptionPane.showInputDialog(
                    frame,
                    "Please name robot #" + (i+1),
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
			// if user does not choose a name, set default name to "bloop #1, #2 etc."
			if (name == null) { robotType = "bloop #" + (i+1); }
			botParts.put(robotType, name);
		}
		return botParts;
		
	}
	
	// Creates panels to hold bot name, type, and their task list
	public void printBotInfo(BotTracker robotTracker) {
		String info = "";
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new FlowLayout());
		
		for (RobotImpl bot : robotTracker.getRobotRoster()) {
			JPanel panel = new JPanel();
			panel.setBackground(bot.getRobotColor());
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
	
	// when a bot finishes a task, print to the ui which task and how long it took them
	public void printTaskCompletions(Task task, RobotImpl robot) {
		JLabel taskComplete = new JLabel(robot.getBotName() + " just completed task: " +
				task.getDescription() + " in " + task.getEta() + " milliseconds!");
		taskComplete.setFont(new Font("Courier", Font.BOLD, 15));
		taskComplete.setBackground(robot.getRobotColor());
		taskComplete.setOpaque(true);
		mainPanel.add(taskComplete);
		mainPanel.updateUI();
	}
	
	// if a user only chooses to create one bot, notify them when the bot has finished all tasks
	public void printSingleRobot(RobotImpl bot) {
		JLabel botLabel = new JLabel(bot.getBotName() + " the " + bot.getBotType() + " bot finished all their chores!");
		botLabel.setFont(new Font("Courier", Font.BOLD, 25));
		JPanel botPanel = new JPanel();
		botPanel.add(botLabel);
		mainPanel.add(botPanel);
		mainPanel.updateUI();
	}
	
	// if multiple bots are in competition, notify the user who the winner is
	public void printWinner(RobotImpl bot) {
		JLabel winnerLabel = new JLabel(bot.getBotName() + " the " + bot.getBotType() + " bot finished their chores the fastest!");
		winnerLabel.setFont(new Font("Courier", Font.BOLD, 25));
		JPanel winnerPanel = new JPanel();
		winnerPanel.add(winnerLabel);
		mainPanel.add(winnerPanel);
		mainPanel.updateUI();
	}
	
	public void closeGame() {
		System.exit(0);
	}
}
	
	
	
	




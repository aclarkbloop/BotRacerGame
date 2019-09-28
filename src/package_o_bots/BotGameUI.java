package package_o_bots;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BotGameUI {
	
	JFrame uiFrame;
	
	
	
	public BotGameUI() {
		this.uiFrame = new JFrame();
		uiFrame.setTitle("Bot Game");
		uiFrame.setDefaultCloseOperation(uiFrame.EXIT_ON_CLOSE);
		uiFrame.setSize(800, 500);
		JLabel titleLabel = new JLabel("Bot Racer 1.0", SwingConstants.CENTER);
		titleLabel.setBackground(Color.PINK);
		JButton startButton = new JButton("Start");
		startButton.setFont(new Font("Courier", Font.BOLD,40));
		titleLabel.add(startButton);
		titleLabel.setFont(new Font("Courier", Font.BOLD,75));
		uiFrame.add(titleLabel, SwingConstants.CENTER);
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
                    "Please choose a type of robot: ",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "unipedal");
			if (robotType == null) { robotType = "unipedal"; }
			String name = (String)JOptionPane.showInputDialog(
                    frame,
                    "Please name your robot: ",
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
	
	public void printWinner(RobotImpl robot) {
		JLabel winner = new JLabel(robot.getBotName() + " the " + robot.getBotType() + 
				" robot finished their tasks in " + robot.getTotalTime() + " milliseconds!", 
				SwingConstants.CENTER);
		uiFrame.add(winner);
	}
	
}
	
	
	
	




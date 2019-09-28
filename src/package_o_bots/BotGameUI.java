package package_o_bots;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotGameUI {
	
	JFrame uiFrame;
	
	
	
	public BotGameUI() {
		this.uiFrame = new JFrame();
		uiFrame.setTitle("Bot Game");
		uiFrame.setLocationRelativeTo(null);
		uiFrame.setSize(800, 500);
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
			String name = (String)JOptionPane.showInputDialog(
                    frame,
                    "Please name your robot: ",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
			
			botParts.put(robotType, name);
		}
		return botParts;
		
	}
	
}
	
	
	
	




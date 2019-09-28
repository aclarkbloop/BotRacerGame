package package_o_bots;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BotGameUI {
	
	JFrame uiFrame;
	JComboBox<String> botTypeBox;
	
	
	
	public BotGameUI() {
		this.uiFrame = new JFrame();
		uiFrame.setTitle("Bot Game");
		uiFrame.setLocationRelativeTo(null);
		uiFrame.setSize(800, 500);
		this.botTypeBox = setRoboOptions();
		setTextBox();
		uiFrame.setVisible(true);
		
	}
	
	public JComboBox<String> setRoboOptions() {
		String[] botTypes = {"unipedal", "bipedal", "quadrapedal", "radial", 
				"arachnid", "aeronautical"};
		JLabel label = new JLabel("Robot Types:");
		final JPanel comboPanel = new JPanel();
		botTypeBox = new JComboBox<String>(botTypes);
		comboPanel.add(label);
		comboPanel.add(botTypeBox);
		comboPanel.setVisible(true);
		uiFrame.add(comboPanel, BorderLayout.WEST);
		return botTypeBox;
	}
	
	public void setTextBox() {
		JTextField nameBox = new JTextField("Enter a name for your robot: ");
		nameBox.setVisible(true);
		uiFrame.add(nameBox, BorderLayout.CENTER);
	}
	
}
	
	
	
	




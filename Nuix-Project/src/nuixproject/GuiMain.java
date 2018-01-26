package nuixproject;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiMain {
	
	private static JFrame FRAME;
	private static JPanel PANEL;
	
	public void createWindow() {
		FRAME = new JFrame("Nuix Program Thingy");
		FRAME.setSize(500, 300);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.setVisible(true);
		
		PANEL = new JPanel();
		FRAME.add(PANEL);
		
		JLabel label = new JLabel("This should be true or false: ");
		PANEL.add(label);
		
		String[] trueFalse = {"yes", "no"};
		
		JComboBox<String> option1 = new JComboBox<String>(trueFalse);
		PANEL.add(option1);
	}
}

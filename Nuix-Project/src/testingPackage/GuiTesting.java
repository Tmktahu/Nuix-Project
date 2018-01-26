package testingPackage;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTesting {
	
	private static JFrame FRAME;
	private static JPanel PANEL;
	private static JButton EXECUTE_BUTTON;
	private static int count = 0;
	
	public void createWindow() {
		//frame things
		FRAME = new JFrame("Nuix Program Thingy of Coolness");
		FRAME.setSize(400, 500);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//over-arching panel
		PANEL = new JPanel();
		PANEL.setLayout(new BoxLayout(PANEL, BoxLayout.Y_AXIS));
		FRAME.add(PANEL);
		
		//valid settings lists
		String[] yesNo = {"yes", "no"};
		String[] OcrFiletype = {".pdf", ".tiff"};
		String[] OcrQuality = {"high", "medium", "fast"};
		
		
		
		//[tasks] section title --------------------------------------------
		PANEL.add(createSectionTitle("Tasks to be Completed"));
		
		//first label and options : search_tag
		PANEL.add(createOption("search_tag", yesNo));
		
		//second label and option : email_tag
		PANEL.add(createOption("email_tag", yesNo));
		
		//third label and option : ocr
		PANEL.add(createOption("ocr", yesNo));
		
		//fourth label and option : export
		PANEL.add(createOption("export", yesNo));
		//end [tasks] section ----------------------------------------------
		
		
		//[ocr] section title ----------------------------------------------
		PANEL.add(createSectionTitle("OCR Settings"));
		
		//first label and options : filetype
		PANEL.add(createOption("filetype", OcrFiletype));
		
		//second label and option : quality
		PANEL.add(createOption("quality", OcrQuality));
		
		//third label and option : only_unsearchable
		PANEL.add(createOption("only_searchable", yesNo));
		//end [ocr] section ------------------------------------------------
		
		
		
		//[export] section title -------------------------------------------
		PANEL.add(createSectionTitle("Export Settings"));
		
		//first option : summary
		PANEL.add(createOption("summary", yesNo));
		
		//second option : kws_export
		PANEL.add(createOption("kws_esport", yesNo));
		//end [export] section ---------------------------------------------
		
		
		
		
		EXECUTE_BUTTON = new JButton("Execute");
		PANEL.add(EXECUTE_BUTTON);
		EXECUTE_BUTTON.addActionListener(new ExecuteHandler());
		EXECUTE_BUTTON.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		FRAME.setVisible(true);
	}
	
	private JPanel createOption(String optionName, String[] optionList) {
		JPanel panel = new JPanel();
		JLabel optionLabel = new JLabel(optionName + ":");
		panel.add(optionLabel);
		JComboBox<String> options = new JComboBox<String>(optionList);
		panel.add(options);
		return panel;
	}
	
	private JPanel createSectionTitle(String sectionName) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(sectionName);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(label);
		return panel;
	}
	
	private class ExecuteHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			count++;
			EXECUTE_BUTTON.setText("I've been clicked " + count + " times!");
			
		}
		
	}

}

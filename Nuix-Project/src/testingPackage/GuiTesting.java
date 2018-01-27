package testingPackage;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
			List<Component> allComponents = getAllComponents(PANEL);
			
			//create a new array of strings to store the config values in
			String[] configValues = new String[9];
			//initiate the count
			int configCount = 0;
			//for each component in the list
			for (Component item : allComponents) {
				//if it is a dropdown-list
				if(item instanceof JComboBox) {
					//snag the selected value of the dropdown and store it in the array
					configValues[configCount] = ((JComboBox)item).getSelectedItem().toString();
					configCount++; //then add 1 to the count
				}
			}
			
		
			for (int i = 0; i < configValues.length; i++) {
		         if (i > 0) {
		            System.out.print(", ");
		         }
		         System.out.print(configValues[i]);
		    }
			System.out.println(" ");
			
		}
		
	}
	
	public List<Component> getAllComponents(final Container c) {
		Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}

}

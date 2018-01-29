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

import nuixproject.Dispatcher;

public class GuiTesting {
	
	private static Dispatcher DISPATCHER_OBJECT;
	private static JFrame FRAME;
	private static JPanel PANEL;
	private static JButton EXECUTE_BUTTON;
	private static int count;
	
	public GuiTesting(Dispatcher logicObject) { //constructor
		DISPATCHER_OBJECT = logicObject;
		count = 0;
	}
	
	
	
	public void createWindow() {
		//create the frame, name it, set it's size, and set the exit operation
		FRAME = new JFrame("Nuix Program Thingy of Coolness");
		FRAME.setSize(400, 500);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make the master panel, set it's layout to BoxLayout, add it to the frame
		PANEL = new JPanel();
		PANEL.setLayout(new BoxLayout(PANEL, BoxLayout.Y_AXIS));
		FRAME.add(PANEL);
		
		//these are lists that will be used as options for dropdown lists
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
		
		
		
		//make the button, add it to the panel, add our custom action listener, set its alignment
		EXECUTE_BUTTON = new JButton("Execute");
		PANEL.add(EXECUTE_BUTTON);
		EXECUTE_BUTTON.addActionListener(new ExecuteHandler());
		EXECUTE_BUTTON.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//NOW set the frame to be visible
		FRAME.setVisible(true);
	}
	
	private JPanel createOption(String optionName, String[] optionList) { //create a dropdown option with a title
		JPanel panel = new JPanel(); //make a panel
		JLabel optionLabel = new JLabel(optionName + ":"); //make a label and name it
		panel.add(optionLabel); //add the label to the panel first
		JComboBox<String> options = new JComboBox<String>(optionList); //make the dropdown list with the given list of options
		panel.add(options); //add it to the panel
		return panel; //return the panel
	}
	
	private JPanel createSectionTitle(String sectionName) { //create a section title (really just for easy formatting and so I don't have to type the same thing over and over again)
		JPanel panel = new JPanel(); //make the panel
		JLabel label = new JLabel(sectionName); //make the label and name it
		label.setFont(new Font("Arial", Font.BOLD, 16)); //set the fancy font
		panel.add(label); //add the label to the panel
		return panel; //return the panel
	}
	
	private class ExecuteHandler implements ActionListener { //this is for the execute button
		
		public void actionPerformed(ActionEvent e) {
			count++;
			EXECUTE_BUTTON.setText("I've been clicked " + count + " times!");
			List<Component> allComponents = getAllComponents(PANEL);
			
			
			String[] configValues = new String[9]; //create a new array of strings to store the config values in
			int configCount = 0; //initiate the count
			
			for (Component item : allComponents) { //for each component in the list
				if(item instanceof JComboBox) { //if it is a dropdown-list
					configValues[configCount] = ((JComboBox)item).getSelectedItem().toString(); //snag the selected value of the dropdown and store it in the array
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
			
			
			//so how do I get the process running?
			//how about, I use a set method to take these values and send them to another object, then I can call a function in that object to do the stuff
			//this means I need a 'logic' object.
			
		}
		
	}
	
	public List<Component> getAllComponents(final Container c) { //a method I found online to grab all components in a swing GUI
		Component[] comps = c.getComponents(); //get all components in the current container
	    List<Component> compList = new ArrayList<Component>(); //make a new arrayList
	    for (Component comp : comps) { //for each component we found
	        compList.add(comp); //add it to the arrayList
	        if (comp instanceof Container) //and if that component is a container itself,
	            compList.addAll(getAllComponents((Container) comp)); //recursively call this function on that component, adding it's results to the arrayList
	    }
	    return compList; //once we are all done, return the arrayList
	}

}

package nuixproject;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import nuix.Utilities;

public class GuiMain {
	
	//private Dispatcher dispatcherObject;
	private HashMap<String, String> settingsMap;
	private JFrame frame;
	private JPanel panel;
	private JButton executeButton;
	private int count;
	private JTextArea logBox;
	
	public GuiMain(Utilities utilities) { //constructor
		//dispatcherObject = new Dispatcher(); //create our dispatcher
		settingsMap = new HashMap<String, String>(); //create the settingsMap
		count = 0;
	}
	
	
	public void createWindow() {
		//create the frame, name it, set it's size, and set the exit operation
		frame = new JFrame("Nuix Program Thingy of Coolness");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make the master panel, set it's layout to BoxLayout, add it to the frame
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		
		//these are lists that will be used as options for dropdown lists
		String[] yesNo = {"yes", "no"};
		String[] OcrFiletype = {".pdf", ".tiff"};
		String[] OcrQuality = {"high", "medium", "fast"};
		
		
		//[tasks] section title --------------------------------------------
		panel.add(createSectionTitle("Tasks to be Completed"));
		
		//first label and options : search_tag
		panel.add(createOption("search_tag", yesNo));
		
		//second label and option : email_tag
		panel.add(createOption("email_tag", yesNo));
		
		//third label and option : ocr
		panel.add(createOption("ocr", yesNo));
		
		//fourth label and option : export
		panel.add(createOption("export", yesNo));
		//end [tasks] section ----------------------------------------------
		
		
		//[ocr] section title ----------------------------------------------
		panel.add(createSectionTitle("OCR Settings"));
		
		//first label and options : filetype
		panel.add(createOption("filetype", OcrFiletype));
		
		//second label and option : quality
		panel.add(createOption("quality", OcrQuality));
		
		//third label and option : only_unsearchable
		panel.add(createOption("only_searchable", yesNo));
		//end [ocr] section ------------------------------------------------
		
		
		//[export] section title -------------------------------------------
		panel.add(createSectionTitle("Export Settings"));
		
		//first option : summary
		panel.add(createOption("summary", yesNo));
		
		//second option : kws_export
		panel.add(createOption("kws_esport", yesNo));
		//end [export] section ---------------------------------------------
		
		
		logBox = new JTextArea(); //create our textArea
		logBox.setText("Application Log:\n");
		logBox.setEditable(false);
		logBox.setLineWrap(true);
		logBox.setWrapStyleWord(true);
		javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(logBox); //make a scrollPane for clarity
		scrollPane.setPreferredSize(new java.awt.Dimension(10, 200));
		panel.add(scrollPane); //add the scrollPane to the master panel
		
		
		//make the button, add it to the panel, add our custom action listener, set its alignment
		executeButton = new JButton("Execute");
		panel.add(executeButton);
		executeButton.addActionListener(new ExecuteHandler());
		executeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//NOW set the frame to be visible
		frame.setVisible(true);
	}
	
	public void logAction(String input) {
		logBox.append(input + "\n");
	}
	
	private JPanel createOption(String optionName, String[] optionList) { //create a dropdown option with a title
		JPanel panel = new JPanel(); //make a panel
		JLabel optionLabel = new JLabel(optionName + ":"); //make a label and name it
		panel.add(optionLabel); //add the label to the panel first
		JComboBox<String> options = new JComboBox<String>(optionList); //make the dropdown list with the given list of options
		options.setName(optionName); //set the name for identification later
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
			executeButton.setText("I've been clicked " + count + " times!");
			List<Component> allComponents = getAllComponents(panel);
			
			
			for (Component item : allComponents) { //for each component in the list

				if(item instanceof JComboBox) { //if it is a dropdown-list
					settingsMap.put(((JComboBox<?>)item).getName(), ((JComboBox<?>)item).getSelectedItem().toString());

				}
			}
		
			System.out.println(java.util.Arrays.toString(settingsMap.entrySet().toArray()));

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

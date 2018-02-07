package nuixproject;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import nuix.Utilities;

import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Container;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Gui {
	
	private JFrame frame;
	private JTextField textField;
	private HashMap<String, String> settingsMap;
	private Utilities utilities;
	private Dispatcher dispatcher;
	private MyLogger logger;
	private JTextArea txtrApplicationLog;
	
	public Gui(Utilities utilitiesObject, MyLogger givenLogger) {
		logger = givenLogger;
		dispatcher = new Dispatcher(utilities, logger); //create our dispatcher
		settingsMap = new HashMap<String, String>(); //make the settings hashMap
		utilities = utilitiesObject; //save the utilities object
		
		initialize(); //call initialize
		frame.setVisible(true); //make the frame visible
	}
	
	private void initialize() {
		//string arrays for comboBox options
		String[] yesNo = {"yes", "no"};
		String[] OcrFiletype = {".pdf", ".tiff"};
		String[] OcrQuality = {"high", "medium", "fast"};
		
		frame = new JFrame(); //make the master frame
		frame.setResizable(false); //ditch resizablity because we want to use static locations
		frame.setBounds(100, 100, 937, 369); //set the position
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default close action
		frame.getContentPane().setLayout(null); //set the layout to null
		
		
		//=================== log box setup ===================
		JScrollPane scrollPane = new JScrollPane(); //make a scrollPane for the log
		scrollPane.setBounds(537, 21, 381, 305); //set the position
		frame.getContentPane().add(scrollPane); //add it to the frame
		
		txtrApplicationLog = new JTextArea(); //make the text area
		scrollPane.setViewportView(txtrApplicationLog); //add it to the scrollPane
		txtrApplicationLog.setText(getDate() + " | Application Log:\n");
		//logger.logAction(getDate() + " | Application Log:");
		//=================== end log box setup ===================
		
		
		//=================== task options setup ===================
		JLabel lblTasksTitle = new JLabel("Tasks to be Completed");
		lblTasksTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTasksTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTasksTitle.setBounds(34, 56, 184, 16);
		frame.getContentPane().add(lblTasksTitle);
		
		JLabel lblEmailTag = new JLabel("email_tag:");
		lblEmailTag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailTag.setBounds(15, 112, 101, 16);
		frame.getContentPane().add(lblEmailTag);
		
		JComboBox<String> comboBoxEmailTag = new JComboBox<>(yesNo);
		comboBoxEmailTag.setBounds(128, 80, 71, 27);
		comboBoxEmailTag.setName("email_tag");
		frame.getContentPane().add(comboBoxEmailTag);
		
		
		JLabel lblSearchtag = new JLabel("search_tag:");
		lblSearchtag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSearchtag.setBounds(15, 84, 101, 16);
		frame.getContentPane().add(lblSearchtag);
		
		JComboBox<String> comboBoxSearchTag = new JComboBox<>(yesNo);
		comboBoxSearchTag.setBounds(128, 108, 71, 27);
		comboBoxSearchTag.setName("search_tag");
		frame.getContentPane().add(comboBoxSearchTag);
		
		
		JLabel lblOcr = new JLabel("ocr:");
		lblOcr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOcr.setBounds(15, 140, 101, 16);
		frame.getContentPane().add(lblOcr);
		
		JComboBox<String> comboBoxOcr = new JComboBox<>(yesNo);
		comboBoxOcr.setBounds(128, 136, 71, 27);
		comboBoxOcr.setName("ocr");
		frame.getContentPane().add(comboBoxOcr);
		

		JLabel lblExport = new JLabel("export:");
		lblExport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExport.setBounds(15, 168, 105, 16);
		frame.getContentPane().add(lblExport);
		
		JComboBox<String> comboBoxExport = new JComboBox<>(yesNo);
		comboBoxExport.setBounds(128, 164, 71, 27);
		comboBoxExport.setName("export");
		frame.getContentPane().add(comboBoxExport);
		//=================== end task options setup ===================
		
		
		//=================== ocr options setup ===================
		JLabel lblOcrOptions = new JLabel("OCR Options");
		lblOcrOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcrOptions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblOcrOptions.setBounds(34, 210, 184, 16);
		frame.getContentPane().add(lblOcrOptions);
		
		JLabel lblFiletype = new JLabel("filetype:");
		lblFiletype.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFiletype.setBounds(15, 238, 105, 16);
		frame.getContentPane().add(lblFiletype);
		
		JComboBox<String> comboBoxFiletype = new JComboBox<>(OcrFiletype);
		comboBoxFiletype.setBounds(128, 234, 81, 27);
		comboBoxFiletype.setName("filetype");
		frame.getContentPane().add(comboBoxFiletype);
		
		JLabel lblQuality = new JLabel("quality:");
		lblQuality.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuality.setBounds(15, 266, 105, 16);
		frame.getContentPane().add(lblQuality);
		
		JComboBox<String> comboBoxQuality = new JComboBox<>(OcrQuality);
		comboBoxQuality.setBounds(128, 262, 101, 27);
		comboBoxQuality.setName("quality");
		frame.getContentPane().add(comboBoxQuality);
		
		JLabel lblOnlysearchable = new JLabel("only_searchable:");
		lblOnlysearchable.setBounds(15, 294, 105, 16);
		frame.getContentPane().add(lblOnlysearchable);
		
		JComboBox<String> comboBoxOnlySearchable = new JComboBox<>(yesNo);
		comboBoxOnlySearchable.setBounds(128, 290, 71, 27);
		comboBoxOnlySearchable.setName("only_searchable");
		frame.getContentPane().add(comboBoxOnlySearchable);
		
		comboBoxOcr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					if (e.getItem().equals("no")) {
						comboBoxFiletype.setEnabled(false);
						comboBoxQuality.setEnabled(false);
						comboBoxOnlySearchable.setEnabled(false);
						
					} else {
						comboBoxFiletype.setEnabled(true);
						comboBoxQuality.setEnabled(true);
						comboBoxOnlySearchable.setEnabled(true);
					}

				}
			}
		});
		//=================== end ocr options setup ===================
		
		
		//=================== export options setup ===================
		JLabel lblEcportOptions = new JLabel("Export Options");
		lblEcportOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcportOptions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEcportOptions.setBounds(265, 57, 168, 16);
		frame.getContentPane().add(lblEcportOptions);
		
		JLabel lblSummary = new JLabel("summary:");
		lblSummary.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSummary.setBounds(265, 84, 85, 16);
		frame.getContentPane().add(lblSummary);
		
		JComboBox<String> comboBoxSummary = new JComboBox<>(yesNo);
		comboBoxSummary.setBounds(362, 80, 71, 27);
		comboBoxSummary.setName("summary");
		frame.getContentPane().add(comboBoxSummary);
		
		JLabel lblKwsExport = new JLabel("kws_export:");
		lblKwsExport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKwsExport.setBounds(265, 112, 85, 16);
		frame.getContentPane().add(lblKwsExport);
		
		JComboBox<String> comboBoxKwsExport = new JComboBox<>(yesNo);
		comboBoxKwsExport.setBounds(362, 108, 71, 27);
		comboBoxKwsExport.setName("kws_export");
		frame.getContentPane().add(comboBoxKwsExport);
		//=================== end export options setup ===================
		

		//=================== file selector setup ===================
		textField = new JTextField();
		textField.setBounds(121, 18, 272, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSelectCase = new JLabel("Select Case:");
		lblSelectCase.setBounds(34, 23, 82, 16);
		frame.getContentPane().add(lblSelectCase);
		
		final JFileChooser fc = new JFileChooser();
		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            textField.setText(file.getPath());
		            //This is where a real application would open the file.
		            logger.logAction("Opening Case File: " + file.getPath());
		        } else {
		        		//logger.logAction("Canceled opening case file.");
		        }
			}
		});
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		button.setBounds(399, 18, 126, 26);
		frame.getContentPane().add(button);
		//=================== end file selector setup ===================
		
		//=================== separator setup ===================
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 43, 491, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(241, 56, 12, 270);
		frame.getContentPane().add(separator_1);
		//=================== end separator setup ===================
		
		//=================== execute button setup ===================
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here we take the input from the user and send it to the dispatcher
				logger.logAction("Setting up for execution");
				List<Component> allComponents = getAllComponents(frame);
				for (Component item : allComponents) { //for each component in the list
					if(item instanceof JComboBox) { //if it is a dropdown-list
						settingsMap.put(((JComboBox<?>)item).getName(), ((JComboBox<?>)item).getSelectedItem().toString());
					}
				}
				
				settingsMap.put("casePath", textField.getText());
				//System.out.println(java.util.Arrays.toString(settingsMap.entrySet().toArray()));
				//logger.logAction("Settings selected: " + java.util.Arrays.toString(settingsMap.entrySet().toArray()));
				
				boolean goodToGo = true;
				
				if(settingsMap.get("search_tag").equals("yes")) {
					//make a new dialog window asking for a path to a CSV file.
					logger.logAction("Getting Search-Tag CSV File from user.");
					int response = JOptionPane.showConfirmDialog(null, "Please select a CSV file for the search_tag function.", "Choose CSV", JOptionPane.YES_NO_OPTION);
					if(response == 0) { //if they choose to select a file
						JFileChooser fileChooser = new JFileChooser(); //make a file chooser
						
						int result = fileChooser.showDialog(null, "Select CSV"); //and let them select a file
						if (result == JFileChooser.APPROVE_OPTION) { //if they get one
				            String searchTagCsvPath = fileChooser.getSelectedFile().getPath(); //get the path they selected
				            JOptionPane.showMessageDialog(null, "You selected \"" + searchTagCsvPath + "\""); //tell them what they selected
				            logger.logAction("Search-Tag CSV File: \"" + searchTagCsvPath + "\"");
				            settingsMap.put("searchTagCsvPath", searchTagCsvPath); //and store it
				            
				        } else if (result == JFileChooser.CANCEL_OPTION) { //otherwise if they hit cancel
				            JOptionPane.showMessageDialog(null, "You selected nothing."); //say they did and cancel
				            goodToGo = false;
				            
				        } else if (result == JFileChooser.ERROR_OPTION) { //otherwise there was an error
				            JOptionPane.showMessageDialog(null, "An error occurred.");  
				            goodToGo = false;
				        }
						
					} else { //otherwise they decided not to select a file
						JOptionPane.showMessageDialog(null, "Canceling execution."); //so cancel execution
						goodToGo = false;
					}
				}
				//by this point we either have a false or they grabbed a file
				
				if(settingsMap.get("email_tag").equals("yes")) {
					//make a new dialog window asking for a path to a CSV file.
					logger.logAction("Getting Email-Tag CSV File from user.");
					int response = JOptionPane.showConfirmDialog(null, "Please select a CSV file for the email_tag function.", "Choose CSV", JOptionPane.YES_NO_OPTION);
					if(response == 0) { //if they choose to select a file
						JFileChooser fileChooser = new JFileChooser(); //make a file chooser
						
						int result = fileChooser.showDialog(null, "Select CSV"); //and let them select a file
						if (result == JFileChooser.APPROVE_OPTION) { //if they get one
				            String searchTagCsvPath = fileChooser.getSelectedFile().getPath(); //get the path they selected
				            JOptionPane.showMessageDialog(null, "You selected \"" + searchTagCsvPath + "\""); //tell them what they selected
				            logger.logAction("Email-Tag CSV File: \"" + searchTagCsvPath + "\"");
				            settingsMap.put("emailTagCsvPath", searchTagCsvPath); //and store it
				            
				        } else if (result == JFileChooser.CANCEL_OPTION) { //otherwise if they hit cancel
				            JOptionPane.showMessageDialog(null, "You selected nothing."); //say they did and cancel
				            goodToGo = false;
				            
				        } else if (result == JFileChooser.ERROR_OPTION) { //otherwise there was an error
				            JOptionPane.showMessageDialog(null, "An error occurred.");  
				            goodToGo = false;
				        }
						
					} else { //otherwise they decided not to select a file
						JOptionPane.showMessageDialog(null, "Canceling execution."); //so cancel execution
						goodToGo = false;
					}
				}
				//by this point we have covered the CSV files for search_tag and email_tag
				//we shouldn't require anything else from the user to execute
				
				if(goodToGo) {
					logger.logAction("Good to go. Beginning execution.");
					dispatcher.execute(settingsMap);
				}
			}
		});
		btnExecute.setBounds(328, 289, 117, 29);
		frame.getContentPane().add(btnExecute);
		//=================== end execute button setup ===================

	}
	
	private String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); //2016/11/16 12:08:43
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
	
	public void writeToLogScreen(String entry) {
		txtrApplicationLog.append(entry + "\n");
	}
}

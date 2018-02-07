package nuixproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLogger {
	
	private File logFile;
	private FileWriter fileWriter = null;
	private Gui theGui;
	
	public MyLogger() {
		try {
			logFile = new File(getFullDateTime() + "_logFile.log"); //create the file object
			logFile.createNewFile(); //and create it
			fileWriter = new FileWriter(logFile); //make the fileWriter
			fileWriter.write(getFullDateTime() + " | Application Log:\n"); //and initiate the log file
			
		} catch (IOException e) {
			System.out.println("Error creating log and fileWriter: ");
			e.printStackTrace();
		}
	}
	
	public void setGui(Gui gui) {
		theGui = gui;
		//System.out.println(theGui.toString());
	}
	
	
	public void logAction(String entry) {
		try {
			fileWriter.write(getTime() + entry + "\n");
			theGui.writeToLogScreen(getTime() + entry);
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("Error writing entry to log file: ");
			e.printStackTrace();
		}
	}
	
	public void closeLog() {
		try {
			fileWriter.close();
	
		} catch (IOException e) {
			System.out.println("Error closing log file: ");
			e.printStackTrace();
		}
	}
	
	private String getFullDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); //2016/11/16 12:08:43
	}
	
	private String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - ");
		Date date = new Date();
		return dateFormat.format(date); //2016/11/16 12:08:43
	}
}

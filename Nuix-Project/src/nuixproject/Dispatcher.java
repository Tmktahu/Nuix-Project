package nuixproject;

import java.util.HashMap;

import nuix.Case;
import nuix.Utilities;

public class Dispatcher {
	//so this dispatcher should be able to:
		//translate GUI settings into usable values, stored in a global variable
		//take those settings and determine what tasks need to be performed and in what order
		//execute those tasks via am Operations object.
	
	//set up our global variables
	private MyLogger logger;
	private Information information;
	private Support support;
	private Operations operator;
	
	@SuppressWarnings("unused")
	private Case currentCase;
	
	
	public Dispatcher(Utilities utilities, MyLogger givenLogger) { //constructor
		logger = givenLogger;
		information = new Information();
		support = new Support(utilities, information, logger);
		operator = new Operations(support, logger);
	}
	
	public void execute(HashMap<String, String> settings) {
		
		//first, open the case
		String casePath = settings.get("casePath");
		currentCase = support.open_target_case(casePath);
		
		
		
		//here lets do the search_tag action
		logger.logAction("Beginning Search-Tag operation.");
		if(settings.get("search_tag").equals("yes")) { //if they want to do a search_tag
			String csvPath = settings.get("searchTagCsvPath");
			operator.search_tag(csvPath);
		}
		
		//perform the email_tag action
		logger.logAction("Beginning Email-Tag operation.");
		if(settings.get("email_tag").equals("yes")) { //if they want to do a search_tag
			String csvPath = settings.get("emailTagCsvPath");
			operator.email_tag(csvPath);
		}
		
		//perform ocr
		logger.logAction("Beginning OCR operation.");
		if(settings.get("ocr").equals("yes")) { //if they want to do a search_tag
			String fileType = settings.get("filetype");
			String quality = settings.get("quality");
			String only_searchable = settings.get("only_searchable");
			operator.ocr(fileType, quality, only_searchable);
		}
		
		//perform export
		logger.logAction("Beginning export operation.");
		if(settings.get("export").equals("yes")) { //if they want to do a search_tag
			String summary = settings.get("summary");
			String kws_export = settings.get("kws_export");
			operator.export(summary, kws_export);
		}
		
		
		//so what is the goal?
		//well we want to sit down and perform the tasks selected in order.
		//so what tasks are there?
		
			//searching the data set for keywords from the given .csv file and apply the given tags
		
			//search the data set and tag emails that are to/from addresses given in a .csv file
		
			//perform OCR
		
			//export something
		
		
		//IF you want to run OCR, you can choose these options:
			//what file types you want to OCR (pdf or tiff)
			//what quality level you want
			//do you want to limit OCR to non-searchable items only?
		
		
		
		
	}
	
	public void setSettings(HashMap<String, String> rawSettings) {
		//so here we are given the raw settings as taken from the GUI
		//yes-no should be converted to boolean values
		
		//so how do we want to do this?
			//we want our own array of final values. we can identify what setting is what based on position in the array because we have a set GUI giving us the info
			//so we have two arrays, and depending on the value of each entry in the first array, set a value in the second array
		//what type should the second array be??
		//if I want to store multiple types of values like strings, ints, and booleans, then the array type needs to be a 
				//its not an array. it's a Map

		//screw it. we aren't converting the values over. instead if we need to check a yes/no then we'll do a string.equals()
			//I'm doing this because I don't want to make a generic HashMap<String, Object> and then type everything we pull out of it. It feels sloppy and messy.
		
		
		//so, assuming we now have the settings,
			//we need to perform tasks in the right order with the settings provided. 
		
		//how do we manage the order of tasks to be completed??
		
		
		
		
	}
}

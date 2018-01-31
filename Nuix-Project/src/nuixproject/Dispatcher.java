package nuixproject;

import java.util.HashMap;

import nuix.Utilities;

public class Dispatcher {
	//so this dispatcher should be able to:
		//translate GUI settings into usable values, stored in a global variable
		//take those settings and determine what tasks need to be performed and in what order
		//execute those tasks via am Operations object.
	
	//set up our global variables
	private Information information;
	private Support support;
	private Operations operator;
	
	
	public Dispatcher(Utilities utilities) { //constructor
		information = new Information();
		support = new Support(utilities, information);
		operator = new Operations(support);
	}
	
	public void execute(HashMap<String, String> rawSettings) {
		
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

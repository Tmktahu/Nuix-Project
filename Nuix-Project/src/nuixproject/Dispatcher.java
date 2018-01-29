package nuixproject;

import java.util.HashMap;

public class Dispatcher {
	//so this dispatcher should be able to:
		//translate GUI settings into usable values, stored in a global variable
		//take those settings and determine what tasks need to be performed and in what order
		//execute those tasks via am Operations object.
	
	//set up our global variables
	private static Operations operator;
	
	public Dispatcher() { //constructor
		
	}
	
	public void setSettings(String[] rawSettings) {
		//so here we are given the raw settings as taken from the GUI
		//yes-no should be converted to boolean values
		
		//so how do we want to do this?
			//we want our own array of final values. we can identify what setting is what based on position in the array because we have a set GUI giving us the info
			//so we have two arrays, and depending on the value of each entry in the first array, set a value in the second array
		//what type should the second array be??
		//if I want to store multiple types of values like strings, ints, and booleans, then the array type needs to be a 
				//its not an array. it's a Map
		
		//make a new hashMap for storing the converted settings
		HashMap<String, Object> settingsMap = new HashMap<String, Object>();
		
		
		
		
	}
}

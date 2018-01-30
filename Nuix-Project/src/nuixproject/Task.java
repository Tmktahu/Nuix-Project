package nuixproject;

public class Task {
	//this class is for constructing Tasks that need to be completed.
	
	//sp what kinds of generic information should be in a "Task"?
	
	private static String TASK_NAME;
	private static int TASK_PRIORITY;
	
	
	public Task() { //constructor
		TASK_NAME = "empty";
		TASK_PRIORITY = 0;
	}
	
	
	//================= get/set methods =====================
	
	public Boolean setName(String input) {
		//we don't really need to check anything here
		TASK_NAME = input;
		return true;
	}
	
	public String getName() {
		return TASK_NAME;
	}
	
	public Boolean setPriority(int input) {
		if(input >= 0) {
			TASK_PRIORITY = input;
			return true;
		} else {
			return false;
		}
	}
	
	public int getPriority() {
		return TASK_PRIORITY;
	}

}

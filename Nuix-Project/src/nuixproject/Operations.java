package nuixproject;

import java.util.HashMap;

import nuix.Utilities;
import nuix.BulkAnnotater;

public class Operations {
	
	private static Support SUPPORT;

	
	public Operations(Support supportObject) {

	}
	
	public void email_tag() {
		
	}
	
	public void export() {
		
	}
	
	public void ocr() {
		
	}
	
	public void priv_emails() {
		
	}
	
	public void search_tag() {
		//Search all items using each query from the query-tag .csv and and apply the corresponding tag.
		System.out.println("Searching and tagging all items.");
		
		HashMap<String, String> tagMap;
		
		try {
			tagMap = SUPPORT.open_qt_csv(); //go get the hashmap
			for (HashMap.Entry<String, String> entry : tagMap.entrySet()) { //for each row (aka item in the map
				String query = entry.getKey(); //grab the query (first thing)
				String tag = entry.getValue(); //grab the tag to be set (second thing)
				
				BulkAnnotater bulkAnnotater = SUPPORT.getUtilities().getBulkAnnotater(); //=========figure out what this does
				
				System.out.println("Searching for \"" + query + ".\"");
				System.out.println("Tagging \"" + tag + ".\"");
				bulkAnnotater.addTag(tag, currentCase.search(query)); //submit the query with the current case
				System.out.println("Finished searching and tagging.");
			}
				
		} catch (Exception e) {
			System.out.println("Failed to search and tag all items due to error: " + e);
			
		} finally {
			System.out.println("Finished searching and tagging all items.");
		}
	}
}

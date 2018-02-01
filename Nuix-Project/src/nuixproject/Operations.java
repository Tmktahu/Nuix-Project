package nuixproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nuix.BulkAnnotater;
import nuix.Case;
import nuix.Item;
import nuix.OcrProcessor;

public class Operations {
	
	private Support support;
	private Case targetCase;

	
	public Operations(Support supportObject) {
		support = supportObject;
		//open the target case
		targetCase = supportObject.getCase();
	}
	
	public void email_tag(String csvPath) {
		search_tag(csvPath);
	}
	
	public void export() {
		
	}
	
	public void ocr(String filetype, String qualityChoice, String nonSearchable) {
		//Perform OCR on files of the specified extension.
		String searchability = null;
		String modifier = null;
		if (nonSearchable.equals("yes")) {
			searchability = "non-searchable";
			modifier = " AND NOT content:*";
		} //should I else different values for those two strings? --------------------------------------------------------------------
		
		System.out.println("Starting OCR processing for " + searchability + " " + filetype + " files.");
		try {
			List<Item> selection = targetCase.search("mime-type:application/" + filetype.replace(".", "") + modifier);
			OcrProcessor ocrProc = support.getUtilities().createOcrProcessor();
			Map<String, String> settingsMap = new HashMap<String, String>();
			settingsMap.put("quality", qualityChoice);
			
			
			ocrProc.process(selection, settingsMap); //("quality" : qual_choice, 'updateText' : str(update_text)});
			
		} catch (Exception e) {
			System.out.println("Failed OCR processing for " + searchability + " " + filetype + " files due to error: " + e);
	
		} finally {
			System.out.println("Finished OCR processing for " + searchability + " " + filetype + " files.");
		}
		// ocr reload evidence stores: use custom metadata or seearch fields
	}
	
	public void priv_emails() {
		
	}
	
	public void search_tag(String csvPath) {
		//Search all items using each query from the query-tag .csv and and apply the corresponding tag.
		System.out.println("Searching and tagging all items.");
		
		HashMap<String, String> tagMap;
		
		try {
			tagMap = support.open_qt_csv(csvPath); //go get the hashMap
			if(tagMap != null) {
				for (HashMap.Entry<String, String> entry : tagMap.entrySet()) { //for each row (aka item in the map
					String query = entry.getKey(); //grab the query (first thing)
					String tag = entry.getValue(); //grab the tag to be set (second thing)
					
					BulkAnnotater bulkAnnotater = support.getUtilities().getBulkAnnotater(); //=========figure out what this does
					
					System.out.println("Searching for \"" + query + ".\"");
					System.out.println("Tagging \"" + tag + ".\"");
					bulkAnnotater.addTag(tag, targetCase.search(query)); //submit the query with the current case
					System.out.println("Finished searching and tagging.");
				}
			}
				
		} catch (Exception e) {
			System.out.println("Failed to search and tag all items due to error: " + e);
			
		} finally {
			System.out.println("Finished searching and tagging all items.");
		}
	}
}

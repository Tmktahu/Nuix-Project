package nuixproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nuix.BulkAnnotater;
import nuix.Case;
import nuix.Item;
import nuix.OcrProcessor;
import nuix.BatchExporter;

public class Operations {
	
	private MyLogger logger;
	private Support support;
	private Case targetCase;

	
	public Operations(Support supportObject, MyLogger givenLogger) {
		logger = givenLogger;
		support = supportObject;
		//open the target case
		targetCase = supportObject.getCase();
	}
	
	public void email_tag(String csvPath) {
		search_tag(csvPath);
	}
	
	public void export(String summary, String kws_export) {
		//Export the selected items.
		//System.out.println("Exporting selected items.");
		logger.logAction("Exporting selected items.");
		try {
			Set<String> all_tags = targetCase.getAllTags(); //first get all the tags
			for (String tag : all_tags) { //for each tag we got
				//System.out.println("Exporting items tagged as \"" + tag + "\"."); //say we are exporting
				logger.logAction("Exporting items tagged as \"" + tag + "\".");
				BatchExporter batch_exp = support.getUtilities().createBatchExporter("G:\\test\\" + tag + "\\"); //+ str(datetime.date) + "_" + tag + "\\"); //make the batch exporter with the path we want
				
				HashMap<String, String> native_settings = new HashMap<String, String>(); //make a hasmap for the settings
				native_settings.put("naming", "item_name"); //assemble the settings
				
				batch_exp.addProduct("native",native_settings); //add a product to the exporter
				//batch_exp.addProduct("pdf");
				//batch_exp.addProduct("xhtml_report");
				//batch_exp.addProduct("thumbnail");
				
				List<Item> items = targetCase.search("tag:" + tag); //search for the tag we are exporting and grab the items
				batch_exp.exportItems(items); //then export them
			}
			
		} catch (Exception e) {
			//System.out.println("There was an error exporting: " + e);
			logger.logAction("There was an error exporting: " + e);
		}

			//export status:
			//exporter = utilities.createBatchExporter(export_dir);
			//exportjob = exporter.exportItemsAsync(current_selected_items);
			//exportjob.getCurrentStage;

		// BatchExporter.addProduct("native", "text", "pdf", "tiff", "xhtml_report", "thumbnail")

		// BatchExporter.setStampingOptions(value="PRODUCTION_SET")

		// BatchExporter.setApplyHighlights

		// BatchExporter.exportItems(List<Item> items / ProductionSet productionSet)

		// afterExport(AfterExportCallback callback) {?print()?)

		// get all tags > for tag in tags > currentcase.search(tag) > new production set > list of production sets

		// for production set in list of production sets > multipleItemExporter.exportItems(ProductionSet productionSet, path to dest dir, map of options for export)
	}
	
	public void ocr(String filetype, String qualityChoice, String nonSearchable) {
		//Perform OCR on files of the specified extension.
		String searchability = null;
		String modifier = null;
		if (nonSearchable.equals("yes")) {
			searchability = "non-searchable";
			modifier = " AND NOT content:*";
		} //should I else different values for those two strings? --------------------------------------------------------------------
		
		//System.out.println("Starting OCR processing for " + searchability + " " + filetype + " files.");
		logger.logAction("Starting OCR processing for " + searchability + " " + filetype + " files.");
		try {
			List<Item> selection = targetCase.search("mime-type:application/" + filetype.replace(".", "") + modifier);
			OcrProcessor ocrProc = support.getUtilities().createOcrProcessor();
			Map<String, String> settingsMap = new HashMap<String, String>();
			settingsMap.put("quality", qualityChoice);
			
			
			ocrProc.process(selection, settingsMap); //("quality" : qual_choice, 'updateText' : str(update_text)});
			
		} catch (Exception e) {
			//System.out.println("Failed OCR processing for " + searchability + " " + filetype + " files due to error: " + e);
			logger.logAction("Failed OCR processing for " + searchability + " " + filetype + " files due to error: " + e);
	
		} finally {
			//System.out.println("Finished OCR processing for " + searchability + " " + filetype + " files.");
			logger.logAction("Finished OCR processing for " + searchability + " " + filetype + " files.");
		}
		// ocr reload evidence stores: use custom metadata or seearch fields
	}
	
	public void priv_emails() {
		
	}
	
	public void search_tag(String csvPath) {
		//Search all items using each query from the query-tag .csv and and apply the corresponding tag.
		//System.out.println("Searching and tagging all items.");
		logger.logAction("Searching and tagging all items.");
		
		HashMap<String, String> tagMap;
		
		try {
			tagMap = support.open_qt_csv(csvPath); //go get the hashMap
			if(tagMap != null) {
				for (HashMap.Entry<String, String> entry : tagMap.entrySet()) { //for each row (aka item in the map
					String query = entry.getKey(); //grab the query (first thing)
					String tag = entry.getValue(); //grab the tag to be set (second thing)
					
					BulkAnnotater bulkAnnotater = support.getUtilities().getBulkAnnotater(); //=========figure out what this does
					
					//System.out.println("Searching for \"" + query + ".\"");
					logger.logAction("Searching for \"" + query + ".\"");
					//System.out.println("Tagging \"" + tag + ".\"");
					logger.logAction("Tagging \"" + tag + ".\"");
					bulkAnnotater.addTag(tag, targetCase.search(query)); //submit the query with the current case
					//System.out.println("Finished searching and tagging.");
					logger.logAction("Finished searching and tagging " + query + ":" + tag);
				}
			}
				
		} catch (Exception e) {
			//System.out.println("Failed to search and tag all items due to error: " + e);
			logger.logAction("Failed to search and tag all items due to error: " + e);
			
		} finally {
			//System.out.println("Finished searching and tagging all items.");
			logger.logAction("Finished searching and tagging all items.");
		}
	}
}

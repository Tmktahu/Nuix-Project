package nuixproject;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import nuix.Case;
import nuix.Utilities;

import com.opencsv.CSVReader;

public class Support {
	
	private MyLogger logger;
	private Case targetCase;
	private Utilities utilities;
	//private Information info;
	
	public Support(Utilities utilitiesObject, Information infoObject, MyLogger givenLogger) {
		logger = givenLogger;
		utilities = utilitiesObject;
		//info = infoObject;
	}
	
	
	public Case open_target_case(String casePath) {
		//System.out.println("Opening target case");
		logger.logAction("Opening target case.");
		
		try {
			targetCase = utilities.getCaseFactory().open(casePath);
			//System.out.println("Opened target case.");
			logger.logAction("Opened target case.");
			return targetCase;
			
		} catch (Exception e) {
			//System.out.println("Failed to open target case due to error: " + e);
			logger.logAction("Failed to open target case due to error " + e);
			return null;
			
		} finally {
			//System.out.println("Finished opening target case.");
			logger.logAction("Finished opening target case.");
		}
	}
	
	public void close_target_case() {
		//System.out.println("Closing target case");
		logger.logAction("Closing target case.");
		
		try {
			targetCase.close();
			
		} catch (Exception e) {
			//System.out.println("Failed to close target case due to error: " + e);
			logger.logAction("Failed to close target case due to error: " + e);
			
		} finally {
			//System.out.println("Finished closing target case.");
			logger.logAction("Finished closing target case.");
		}
	}
	
	public HashMap<String, String> open_qt_csv(String filePath) {
		//System.out.println("Opening the query-tag .csv file.");
		logger.logAction("Opening the query-tag .csv file.");
		
		try {
			//here we take a given csv file and we read it into a 2D array called 'reader', then we return that array.
			//target.csv is term,term\n for each entry
			HashMap<String, String> csvMap = new HashMap<String, String>();	
					
			// === Here we are using OpenCSV ===
			CSVReader csvReader = new CSVReader(new FileReader(new File(filePath))); //create the reader from the path

			String[] nextLine; //declare the nextLine array
			while ((nextLine = csvReader.readNext()) != null) { //get the next line in the file and while it isn't null
				csvMap.put(nextLine[0], nextLine[1]); //put the first element of that line as the key and the second as the value into the map
		     }
	
			csvReader.close(); //close the reader when we are done
			
			return csvMap; //return the map
					
		} catch (Exception e) {
			//System.out.println("Something was wrong with the CSV file provided for the search-tag function. Check the given path.");
			logger.logAction("Something was wrong with the CSV file provided for the search-tag function. Check the given path.");
			//System.out.println("Failed to open query-tag .csv file due to error: " + e);
			logger.logAction("Failed to open query-tag .csv file due to error: " + e);
			return null;
			
		} finally {
			//System.out.println("Finished opening the query-tag .csv file.");
			logger.logAction("Finished opening the query-tag .csv file.");
		}
	}
	
	public Utilities getUtilities() {
		return utilities;
	}
	
	public Case getCase() {
		return targetCase;
	}

}

/*
class Support:
	"""Casefile-related support functions."""
	def open_target_case(self):
		"""Open the target case."""
		print("Opening target case.")
		try:
			targetCase = utilities.caseFactory.open('E:/10.11.17_case_copy_for_testing')
			print("Opened target case.")
		except:
			print("Failed to open target case due to error: ")
			raise
		finally:
			print("Finished opening target case.")

	def close_target_case(self):
		"""Close the target case."""
		print("Closing target case.")
		try:
			targetCase.close()
		except:
			print("Failed to close target case due to error: ")
			raise
		finally:
			print("Finished closing target case.")

	def open_qt_csv(self):
		"""Open the .csv query-tag file."""
		print("Opening the query-tag .csv file.")
		try:
			reader = csv.DictReader(open('C:\\Users\\' + info.username + '\\Documents\\Nuix Searches\\target.csv', 'r')) 
			return reader
		except:
			print("Make sure that the file exists in \"C:\\Users\\Main\\Documents\\Nuix Searches\\\" and is named \"target.csv.\"")
			print("Failed to open query-tag .csv file due to error:")
			raise
		finally:
			print("Finished opening the query-tag .csv file.")
*/
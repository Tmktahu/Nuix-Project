package nuixproject;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import nuix.Case;
import nuix.Utilities;
import nuix.CaseFactory;

import com.opencsv.CSVReader;

public class Support {
	
	private static Case TARGET_CASE;
	private static Utilities utilities;
	private static Information info;
	
	public Support(Utilities utilitiesObject, Information infoObject) {
		utilities = utilitiesObject;
		info = infoObject;
	}
	
	
	public void open_target_case() {
		System.out.println("Opening target case");
		
		try {
			TARGET_CASE = utilities.getCaseFactory().open("E:/10.11.17_case_copy_for_testing");
			System.out.println("Opened target case.");
			
		} catch (Exception e) {
			System.out.println("Failed to open target case due to error: " + e);
			
		} finally {
			System.out.println("Finished opening target case.");
		}
	}
	
	public void close_target_case() {
		System.out.println("Closing target case");
		
		try {
			TARGET_CASE.close();
			
		} catch (Exception e) {
			System.out.println("Failed to close target case due to error: " + e);
			
		} finally {
			System.out.println("Finished closing target case.");
		}
	}
	
	public String[][] open_qt_csv() {
		System.out.println("Opening the query-tag .csv file.");
		
		try {
			//here we take a given csv file and we read it into a 2D array called 'reader', then we return that array.
			//target.csv is term,term\n for each entry
					
					
			// === Here we are using OpenCSV ===
			// assemble the file path
			String targetFile = "C:\\Users\\";// + info.username + "\\Documents\\Nuix Searches\\target.csv";
			// create the reader
			CSVReader csvReader = new CSVReader(new FileReader(new File(targetFile)));
			// make a list and read everything into it
			List<String[]> list = csvReader.readAll();

			// make a 2D array of the correct size
			String[][] dataArr = new String[list.size()][];
			// convert the list to an array
			dataArr = list.toArray(dataArr);		
			
			//return the array
			return dataArr;
			
					
		} catch (Exception e) {
			System.out.println("Make sure that the file exists in \"C:\\Users\\Main\\Documents\\Nuix Searches\\\" and is named \"target.csv.\"");
			System.out.println("Failed to open query-tag .csv file due to error:");
			return null;
		} finally {
			System.out.println("Finished opening the query-tag .csv file.");
		}
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
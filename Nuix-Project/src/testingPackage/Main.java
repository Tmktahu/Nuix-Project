package testingPackage;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import org.ini4j.Ini;

public class Main {
	public static void main(String[] args) {
		String[][] testArray = open_qt_csv();
		
		System.out.println(Arrays.deepToString(testArray));
		
		//System.out.print(testArray[0][0]); System.out.println(testArray[0][1]); 
		//System.out.print(testArray[1][0]); System.out.println(testArray[1][1]);
		
		
		Ini testIni = readIniFile();
		
		String envTarget_Case = testIni.get("environment", "target_case");
		
		System.out.println("Env target_case: " + envTarget_Case);
		System.out.println("Tasks email_tag: " + testIni.get("tasks", "email_tag"));
		System.out.println("Export blarg: " + testIni.get("export", "blarg"));
		//bad values return null
		System.out.println(testIni.get("tasks"));
		System.out.println(testIni.get("bleh"));
		
		//returns null on bad section
		
		GuiTesting theGui = new GuiTesting();
		theGui.createWindow();
		
		
		
		
	}
	
	public static Ini readIniFile() {
		try {
			Ini iniFile = new Ini(new File("/Users/main/eclipse-workspace/Nuix-Project/src/testingPackage/config.ini"));
			
			return iniFile;
		} catch (Exception e) {
			System.out.println("There was an error reading the ini file: " + e);
			return null;
		}
	}
	
	public static String[][] open_qt_csv() {
		System.out.println("Opening the query-tag .csv file.");
		
		try {
			//here we take a given csv file and we read it into a 2D array called 'reader', then we return that array.
			//target.csv is term,term\n for each entry
					
			// === Here we are using OpenCSV ===
			// assemble the file path
			//String targetFile = "C:\\Users\\" + info.username + "\\Documents\\Nuix Searches\\target.csv";
			String targetFile = "/Users/main/eclipse-workspace/Nuix-Project/src/testingPackage/target.csv";
			// create the reader
			CSVReader csvReader = new CSVReader(new FileReader(new File(targetFile)));
			// make a list and read everything into it
			List<String[]> list = csvReader.readAll();

			// make a 2D array of the correct size
			String[][] dataArr = new String[list.size()][];
			// convert the list to an array
			dataArr = list.toArray(dataArr);		
			
			csvReader.close();
			
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

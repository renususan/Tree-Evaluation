/** Class that reads the input txt file and makes a data set
 * @author Renu Thomas
 * @Date 07/21/2014
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaHW63DataSet {

	private ArrayList<JavaHW63DataRow> dataRowArray = new ArrayList<JavaHW63DataRow>();
	int numIndependentVars, numRows;

	public JavaHW63DataSet(String dataFile) {

		try {

			Scanner sc = new Scanner(new File(dataFile));
			boolean parsedFirstLine = false;
			while (sc.hasNextLine()) {
				if (!parsedFirstLine) { // reads the first row and sets the
										// number of rows and independent
										// variables
					String[] firstLineSplit = sc.nextLine().split("\\s+");
					numIndependentVars = Integer.valueOf(firstLineSplit[0]);
					numRows = Integer.valueOf(firstLineSplit[1]);
					parsedFirstLine = true;
				} else { // reads all other rows
					String[] string = sc.nextLine().split("\\s+");
					JavaHW63DataRow dtRowArray = new JavaHW63DataRow();
					dtRowArray.setyValue(Double.valueOf(string[0]));
					for (int i = 1; i < string.length; i++) {
						dtRowArray.addXValue(Double.valueOf(string[i]));
					}
					addDataRowArray(dtRowArray);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void addDataRowArray(JavaHW63DataRow dtRowArray) {
		dataRowArray.add(dtRowArray);
	}

	public ArrayList<JavaHW63DataRow> getDataSet() {
		return dataRowArray;

	}

	public int getNumIndependentVars() {
		return numIndependentVars;
	}

}

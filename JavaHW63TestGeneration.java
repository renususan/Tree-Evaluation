/**
 * @author Renu Thomas
 * @Date 07/21/2014
 */
import java.util.Random;
import java.util.Scanner;


public class JavaHW63TestGeneration {
	static int numIndepVars = 0;
	static int maxDepth = 3;
	static Random rand = new Random();

	public static void main(String[] args) {
		JavaHW63Node[] ops = { new JavaHW63Plus(), new JavaHW63Minus(),
				new JavaHW63Multiply(), new JavaHW63Divide() };

		Scanner keyboard = new Scanner(System.in);
		System.out
				.println("Enter the path of the file to be read , ex: \"C:\\Users\\xyz\\Desktop\\text.txt\"\n");
		String filePath = keyboard.nextLine();
		JavaHW63DataSet dataSet = new JavaHW63DataSet(filePath);

		// getting the number of independent variables
		numIndepVars = dataSet.getNumIndependentVars();

		JavaHW63OperatorFactory o = new JavaHW63OperatorFactory(ops);
		JavaHW63TerminalFactory t = new JavaHW63TerminalFactory(numIndepVars);
		JavaHW63Generation generation = new JavaHW63Generation(500, o, t,
				maxDepth, rand);
		generation.evalAll(dataSet);
		// generation.printGeneration();
		generation.printBestTree();
		keyboard.close();

	}

}

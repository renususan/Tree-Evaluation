/**Encapsulates the root node of a tree
 * @author Renu Thomas
 * @Date 07/21/2014
 */
import java.util.ArrayList;
import java.util.Random;

public class JavaHW63GPTree {
	private JavaHW63Node root;
	//private int mySize;

	JavaHW63GPTree() {
		root = null;
	}

	JavaHW63GPTree(JavaHW63OperatorFactory o, JavaHW63TerminalFactory t,
			int maxDepth, Random rand) {
		root = o.getOperator(rand);
		root.addRandomKids(o, t, maxDepth, rand);
	}

	public String toString() {
		return root.toString();
	}

	/** Evaluates each tree in the generation and returns the result
	 * @param JavaHW63DataSet dataSet
	 * @return double sumResult
	 */
	public double eval(JavaHW63DataSet dataSet) {
		ArrayList<JavaHW63DataRow> dataSetArray = dataSet.getDataSet();
		double eachResult = 0;
		double sumResult=0;
		for (int i = 0; i < dataSetArray.size(); i++) {
			JavaHW63DataRow dataRow = dataSetArray.get(i);
			double yValue = dataRow.getyValue();
			double[] data = new double[dataRow.getXValue().size()];
			for (int j = 0; j < dataRow.getXValue().size(); j++) {
				data[j] = (Double) dataRow.getXValue().get(j);
			}
			eachResult=Math.pow(root.eval(data)-yValue,2);
			sumResult+=eachResult;
		}
		return sumResult;

	}
	// The following requires that you add the mySize() method
	// to Node and all its subclasses. Try it!
	// public int mySize() { return root.mySize(); }
}

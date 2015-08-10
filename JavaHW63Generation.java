/** A container of GPTrees. */
/**
 * @author Renu Thomas
 *
 */
import java.text.DecimalFormat;
import java.util.Random;

public class JavaHW63Generation {
	private int numTrees;
	private JavaHW63GPTree[] population;
	private double[] fitness;

	/**
	 * Specifies the number of GPTrees in this generation, the factories used to
	 * generate the individual trees, the maximum tree depth, and the Random
	 * object used.
	 */
	JavaHW63Generation(int numTrees, JavaHW63OperatorFactory o,
			JavaHW63TerminalFactory t, int m, Random r) {
		this.numTrees = numTrees;
		population = new JavaHW63GPTree[numTrees];
		fitness = new double[numTrees];
		for (int i = 0; i < numTrees; i++)
			population[i] = new JavaHW63GPTree(o, t, m, r);
	}

	JavaHW63Generation(int n) {
		numTrees = n;
		population = new JavaHW63GPTree[numTrees];
		fitness = new double[numTrees];
	}

	/**
	 * Evaluate each tree in this generation, and set each tree's fitness value.
	 */
	public void evalAll(JavaHW63DataSet theData) {
		int i;
		double sumEachTree = 0;
		for (i = 0; i < numTrees; i++) {
			sumEachTree = getTree(i).eval(theData);
			fitness[i] = Double.valueOf(sumEachTree);
		}

	}

	public JavaHW63GPTree getTree(int i) {
		return population[i];
	}

	/** Prints the tree with the lowest fitness value. */
	public void printBestTree() {
		int minTreeIndex = 0;
		double previousValue = 0.0;
		for (int i = 0; i < fitness.length; i++) {
			if (i != 0) {
				if (fitness[i] < previousValue) {
					minTreeIndex = i;
					previousValue = fitness[i];
				}
			} else {
				previousValue = fitness[i];
			}

		}
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println();
		System.out.println(getTree(minTreeIndex) + " ,FITNESS = "
				+ df.format(fitness[minTreeIndex]));
	}

	public int getNumTrees() {
		return numTrees;
	}

	public void printGeneration() {
		DecimalFormat df = new DecimalFormat("#.##");
		for (int i = 0; i < numTrees; i++) {
			System.out.println(population[i] + " = " + df.format(fitness[i])+"-> FITNESS ");
		}
	}
}

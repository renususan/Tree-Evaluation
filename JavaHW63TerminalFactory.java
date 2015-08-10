/** class which gives a random terminal node
 * @author Renu
 * Date 07/15/2014
 */
import java.util.Random;

public class JavaHW63TerminalFactory {
	private int numIndepVars;

	JavaHW63TerminalFactory(int n) {
		numIndepVars = n;
	}

	/**
	 * to get randomly generated terminal node (can be a variable or a constant)
	 * @param Random
	 * @return JavaHW52Node
	 */
	public JavaHW63Node getTerminal(Random rand) {
		int min = 0;
		int max = numIndepVars;
		int randNumber = rand.nextInt((max - min) + 1) + min;
		if (randNumber < numIndepVars) {
			return new JavaHW63Variable(randNumber);
		}
		if (randNumber == numIndepVars) {
			double randConst = rand.nextDouble();
			return new JavaHW63Const(randConst);
		}

		return null;
	}

	public int getNumIndepVars() {
		return numIndepVars;
	}

}

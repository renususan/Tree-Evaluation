/**Class which returns a random operator
 * @author Renu Thomas
 * @Date 07/15/2014
 */
import java.util.Random;

public class JavaHW63OperatorFactory {
	private JavaHW63Node[] currentOps;

	JavaHW63OperatorFactory(JavaHW63Node[] n) {
		currentOps = n;
	}

	/**
	 * returns a random operator node
	 * 
	 * @param Random
	 * @return JavaHW52Node
	 */
	public JavaHW63Node getOperator(Random rand) {
		int randOperator = rand.nextInt(4);
		switch (randOperator) {
		case 0:
			return (JavaHW63Plus) currentOps[0].clone();
		case 1:
			return (JavaHW63Minus) currentOps[1].clone();
		case 2:
			return (JavaHW63Multiply) currentOps[2].clone();
		case 3:
			return (JavaHW63Divide) currentOps[3].clone();
		}
		return null;
	}

	public int getNumOps() {
		return currentOps.length;
	}
}

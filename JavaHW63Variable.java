/**
 * @author Renu Thomas
 * Date 07/15/2014
 */
import java.util.Random;

public class JavaHW63Variable extends JavaHW63Node {
	private double value;
	private int index;

	public JavaHW63Variable(double i) {
		index = (int) i;
	}

	public double eval(double data[]) {
		value = data[index];
		return value;
	}

	public String toString() {
		return String.valueOf("X" + index);
	}
	/** does not do anything since they are terminal nodes
	 */
	public void addRandomKids(JavaHW63OperatorFactory o,
			JavaHW63TerminalFactory t, int maxDepth, Random rand) {

	}
}

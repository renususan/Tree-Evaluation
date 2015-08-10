/**
 * @author Renu Thomas
 * @Date 07/15/2014
 */
import java.text.DecimalFormat;
import java.util.Random;

public class JavaHW63Const extends JavaHW63Node {
	private double value;

	public JavaHW63Const(double d) {
		DecimalFormat df = new DecimalFormat("#.##");
		value = Double.parseDouble(df.format(d));
	}

	public double eval(double[] data) {
		return value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public void addRandomKids(JavaHW63OperatorFactory o,
			JavaHW63TerminalFactory t, int maxDepth, Random rand) {

	}
}

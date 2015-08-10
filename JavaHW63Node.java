/**
 * @author Renu Thomas
 * @Date 07/15/2014
 */
import java.util.Random;
public abstract class JavaHW63Node implements Cloneable {
	public int depth;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public JavaHW63Node() {
	}

	public abstract double eval(double[] data);

	public abstract String toString();

	public abstract void addRandomKids(JavaHW63OperatorFactory o,
			JavaHW63TerminalFactory t, int maxDepth, Random rand);

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Class can't clone.");
		}
		return o;
	}
}

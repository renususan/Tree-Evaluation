/**
 * @author Renu Thomas
 * @Date 06/30/2014
 */
public class JavaHW63Divide extends JavaHW63Binop {
	public JavaHW63Divide(JavaHW63Node l, JavaHW63Node r) {
		super(l, r);
	}

	public JavaHW63Divide() {
		super();
	}

	public double eval(double data[]) {
		double divisor = rChild.eval(data);
		if (Math.abs(divisor) < 0.0001) {
			return 1.0;
		} else {
			return lChild.eval(data) / rChild.eval(data);
		}
	}

	/* append in the form (x / y) */
	public String toString() {
		return "(" + lChild.toString() + "/" + rChild.toString() + ")";
	}
}

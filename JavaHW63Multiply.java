/**
 * @author Renu Thomas
 * @Date 07/15/2014
 */
public class JavaHW63Multiply extends JavaHW63Binop{
	public JavaHW63Multiply(JavaHW63Node l, JavaHW63Node r) {
		super(l, r);
	}
	public JavaHW63Multiply() {
		super();
	}
	public double eval(double data[]) {
		
		return (lChild.eval(data) * rChild.eval(data));
	}
	/*append in the form (x * y) */
	public String toString() {
		return "(" + lChild.toString() + "*" + rChild.toString() + ")";
	}
}

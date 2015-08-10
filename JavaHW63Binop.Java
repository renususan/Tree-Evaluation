/**
 * @author Renu Thomas
 * Date 07/15/2014
 */
import java.util.Random;

public class JavaHW63Binop extends JavaHW63Node {
	protected JavaHW63Node lChild, rChild;

	public JavaHW63Binop(JavaHW63Node l, JavaHW63Node r) {
		lChild = l;
		rChild = r;

	}

	public JavaHW63Binop() {
	}

	public double eval(double[] data) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		return "";
	}

	/** to add random kids to nodes
	 * @param JavaHW52OperatorFactory,JavaHW52TerminalFactory,maxDepth,rand
	 * @return
	 */
	public void addRandomKids(JavaHW63OperatorFactory o,
			JavaHW63TerminalFactory t, int maxDepth, Random rand) {

		if (this.getDepth() == maxDepth) {
			lChild = t.getTerminal(rand);
			rChild = t.getTerminal(rand);
			lChild.setDepth(this.getDepth() + 1);
			rChild.setDepth(this.getDepth() + 1);
		} else {
			int min = 0;
			int max = t.getNumIndepVars() + o.getNumOps();
			int randNumber = rand.nextInt((max - min) + 1) + min;
			if (randNumber < o.getNumOps()) {
				lChild = o.getOperator(rand);
				rChild = o.getOperator(rand);
				lChild.setDepth(this.depth + 1);
				rChild.setDepth(this.depth + 1);
				lChild.addRandomKids(o, t, maxDepth, rand);
				rChild.addRandomKids(o, t, maxDepth, rand);

			} else {
				lChild = t.getTerminal(rand);
				rChild = t.getTerminal(rand);
				lChild.setDepth(this.getDepth() + 1);
				rChild.setDepth(this.getDepth() + 1);
			}

		}

	}
}

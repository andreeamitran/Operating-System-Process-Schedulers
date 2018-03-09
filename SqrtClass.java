//package tema;

/**
 * @author andreeam
 */
public class SqrtClass extends Task {
	/**
	 * Returneaza partea intreaga a radacinii modulului lui n.
	 * @param n
	 */
	public double Sqrt (int n) {
		if (n < 0) {
			n = n - (2 * n);
		}
		
		double x = Math.floor(Math.sqrt(n));
		
		return x;
	}
	
	public int retint (int n) {return 0;}
}

//package tema;

/**
 * @author andreeam
 */
public class FactorialClass extends Task {
	
	/**
	 * Calculeaza factorialul numarului primit ca parametru n
	 * si returneaza rezultatul impartit % 9973.
	 * @param n
	 */
	public int retint (int n) {
		if (n == 0)
			return 1;
		if (n < 1)
			return 0;
		
		int prod = 1;
		for (int i = 2; i <= n; i++) {
			prod *= i;
			prod = prod % 9973;
		}
		
		return prod;
	}
	
	public double Sqrt (int n) {return 0;}
}

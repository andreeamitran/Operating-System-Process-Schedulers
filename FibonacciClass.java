//package tema;

/**
 * @author andreeam
 */
public class FibonacciClass extends Task {
	
	/**
	 * Calculeaza al n-lea numar din sirul Fibonacci.
	 * Returneaza rezultatul impartit % 9973.
	 * @param n
	 */
	public int retint (int n) {
		if (n < 0)
			return -1;
		
		int a = 1, b = 1, c = 0;
		
		if (n == 1 || n == 2)
			return 1;
		
		for (int i = 2; i < n; i++) {
			c = a + b;
			c %= 9973;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	public double Sqrt (int n) {return 0;}
}

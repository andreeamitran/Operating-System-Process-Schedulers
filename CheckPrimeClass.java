//package tema;

/**
 * @author andreeam
 */
public class CheckPrimeClass extends Task {
	
	/**
	 * Verifica daca numarul primit ca parametru n este
	 * prim. Afiseaza 1 daca este prim si 0 in caz contrar.
	 * @param n
	 */
	public int retint (int n) {
		if (n < 2)
			return 0;
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0)
				return 0;
		}
		return 1;
	}
	
	public double Sqrt (int n) {return 0;}
}

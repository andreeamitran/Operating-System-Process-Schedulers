//package tema;

/**
 * @author andreeam
 */
public class NextPrimeClass extends Task {
	/**
	 * Cauta urmatorul numar prim mai mare ca n.
	 * @param n
	 * @return numar prim
	 */
	public int retint (int n) {
		//daca n e negativ, returneaza 2
		if (n < 2)
			return 2;
		int ok = 0, i = n + 1, verify;
		//cat timp nu s-a gasit numar prim
		while (ok == 0) {
			verify = 1;
			//verifica daca numarul curent este prim
			for (int j = 2; j <= i/2; j++) {
				if (i % j == 0)
					verify = 0;
			}
			//daca este prim se opreste din cautat
			if (verify == 1) {
				ok = 1;
				break;
			}
			i++;
		}
		
		return i;
	}
	
	public double Sqrt (int n) {return 0;}
}

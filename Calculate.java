//package tema;

/**
 * @author andreeam
 */
public class Calculate {
	/**
	 * Calculeaza si afiseaza rezultatul unui proces.
	 * @param str
	 * @param nr
	 * @param outfile
	 * @param location
	 */
	public void retOutput (String str, int nr, 
			HomeworkWriter outfile, String location) {
		
		if (str.equals("CheckPrime")) {
			CheckPrimeClass task = new CheckPrimeClass();
			outfile.println(Integer.toString(nr) + " " + str + 
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
		else if (str.equals("NextPrime")) {
			NextPrimeClass task = new NextPrimeClass();
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
		else if (str.equals("Fibonacci")) {
			FibonacciClass task = new FibonacciClass();
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
		else if (str.equals("Sqrt")) {
			SqrtClass task = new SqrtClass();
			int integer = (int)task.Sqrt(nr);
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(integer) + " " + location);
		}
		else if (str.equals("Square")) {
			SquareClass task = new SquareClass();
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
		else if (str.equals("Cube")) {
			CubeClass task = new CubeClass();
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
		else if (str.equals("Factorial")) {
			FactorialClass task = new FactorialClass();
			outfile.println(Integer.toString(nr) + " " + str +
			" " + Integer.toString(task.retint(nr)) + " " + location);
		}
	}
	
	/**
	 * Creeaza un obiect de tipul procesului trimis ca parametru
	 * si returneaza rezultatul numarului procesat.
	 * @param procType
	 * @param number
	 * @return result
	 */
	public int findResult (String procType, int number) {
		int result = 0;
		
		if (procType.equals("CheckPrime")) {
			CheckPrimeClass task = new CheckPrimeClass();
			result = task.retint(number);
		}
		else if (procType.equals("NextPrime")) {
			NextPrimeClass task = new NextPrimeClass();
			result = task.retint(number);
		}
		else if (procType.equals("Fibonacci")) {
			FibonacciClass task = new FibonacciClass();
			result = task.retint(number);
		}
		else if (procType.equals("Sqrt")) {
			SqrtClass task = new SqrtClass();
			result = (int)task.Sqrt(number);
		}
		else if (procType.equals("Square")) {
			SquareClass task = new SquareClass();
			result = task.retint(number);
		}
		else if (procType.equals("Cube")) {
			CubeClass task = new CubeClass();
			result = task.retint(number);
		}
		else if (procType.equals("Factorial")) {
			FactorialClass task = new FactorialClass();
			result = task.retint(number);
		}
		
		return result;
	}
	
	/**
	 * Afiseaza in fisier un obiect de tipul LRUCache:
	 * numarul procesat, tipul procesului si rezultatul
	 * @param ob
	 * @param outfile
	 */
	public void outFromCacheLru (LRUCache ob, HomeworkWriter outfile) {
		outfile.println(ob.getNumber() + " " + ob.getProcType() + " " +
				ob.getResult() + " FromCache");
	}
	
	/**
	 * Afiseaza in fisier un obiect de tipul LFUCache:
	 * numarul procesat, tipul procesului si rezultatul
	 * @param ob
	 * @param outfile
	 */
	public void outFromCacheLfu (LFUCache ob, HomeworkWriter outfile) {
		outfile.println(ob.getNumber() + " " + ob.getProcType() + " " +
				ob.getResult() + " FromCache");
	}
}

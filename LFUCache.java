//package tema;

/**
 * @author andreeam
 */
public class LFUCache extends CacheClass {
	private int count;
	private int result;
	
	/**
	 * Constructor fara parametri al clasei.
	 */
	public LFUCache() {super();}
	
	/**
	 * Constructor cu parametri ai clasei. Seteaza contorul
	 * repetarii unui proces la 0 si rezultatul numarului procesat.
	 * Folosind super(), se seteaza si numele procesului si
	 * valoarea numarului ce urmeaza sa fie procesat.
	 * @param process
	 * @param number
	 * @param result
	 */
	public LFUCache(String process, int number, int result) {
		super(process, number);
		this.count = 0;
		this.result = result;
	}
	
	/**
	 * Getter contor.
	 * @return count
	 */
	public int getCount () {
		return count;
	}
	
	/**
	 * Setter contor - incrementeaza contorul.
	 */
	public void setCount () {
		count++;
	}
	
	/**
	 * Getter rezultat.
	 * @return result
	 */
	public int getResult() {
		return result;
	}
	
	/**
	 * Setter result.
	 * @param result
	 */
	public void setResult(int result) {
		this.result = result;
	}
	
	/**
	 * Cauta indexul la care se gaseste numarul procesat de un
	 * proces precizat de cele mai putine ori.
	 * @param cache
	 * @param capacity
	 * @return index
	 */
	public int findIndexMin (LFUCache cache[], int capacity) {
		int minim = cache[0].getCount();
		int index = 0;
		
		//cauta in cache
		for(int i = 1; i < capacity; i++) {
			if (cache[i].getCount() < minim) {
				minim = cache[i].getCount();
				index = i;
			}
		}
		
		//returneaza index
		return index;
	}
	
	/**
	 * Cauta numarul si procesul asociat acestuia in cache si daca este
	 * gasit, atunci se afiseaza rezultatul din cache. In caz contrar,
	 * se verifica daca s-a ajuns la capacitatea maxima a cache-ului.
	 * Daca s-a ajuns la capacitatea maxima, se adauga in cache in locul
	 * elementului procesat de procesul precizat de cele mai putine ori,
	 * altfel, este adaugat la pozitia curenta la care s-a ajuns in cache.
	 * Fiecare caz are un cod de return, pentru a sti in functiile externe
	 * cum se procedeaza mai departe.
	 * @param cache
	 * @param process
	 * @param number
	 * @param actualCapacity
	 * @param capacity
	 * @param outfile
	 * @return 1, 2 sau 3
	 */
	public int addToCache (LFUCache cache[], String process, int number,
			int actualCapacity, int capacity, HomeworkWriter outfile) {
		int i, ok = 0, index, result;
		Calculate res = new Calculate();
		
		//cauta daca numarul si procesul asociat se afla in cache
		for(i = 0; i < actualCapacity; i++) {
			if (cache[i].getProcType().equals(process) &&
					cache[i].getNumber() == number) {
				cache[i].setCount();
				ok = 1;
				//afiseaza rezultatul din cache
				res.outFromCacheLfu(cache[i], outfile);
				return 0;
			}
		}
		//daca nu s-au gasit in cache
		if (ok == 0) {
			//calculeaza rezultatul
			result = res.findResult(process, number);
			LFUCache toAdd = new LFUCache(process, number, result);
			//adauga in cache la pozitia curenta
			if (actualCapacity >= capacity) {
				index = findIndexMin (cache, capacity);
				cache[index] = toAdd;
				return 1;
			}
			//inlocuieste elementul procesat de cele mai putine ori
			else {
				cache[actualCapacity] = toAdd;
				return 2;
			}
		}
		
		return 3;
	}
}

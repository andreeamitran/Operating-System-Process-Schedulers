//package tema;

/**
 * @author andreeam
 */
public class LRUCache extends CacheClass {
	private int time;
	private int result;
	
	/*
	 * Constructor fara parametri al clasei.
	 */
	public LRUCache() {super();}
	
	/**
	 * Constructor cu parametri ai clasei. Seteaza contorul
	 * repetarii unui proces la 0 si rezultatul numarului procesat.
	 * Folosind super(), se seteaza si numele procesului si
	 * valoarea numarului ce urmeaza sa fie procesat.
	 * @param process
	 * @param number
	 * @param time
	 * @param result
	 */
	public LRUCache(String process, int number, int time, int result) {
		super(process, number);
		this.time = time;
		this.result = result;
	}
	
	/**
	 * Getter pentru timp.
	 * @return time
	 */
	public int getTime () {
		return time;
	}
	
	/**
	 * Setter pentru timp.
	 * @param time
	 */
	public void setTime (int time) {
		this.time = time;
	}
	
	/**
	 * Getter pentru rezultat.
	 * @return
	 */
	public int getResult() {
		return result;
	}
	
	/**
	 * Setter pentru rezultat.
	 * @param result
	 */
	public void setResult(int result) {
		this.result = result;
	}
	
	/**
	 * Cauta indexul la care se gaseste numarul procesat de un
	 * proces precizat la timpul cel mai departat.
	 * @param cache
	 * @param capacity
	 * @return index
	 */
	public int findIndexMin (LRUCache cache[], int capacity) {
		int minim = cache[0].getTime();
		int index = 0;
		
		//cauta in cache
		for(int i = 1; i < capacity; i++) {
			if (cache[i].getTime() < minim) {
				minim = cache[i].getTime();
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
	 * elementului procesat de procesul precizat la timpul cel mai departat,
	 * altfel, este adaugat la pozitia curenta la care s-a ajuns in cache.
	 * Fiecare caz are un cod de return, pentru a sti in functiile externe
	 * cum se procedeaza mai departe.
	 * @param cache
	 * @param process
	 * @param number
	 * @param actualCapacity
	 * @param time
	 * @param capacity
	 * @param outfile
	 * @return 1, 2 sau 3
	 */
	public int addToCache (LRUCache cache[], String process, int number,
			int actualCapacity, int time, int capacity, HomeworkWriter outfile) {
		int i, ok = 0, index, result;
		Calculate res = new Calculate();
		
		//cauta daca numarul si procesul asociat se afla in cache
		for(i = 0; i < actualCapacity; i++) {
			if (cache[i].getProcType().equals(process)
					&& cache[i].getNumber() == number) {
				cache[i].setTime(time);
				ok = 1;
				res.outFromCacheLru(cache[i], outfile);
				return 0;
			}
		}
		//daca nu s-au gasit in cache
		if (ok == 0) {
			//calculeaza rezultatul
			result = res.findResult(process, number);
			LRUCache toAdd = new LRUCache(process, number, time, result);
			//adauga in cache la pozitia curenta
			if (actualCapacity >= capacity) {
				index = findIndexMin (cache, capacity);
				cache[index] = toAdd;
				return 1;
			}
			//inlocuieste elementul procesat la timpul cel mai departat
			else {
				cache[actualCapacity] = toAdd;
				return 2;
			}
		}
		
		return 3;
	}
}

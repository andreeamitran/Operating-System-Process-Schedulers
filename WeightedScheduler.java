//package tema;

/**
 * @author andreeam
 */
public class WeightedScheduler extends SchedulerClass {
	/**
	 * Calculeaza cmmdc
	 * @param a
	 * @param b
	 * @return cmmdc
	 */
	public int cmmdc (int a, int b) {
		
		while (a != b) {
			if (a > b) 
				a = a - b;
			else 
				b = b - a;
		}
		
		return b;
	}
	
	/**
	 * Realizeaza rularea planificatorului Weighted.
	 * @param processes
	 * @param numbers
	 * @param numberOfEvents
	 * @param numberOfNumbers
	 * @param cache
	 * @param capacity
	 * @param outfile
	 */
	public void Run(ProcessStructure[] processes, int[] numbers,
			int numberOfEvents, int numberOfNumbers, String cache,
			int capacity, HomeworkWriter outfile) {
		int i, j, k, a, b, code;
		int actualCapacity = 0, time = 0;
		Calculate result = new Calculate();
		//calculeaza cmmdc al numerelor
		a = processes[0].getWeight();
		for(i = 1; i < numberOfEvents; i++) {
			b = processes[i].getWeight();
			a = cmmdc(a, b);
		}
		
		//daca nu este specificat un cache
		if (cache.equals("NoCache")) {
			i = 0;
			j = 0;
			//pentru fiecare numar
			while (i < numberOfNumbers) {
				j = 0;
				//pentru fiecare proces
				while (j < numberOfEvents) {
					k = 0;
					//realizeaza procesul de weight/cmmdc ori
					while (k < processes[j].getWeight() / a) {
						if (i >= numberOfNumbers)
							break;
						//calculeaza si afiseaza rezultat
						result.retOutput(processes[j].getType(),
								numbers[i], outfile, "Computed");
						i++;
						k++;
					}
					j++;
				}
			}
		}
		
		//daca este specificat LruCache
		else if (cache.equals("LruCache")) {
			i = 0;
			LRUCache obj = new LRUCache();
			//creeaza cache
			LRUCache lruCache[] = new LRUCache[capacity];
			
			//pentru fiecare numar
			while (i < numberOfNumbers) {
				j = 0;
				//pentru fiecare proces
				while (j < numberOfEvents) {
					k = 0;
					//realizeaza procesul de weight/cmmdc ori
					while (k < processes[j].getWeight() / a) {
						if (i >= numberOfNumbers)
							break;
						//cauta si/sau adauga rezultatul in cache
						code = obj.addToCache(lruCache, processes[j].getType(),
								numbers[i], actualCapacity, time, capacity, outfile);
						//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
						if (code != 0) {
							result.retOutput(processes[j].getType(),
									numbers[i], outfile, "Computed");
						}
						//daca elementul nu s-a gasit in cache si nu s-a ajuns la
						//capacitatea maxima, mareste capacitatea actuala
						if (code == 2)
							actualCapacity++;
						time++;
						i++;
						k++;
					}
					j++;
				}
			}
		}
		
		//daca este specificat LfuCache
		else if (cache.equals("LfuCache")) {
			i = 0;
			LFUCache obj = new LFUCache();
			//creeaza cache
			LFUCache lfuCache[] = new LFUCache[capacity];
			//pentru fiecare numar
			while (i < numberOfNumbers) {
				j = 0;
				//pentru fiecare proces
				while (j < numberOfEvents) {
					k = 0;
					//realizeaza procesul de weight/cmmdc ori
					while (k < processes[j].getWeight() / a) {
						if (i >= numberOfNumbers)
							break;
						//cauta si/sau adauga rezultatul in cache
						code = obj.addToCache(lfuCache, processes[j].getType(),
								numbers[i], actualCapacity, capacity, outfile);
						//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
						if (code != 0) {
							result.retOutput(processes[j].getType(),
									numbers[i], outfile, "Computed");
						}
						//daca elementul nu s-a gasit in cache si nu s-a ajuns la
						//capacitatea maxima, mareste capacitatea actuala
						if (code == 2)
							actualCapacity++;
						time++;
						i++;
						k++;
					}
					j++;
				}
			}
		}
	}
}

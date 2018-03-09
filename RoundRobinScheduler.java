//package tema;

/**
 * @author andreeam
 */
public class RoundRobinScheduler extends SchedulerClass {
	/**
	 * Realizeaza rularea planificatorului RoundRobin.
	 * @param processes
	 * @param numbers
	 * @param numberOfEvents
	 * @param numberOfNumbers
	 * @param cache
	 * @param capacity
	 * @param outfile
	 */
	public void Run (ProcessStructure[] processes, int[] numbers,
			int numberOfEvents, int numberOfNumbers, String cache,
			int capacity, HomeworkWriter outfile) {
		
		int i = 0, j = 0;
		Calculate result = new Calculate ();
		
		//daca nu este specificat un cache
		if (cache.equals("NoCache")) {
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//verifica daca se reinitializeaza numarul procesului
				if (j >= numberOfEvents)
					j = 0;
				//calculeaza rezultat
				result.retOutput(processes[j].getType(),
						numbers[i], outfile, "Computed");
				//incrementeaza numarul procesului	
				j++;
			}
		}
		
		//daca este specificat LruCache
		else if (cache.equals("LruCache")) {
			j = 0;
			int code, actualCapacity = 0, time = 0;
			LRUCache obj = new LRUCache();
			//creeaza cache
			LRUCache lruCache[] = new LRUCache[capacity];
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//verifica daca se reinitializeaza numarul procesului
				if (j >= numberOfEvents)
					j = 0;
				//cauta si/sau adauga rezultatul in cache
				code = obj.addToCache(lruCache, processes[j].getType(),
						numbers[i], actualCapacity, time, capacity, outfile);
				time++;
				//daca elementul nu s-a gasit in cache si nu s-a ajuns la
				//capacitatea maxima, mareste capacitatea actuala
				if (code == 2)
					actualCapacity++;
				//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
				if (code != 0) {
					result.retOutput(processes[j].getType(),
							numbers[i], outfile, "Computed");
				}
				//incrementeaza numarul procesului
				j++;
			}
		}
		
		//daca este specificat LfuCache
		else if (cache.equals("LfuCache")) {
			j = 0;
			int code, actualCapacity = 0;
			LFUCache obj = new LFUCache();
			//creeaza cache
			LFUCache lfuCache[] = new LFUCache[capacity];
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//verifica daca se reinitializeaza numarul procesului
				if (j >= numberOfEvents)
					j = 0;
				//cauta si/sau adauga rezultatul in cache
				code = obj.addToCache(lfuCache, processes[j].getType(),
						numbers[i], actualCapacity, capacity, outfile);
				//daca elementul nu s-a gasit in cache si nu s-a ajuns la
				//capacitatea maxima, mareste capacitatea actuala
				if (code == 2)
					actualCapacity++;
				//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
				if (code != 0) {
					result.retOutput(processes[j].getType(),
							numbers[i], outfile, "Computed");
				}
				//incrementeaza numarul procesului
				j++;
			}
		}
	}
}

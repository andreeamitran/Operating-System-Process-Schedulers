//package tema;

import java.util.Random;

/**
 * @author andreeam
 */
public class RandomScheduler extends SchedulerClass {

	/**
	 * Realizeaza rularea planificatorului Random.
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
		int i = 0, procnumber, code;
		Calculate result = new Calculate();
		
		//daca nu este specificat un cache
		if (cache.equals("NoCache")) {
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//selecteaza un proces random
				Random rand = new Random();
				procnumber = rand.nextInt(numberOfEvents) + 1;
				//calculeaza si afiseaza rezultatul
				result.retOutput(processes[procnumber-1].getType(),
						numbers[i], outfile, "Computed");
			}
		}
		//daca este specificat LruCache
		else if (cache.equals("LruCache")) {
			LRUCache obj = new LRUCache();
			//creeaza cache
			LRUCache lruCache[] = new LRUCache[capacity];
			int actualCapacity = 0, time = 0;
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//selecteaza un proces random
				Random rand = new Random();
				procnumber = rand.nextInt(numberOfEvents) + 1;
				//cauta si/sau adauga rezultatul in cache
				code = obj.addToCache(lruCache, processes[procnumber-1].getType(),
						numbers[i], actualCapacity, time, capacity, outfile);
				time++;
				//daca elementul nu s-a gasit in cache si nu s-a ajuns la
				//capacitatea maxima, mareste capacitatea actuala
				if (code == 2)
					actualCapacity++;
				//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
				if (code != 0) {
					result.retOutput(processes[procnumber-1].getType(),
							numbers[i], outfile, "Computed");
				}
			}
		}
		
		//daca este specificat LfuCache
		else if (cache.equals("LfuCache")) {
			LFUCache obj = new LFUCache();
			//creeaza cache
			LFUCache lfuCache[] = new LFUCache[capacity];
			int actualCapacity = 0;
			//pentru fiecare numar
			for(i = 0; i < numberOfNumbers; i++) {
				//selecteaza un proces random
				Random rand = new Random();
				procnumber = rand.nextInt(numberOfEvents) + 1;
				//cauta si/sau adauga rezultatul in cache
				code = obj.addToCache(lfuCache, processes[procnumber-1].getType(),
						numbers[i], actualCapacity, capacity, outfile);
				//daca elementul nu s-a gasit in cache si nu s-a ajuns la
				//capacitatea maxima, mareste capacitatea actuala
				if (code == 2)
					actualCapacity++;
				//daca nu s-a gasit in cache, calculeaza rezultat si afiseaza
				if (code != 0) {
					result.retOutput(processes[procnumber-1].getType(),
							numbers[i], outfile, "Computed");
				}
			}
		}
	}

}

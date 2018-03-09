//package tema;

/**
 * @author andreeam
 */
public class MainClass {
	
	public static void main (String[] args) {
		String filename = args[0];
		String output = args[1], cache;
		int numbers[], numberN, numberE, capacity;
		ProcessStructure processes[];
		
		HomeworkReader file = new HomeworkReader(filename);
		HomeworkWriter outfile = new HomeworkWriter(output);
		ProblemData data = file.readData();
		numbers = data.getNumbersToBeProcessed();
		processes = data.getProcesses();
		numberN = file.numberOfNumbers;
		numberE = file.numberOfEvents;
		cache = data.getCacheType();
		capacity = data.getCacheCapacity();
		
		//ruleaza RandomScheduler
		if ((data.getSchedulerType()).equals("RandomScheduler")) {
			RandomScheduler scheduler = new RandomScheduler ();
			scheduler.Run(processes, numbers, numberE, numberN,
					cache, capacity, outfile);
		}
		
		//ruleaza RoundRobinScheduler
		else if ((data.getSchedulerType()).equals("RoundRobinScheduler")) {
			RoundRobinScheduler scheduler = new RoundRobinScheduler();
			scheduler.Run(processes, numbers, numberE, numberN,
					cache, capacity, outfile);
		}
		
		//ruleaza WeightedScheduler
		else if ((data.getSchedulerType()).equals("WeightedScheduler")) {
			WeightedScheduler scheduler = new WeightedScheduler();
			scheduler.Run(processes, numbers, numberE, numberN,
					cache, capacity, outfile);
		}
		
		file.close();
		outfile.close();
	}
	
}

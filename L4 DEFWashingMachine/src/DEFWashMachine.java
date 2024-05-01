
import java.util.*;

public class DEFWashMachine {
	public enum status { free, busy } 

	static int MaxDurat = 0;
	static int NumOfCar = 0;  
	static int TotWaitTime = 0; 
	static int TotWorkTime = 0; 

	public static void main(String[] args) {
		Clock carArrival;
		Queue<Clock> waitQueue = new Queue<>();  
		Queue<Clock> arrivalQueue = new Queue<>(); 
		Queue<Customer> myQueue = new Queue<>();  
		Customer car = new Customer();            
		Customer current = new Customer();      

		
		Scanner sc = new Scanner(System.in);

		status machineWash; 

		
		Clock totalWaitTime = new Clock();    
		Clock maxWaitTime = new Clock();        
		Clock totalServiceTime = new Clock();   
		Clock startTime = new Clock();          
		Clock endTime = new Clock();            
		Clock washStart = new Clock();          
		Clock washEnd = new Clock();            
		


		Clock i = new Clock();
		int nextArrival = 0;
		int carService = 0;
		int count1 = 0, count2 = 0;

		startTime.setTime(8, 0, 0);    
		endTime.setTime(8, 30, 0);     
 

		for (i = startTime.getCopy(); i.lessThan(endTime); ) {
			nextArrival = sc.nextInt(); 
			carService = sc.nextInt();
			i.addTimeMinute(nextArrival);
			car.time = i.getCopy();
			car.serviceType = carService;
			myQueue.enqueue(car.CopyCustomer());
			if (i.lessThan(endTime)) {
				arrivalQueue.enqueue(i.getCopy());
			}
		}

		machineWash = status.free; 

		if (!arrivalQueue.isEmpty()) { 
		    current = myQueue.peek(); 
		    startTime = arrivalQueue.peek(); 
		    washEnd = startTime.getCopy(); 

		    if (current.getSeviceType() == 1) { 
		        washEnd.addTimeMinute(6); 
		    } else if (current.getSeviceType() == 2) { 
		       washEnd.addTimeMinute(10); 
		    }
		} else {
		    startTime = endTime.getCopy(); 
		}
		Clock del;

		// Simulation loop
		for (i = startTime; (i.lessThan(endTime) || (!waitQueue.isEmpty()) || (!arrivalQueue.isEmpty())); ) {
		    if (!arrivalQueue.isEmpty()) {
		        if (i.equalTime(arrivalQueue.peek())) {
		            waitQueue.enqueue(i.getCopy()); 
		            del = arrivalQueue.dequeue(); 
		        }
		    }

		    if ((machineWash == status.busy) && (i.equalTime(washEnd))) { 
		        washEnd.setTime(14, 0, 0); 
		        machineWash = status.free; 
		    }

		    if ((machineWash == status.free) && !(waitQueue.isEmpty())) {  
		        washStart = i.getCopy();
		        washEnd = i.getCopy(); 
		        current = myQueue.dequeue(); 
		        if (current.getSeviceType() == 1) { 
		            washEnd.addTimeMinute(6); 
		            count1++; 
		        } else if (current.getSeviceType() == 2) { 
		            washEnd.addTimeMinute(10); 
		            count2++; 
		        }

		        doAnalysis(i, waitQueue.peek(), washEnd); 

		        del = waitQueue.dequeue(); 
		        machineWash = status.busy; 
		    }

		    if ((machineWash == status.free) && (waitQueue.isEmpty())) { 
		        washEnd.setTime(14, 0, 0); 
		    }

		    
		    if (!arrivalQueue.isEmpty()) {
		        if (washEnd.lessThan(arrivalQueue.peek())) {
		            i = washEnd.getCopy(); 
		        } else {
		            i = arrivalQueue.peek().getCopy(); 
		        }
		    } else {
		        i = washEnd.getCopy(); 
		    }
		}

		
		System.out.println("Total Customer: " + NumOfCar);
		System.out.println("Number of customers for service of type 1: " + count1);
		System.out.println("Number of customers for service of type 2: " + count2);
		System.out.println("Longest waiting time: " + MaxDurat + " minutes");
		System.out.println(String.format("Average waiting time: %.2f minutes", TotWaitTime / (float) NumOfCar));
	}

	
	public static void doAnalysis(Clock waitStop, Clock start, Clock washStop) {
		int carWait, machineWork;
		carWait = start.durationSec(waitStop.getCopy());
		machineWork = waitStop.durationSec(washStop.getCopy());
		NumOfCar++;
		TotWaitTime += carWait;
		TotWorkTime += machineWork;
		if (MaxDurat < carWait) {
			MaxDurat = carWait;
		}
	}
}

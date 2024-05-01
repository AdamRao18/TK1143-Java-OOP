
import java.util.*;
import java.util.Scanner;

public class ABCWashMachine {
    public enum status { free, busy }
    static int maxDur = 0; // Maximum waiting time for a car
    static int numCar = 0; // Total number of cars arrived
    static int totalWait = 0; // Total waiting time for all cars
    static int totalWork = 0; // Total time the machine is busy

    public static void main(String[] args) {
        // Initialize queues and other variables
        Clock carArrival;
        Queue<Clock> waitQueue = new Queue<>();
        Queue<Clock> arrivalQueue = new Queue<>();
        Scanner sc = new Scanner(System.in);

        status machineWash;

        Clock totalWaitTime = new Clock();
        Clock maxWaitTime = new Clock();
        Clock totalServiceTime = new Clock();
        Clock startTime = new Clock();
        Clock endTime = new Clock();
        Clock washEnd = new Clock();
        Clock washStart = new Clock();

        Clock i;
        int nextArrival = 0;
        Random rand = new Random();
        startTime.setTime(8, 0, 0);
        endTime.setTime(8, 30, 0);

        // Accept arrival times from the user until the end time is reached
        for (i = startTime.getCopy(); i.lessThan(endTime); ) {
            nextArrival = sc.nextInt();
            i.addTimeMinute(nextArrival);
            if (i.lessThan(endTime)) {
                arrivalQueue.enqueue(i.getCopy());
                System.out.println("Car arrival: " + i.toString() + " < " + endTime.toString());
            }
        }

        // Start the simulation
        machineWash = status.free;
        if (!arrivalQueue.isEmpty()) {
            startTime = arrivalQueue.peek();
            washEnd = startTime.getCopy();
            washEnd.addTimeMinute(5);
        } else
            startTime = endTime.getCopy();

        Clock del;

        // Run the simulation until the end time is reached and both queues are empty
        for (i = startTime; (i.lessThan(endTime) || (!waitQueue.isEmpty()) || (!arrivalQueue.isEmpty())); ) {
            // Check if there are cars arriving at the current time
            if (!arrivalQueue.isEmpty())
                if (i.equalTime(arrivalQueue.peek())) {
                    waitQueue.enqueue(i.getCopy());
                    del = arrivalQueue.dequeue();
                }

            // Check if the machine is busy and the washing time has ended
            if ((machineWash == status.busy) && (i.equalTime(washEnd))) {
                washEnd.setTime(14, 0, 0);
                machineWash = status.free;
            }

            // Check if the machine is free and there are cars waiting in the queue
            if ((machineWash == status.free) && !(waitQueue.isEmpty())) {
                washStart = i.getCopy();
                washEnd = i.getCopy();
                washEnd.addTimeMinute(5);
                doAnalysis(i, waitQueue.peek(), washEnd); // Call doAnalysis method
                del = waitQueue.dequeue();
                machineWash = status.busy;
                // Print simulation details
                System.out.print("\nCustomer: " + washStart.toString() + " waitQueue: " + del.toString() + " washEnd: " + washEnd.toString());
                System.out.print("\ncarWait: " + (washStart.getMinutes() - del.getMinutes()) + " maxDur: " + maxDur);
                System.out.print("\nTotalWait: " + totalWait);
                System.out.print("\nTotalWork: " + totalWork + "\n");
            }

            // Check if the machine is free and there are no more cars waiting
            if ((machineWash == status.free) && (waitQueue.isEmpty()))
                washEnd.setTime(14, 0, 0);

            // Jump to the next event
            if (!arrivalQueue.isEmpty())
                if (washEnd.lessThan(arrivalQueue.peek())) {
                    i = washEnd.getCopy();
                } else {
                    i = arrivalQueue.peek().getCopy();
                }
            else {
                i = washEnd.getCopy();
            }
        }
        // Report the simulation results
        System.out.print("\nREPORT\n");
        System.out.print("Number of customer arrive by 8.30 am: " + numCar + "\n");
        System.out.print("Longest waiting time: " + maxDur + " minutes\n");
        System.out.print(String.format("Average waiting time: %.2f minutes", totalWait / (float) numCar));
    }

    // Method to analyze the waiting and washing times for a car
    public static void doAnalysis(Clock waitStop, Clock start, Clock washStop) {
        int carWait, machineWork;
        carWait = start.durationSec(waitStop.getCopy());
        machineWork = waitStop.durationSec(washStop.getCopy());
        numCar++;
        totalWait += carWait;
        totalWork += machineWork;
        if (maxDur < carWait)
        	maxDur = carWait;
    }
}

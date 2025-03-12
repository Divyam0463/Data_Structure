import java.util.Scanner;

// Node representing a process in the circular linked list
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

// Circular Linked List for Process Scheduling
class ProcessQueue {
    private Process head = null, tail = null;

    // Add a new process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular structure
        }
    }

    // Remove a process after execution completion
    private void removeProcess(Process prev, Process current) {
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) { // Removing head
            head = head.next;
            tail.next = head;
        } else if (current == tail) { // Removing tail
            tail = prev;
            tail.next = head;
        } else { // Removing in-between node
            prev.next = current.next;
        }
    }

    // Display process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                    ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println("-----------------------------------");
    }

    // Simulate round-robin scheduling
    public void executeRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int totalTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = head;
        Process prev = tail;

        while (head != null) {
            System.out.println("\nExecuting Process ID: " + current.processId);
            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                totalTime += timeQuantum;
                prev = current;

                current = current.next; 

            } else {
                totalTime += current.remainingTime;
                int turnaroundTime = totalTime;
                int waitingTime = turnaroundTime - current.burstTime;
                totalTurnaroundTime += turnaroundTime;
                totalWaitingTime += waitingTime;
                processCount++;

                System.out.println("Process " + current.processId + " completed.");
                removeProcess(prev, current);
                current = prev.next; // Move to next process after deletion
            }

            displayProcesses();
        }

        // Display average waiting and turnaround time
        System.out.println("\nAll processes completed.");
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) processCount));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) processCount));
    }
}

// Main class for execution
public class RoundRobinScheduling {
    public static void main(String[] args) {
        ProcessQueue queue = new ProcessQueue();
        Scanner scanner = new Scanner(System.in);

        
        queue.addProcess(1, 8, 2);
        queue.addProcess(2, 5, 1);
        queue.addProcess(3, 12, 3);
        queue.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        queue.displayProcesses();

        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();

        // Execute Round Robin Scheduling
        queue.executeRoundRobin(timeQuantum);

        scanner.close();
    }
}

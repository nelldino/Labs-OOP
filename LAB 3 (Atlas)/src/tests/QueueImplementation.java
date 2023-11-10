package tests;

import queue.ArrayQueue;
import queue.LinkedQueue;
import queue.Queue;
import queue.VectorQueue;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class QueueImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select queue implementation:");
        System.out.println("1. ArrayQueue");
        System.out.println("2. LinkedQueue");
        System.out.println("3. VectorQueue");
        int choice = scanner.nextInt();

        Queue<Object> queue;

        switch (choice) {
            case 1:
                queue = new ArrayQueue<>();
                break;
            case 2:
                queue = new LinkedQueue<>();
                break;
            case 3:
                queue = new VectorQueue<>();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        while (true) {
            System.out.println("Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if queue is empty");
            System.out.println("5. Queue size");
            System.out.println("6. Display all queue elements");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    Object element = scanner.next();
                    queue.enqueue(element);
                    System.out.println("Element enqueued into the queue.");
                    break;
                case 2:
                    try {
                        Object dequeuedElement = queue.dequeue();
                        System.out.println("Dequeued element: " + dequeuedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                    break;
                case 3:
                    try {
                        Object peekedElement = queue.peek();
                        System.out.println("Front element: " + peekedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty. No front element.");
                    }
                    break;
                case 4:
                    System.out.println("Is queue empty? " + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue size: " + queue.size());
                    break;
                case 6:
                    System.out.println("Queue Elements:");
                    printQueueElements(queue);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printQueueElements(Queue<Object> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        Queue<Object> tempQueue = new ArrayQueue<>();
        while (!queue.isEmpty()) {
            Object element = queue.dequeue();
            tempQueue.enqueue(element);
            System.out.print(element + " ");
        }
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        System.out.println();
    }
}

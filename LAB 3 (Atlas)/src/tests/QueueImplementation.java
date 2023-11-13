package tests;

import queue.ArrayQueue;
import queue.LinkedQueue;
import queue.Queue;
import queue.VectorQueue;
import java.util.Scanner;
import java.util.NoSuchElementException;

import static elements.elements.printQueueElements;

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
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. peek");
            System.out.println("4. empty or not");
            System.out.println("5. size");
            System.out.println("6. all elements");
            System.out.println("7. exit");
            System.out.print("Enter your choice: ");
            String operation = scanner.next();

            switch (operation) {
                case "enqueue":
                    System.out.print("enter element to enqueue: ");
                    Object element = scanner.next();
                    queue.enqueue(element);
                    System.out.println("element enqueued into the queue.");
                    break;
                case "dequeue":
                    try {
                        Object dequeuedElement = queue.dequeue();
                        System.out.println("dequeued element: " + dequeuedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("queue is empty. cannot dequeue.");
                    }
                    break;
                case "peek":
                    try {
                        Object peekedElement = queue.peek();
                        System.out.println("front element: " + peekedElement);
                    } catch (NoSuchElementException e) {
                        System.out.println("queue is empty. no front element.");
                    }
                    break;
                case "empty":
                    System.out.println("empty or not? " + queue.isEmpty());
                    break;
                case "size":
                    System.out.println("size: " + queue.size());
                    break;
                case "all elements":
                    System.out.println("queue elements:");
                    printQueueElements(queue);
                    break;
                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}

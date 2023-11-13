package elements;

import queue.ArrayQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.Stack;

public class elements {
    public static void printStackElements(Stack<Object> stack) {
        if (stack.isEmpty()) {
            System.out.println("stack is empty.");
            return;
        }

        System.out.print("stack elements: ");
        Stack<Object> tempStack = new ArrayStack<>();
        while (!stack.isEmpty()) {
            Object element = stack.pop();
            tempStack.push(element);
            System.out.print(element + " ");
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        System.out.println();
    }

    public static void printQueueElements(Queue<Object> queue) {
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

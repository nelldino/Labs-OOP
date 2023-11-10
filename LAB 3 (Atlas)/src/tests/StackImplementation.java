package tests;

import stack.ArrayStack;
import stack.LinkedStack;
import stack.Stack;
import stack.VectorStack;
import java.util.Scanner;

public class StackImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select stack implementation:");
        System.out.println("1. ArrayStack");
        System.out.println("2. LinkedStack");
        System.out.println("3. VectorStack");
        int choice = scanner.nextInt();

        Stack<Object> stack;

        switch (choice) {
            case 1:
                stack = new ArrayStack<>();
                break;
            case 2:
                stack = new LinkedStack<>();
                break;
            case 3:
                stack = new VectorStack<>();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        while (true) {
            System.out.println("Stack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Stack size");
            System.out.println("7. Stack elements");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            String operation = scanner.next();

            switch (operation) {
                case "push":
                    System.out.print("Enter element to push: ");
                    Object element = scanner.next();
                    stack.push(element);
                    System.out.println("Element pushed onto the stack.");
                    break;
                case "pop":
                    try {
                        Object poppedElement = stack.pop();
                        System.out.println("Popped element: " + poppedElement);
                    } catch (Exception e) {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;
                case "peek":
                    try {
                        Object peekedElement = stack.peek();
                        System.out.println("Top element: " + peekedElement);
                    } catch (Exception e) {
                        System.out.println("Stack is empty. No top element.");
                    }
                    break;
                case "empty":
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;
                case "size":
                    System.out.println("Stack size: " + stack.size());
                    break;
                case "elements":
                    System.out.println("Stack Elements:");
                    printStackElements(stack);
                    break;
                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                default:
                    System.out.println("Invalid choice. Try again.");
                    return;
            }
        }
    }
    private static void printStackElements(Stack<Object> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack elements: ");
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
}

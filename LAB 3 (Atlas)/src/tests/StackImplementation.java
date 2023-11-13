package tests;

import stack.ArrayStack;
import stack.LinkedStack;
import stack.Stack;
import stack.VectorStack;
import java.util.Scanner;

import static elements.elements.printStackElements;

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
            System.out.println("Stack Operations: ");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. empty or no");
            System.out.println("5. size");
            System.out.println("7. all elements");
            System.out.println("6. exit");
            System.out.println("Enter your choice: ");
            String operation = scanner.next();

            switch (operation) {
                case "push":
                    System.out.print("enter element to push: ");
                    Object element = scanner.next();
                    stack.push(element);
                    System.out.println("element pushed onto the stack.");
                    break;
                case "pop":
                    try {
                        Object poppedElement = stack.pop();
                        System.out.println("popped element: " + poppedElement);
                    } catch (Exception e) {
                        System.out.println("stack is empty");
                    }
                    break;
                case "peek":
                    try {
                        Object peekedElement = stack.peek();
                        System.out.println("top element: " + peekedElement);
                    } catch (Exception e) {
                        System.out.println("stack is empty. no top element.");
                    }
                    break;
                case "empty":
                    System.out.println("empty or not? " + stack.isEmpty());
                    break;
                case "size":
                    System.out.println("stack size: " + stack.size());
                    break;
                case "elements":
                    System.out.println("stack elements:");
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
}

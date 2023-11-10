package stack;


public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E item) {
            data = item;
            next = null;
        }
    }

    @Override
    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow"); // Handle underflow condition
        }
        E item = top.data;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty"); // Handle underflow condition
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}

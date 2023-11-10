package queue;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front, rear;
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
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        E item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
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

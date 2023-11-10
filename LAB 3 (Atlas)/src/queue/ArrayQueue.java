package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private Object[] array;
    private int front, rear, size;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue() {
        array = new Object[DEFAULT_CAPACITY];
        front = rear = size = 0;
    }

    @Override
    public void enqueue(E item) {
        if (size == array.length) {
            resizeArray(2 * array.length);
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = peek();
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resizeArray(int capacity) {
        Object[] newArray = new Object[capacity];
        int index = 0;
        while (!isEmpty()) {
            newArray[index++] = dequeue();
        }
        array = newArray;
        front = 0;
        rear = size;
    }
}

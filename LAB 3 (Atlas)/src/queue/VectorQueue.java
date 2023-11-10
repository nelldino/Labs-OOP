package queue;

import java.util.Vector;
import java.util.NoSuchElementException;

public class VectorQueue<E> implements Queue<E> {
    private Vector<E> vector;

    public VectorQueue() {
        vector = new Vector<>();
    }

    @Override
    public void enqueue(E item) {
        vector.add(item);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return vector.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return vector.get(0);
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public int size() {
        return vector.size();
    }
}

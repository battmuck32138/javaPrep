import java.util.LinkedList;

/**
 * Singe ended standard queue
 */
public class Queue <E> {
    private LinkedList<E> q = new LinkedList<E>();
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E elem) {
        q.addLast(elem);
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            return null;
        }
        size--;
        return q.removeFirst();
    }
}

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Double Ended Que
 */

public class DeQueue<E> {
    private LinkedList<E> dq = new LinkedList<>();
    private int size = 0;

    public void addFirst(E elem) {
        dq.addFirst(elem);
        size++;
    }

    public void addLast(E elem) {
        dq.addLast(elem);
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        return dq.removeFirst();
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        return dq.removeLast();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}

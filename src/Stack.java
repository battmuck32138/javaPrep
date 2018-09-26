
/*
Stack: Last in first out.
 */

import java.util.ArrayList;

public class Stack <E> {

    private ArrayList<E> stk = new ArrayList<>();
    private int size = 0;

    public boolean isEmpty() {
        return stk.isEmpty();
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        size--;
        return stk.remove(size);
    }

    public void push(E elem) {
        stk.add(size, elem);
        size++;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return stk.get(size - 1);
    }

}

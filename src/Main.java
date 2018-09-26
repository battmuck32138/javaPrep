import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("reveresed(1000): " + Methods.reversed(1000));
        int[] arr = {3, 3, 100, 9, 100};
        System.out.println("twoOneHundreds(arr): " + Methods.twoOneHundreds(arr));
        System.out.println();

        Stack stk = new Stack();
        System.out.println("isEmpty(): " + stk.isEmpty());
        stk.push(7);
        System.out.println("Stack is empty: " + stk.isEmpty());
        System.out.println("peek: " + stk.peek());
        stk.push(8);
        System.out.println("pop(): " + stk.pop());
        System.out.println("pop(): " + stk.pop());
        System.out.println("pop: " + stk.pop());
        System.out.println("size: " + stk.size());
        System.out.println();
        System.out.println();

        DeQueue<Integer> dq = new DeQueue();
        System.out.println("DeQueue tests");
        System.out.println("size(): " + dq.size());
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(99);
        System.out.println(dq.isEmpty());
        System.out.println("size(): " + dq.size());
        System.out.println("removeLat(): " + dq.removeLast());
        System.out.println("removeFirst(): " + dq.removeFirst());
        System.out.println("size(): " + dq.size());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println();
        System.out.println();

        System.out.println("Queue tests");
        Queue<String> q = new Queue();
        System.out.println("isEmpty(): " + q.isEmpty());
        q.enqueue("fist in");
        q.enqueue("second in");
        q.enqueue("third in");
        System.out.println("deque(): " + q.dequeue());
        System.out.println("deque(): " + q.dequeue());
        System.out.println("size(): " + q.size());
        System.out.println("deque(): " + q.dequeue());
        System.out.println("deque(): " + q.dequeue());
        System.out.println("deque(): " + q.dequeue());

        System.out.println("reversed(7): " + Methods.reversed(7));
        int[] arr1 = new int[] {1, 88, 3, 3, 8, 9, 0, 2, 88, 3, 2, 2, 88, 88, 105};
        System.out.println("mostFrequent(arr1): " + Methods.mostFrequent(arr1));
        int[] a = new int[]{0, 1, 3, 5, 6, 7, 9, 10};
        Methods.pairsSumTen(a);
        System.out.println(Methods.fibRecursive(8));
        System.out.println(Methods.fibIter(8));
        System.out.println(Methods.fibSequence(7));
        ArrayList<String> ops = new ArrayList<>();
        ops.add("push");
        ops.add("push");
        ops.add("push");
        ops.add("pop");
        System.out.println(ops);
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(1);
        System.out.println(x.toString());
        System.out.println(Methods.maxMin(ops, x));
        int[] nums = new int[] {1, 2, 3, 5, 7, 7, 1, 13, 9, 10, 10, 138, 3, 14, 5, 4, 4, 4, 14};
        System.out.println(Arrays.toString(nums));
        System.out.println("Only occurred one time: " + Methods.oneTime(nums));





















    }


}

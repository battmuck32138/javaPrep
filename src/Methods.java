import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * Assorted method definitions for job interview prep.
 */
public class Methods <E> {


    /**
     * int[] arr = {3, 3, 100, 100};
     * twoOneHundreds(arr): true
     * int[] arr = {3, 3, 100, 9, 100};
     * twoOneHundreds(arr): false
     *
     * @param arr int array.
     * @return true if there are two 100 values next to each other in arr.
     */
    public static boolean twoOneHundreds(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            if (arr[i] == 100 && arr[j] == 100) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param n Count down int
     * @return A String starting with n that counts down to 1.
     * reversed(7): 7 6 5 4 3 2 1
     */
    public static String reversed(int n) {
        return revHelper(n, "");
    }

    private static String revHelper(int n, String result) {
        if (n == 1) {
            return result + Integer.toString(n);
        }
        result += Integer.toString(n) + " ";
        return revHelper(n - 1, result);
    }


    /**
     * Method finds the most frequently occurring digit in arr.
     * A tie goes the the int that was encountered first in arr.
     * Invariant: Method assumes arr is not empty.
     *
     * @param arr int array
     * @return The most frequently occurring int in arr.
     */
    public static int mostFrequent(int[] arr) {
        int currentCt = 0;
        int maxCount = 0;
        int mf = arr[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    currentCt++;
                }
            }

            if (currentCt > maxCount) {
                maxCount = currentCt;
                mf = arr[i];
            }
            currentCt = 0;

        }
        return mf;
    }


    /**
     * Works in O(n) time
     * int[] a = new int[]{0, 1, 3, 5, 6, 7, 9, 10};
     * Methods.pairsSumTen(a) -> (7, 3) (9, 1) (10, 0)
     *
     * @param arr int arr
     */
    public static void pairsSumTen(int[] arr) {
        HashMap<Integer, Integer> tenCompOfKey = new HashMap<>();

        /*
        Run through the array 1 time and put the values in the map
        at keys such that key + val equals 10.  Then if I find values that have
        already been used as keys, I know the compliment is already in the map
        so I can print the pair.
        */
        for (int key : arr) {
            if (tenCompOfKey.containsKey(key)) {
                System.out.print("(" + key + ", " + tenCompOfKey.get(key) + ")  ");
            } else {
                tenCompOfKey.put(10 - key, key);
            }
        }
        System.out.println();
    }


    /**
     * Invariant: Assume n >= 0
     * Fibonacci sequence:  0, 1, 1, 2, 3, 5, 8, 13........
     *
     * @param n the nth digit of the fibonacci sequence
     * @return the nth digit of the fibonacci sequence
     * starting at index 0.
     * fibRecursive(9) -> 34
     */
    public static int fibRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }


    /**
     * Invariant: Assume n >= 0
     * Fibonacci sequence:  0, 1, 1, 2, 3, 5, 8, 13........
     *
     * @param n the nth digit of the fibonacci sequence
     * @return the nth digit of the fibonacci sequence
     * starting at index 0.
     * fibIter(7) -> 13
     */
    public static int fibIter(int n) {
        int twoBack = 0;
        int oneBack = 1;
        int i = 2;  //Variables already have values assigned for indexes 0 and 1 so start at index 2
        int tot = 0;

        if (n < 2) {
            return n;
        }

        while (i <= n) {
            tot = twoBack + oneBack;
            twoBack = oneBack;
            oneBack = tot;
            i++;
        }

        return tot;
    }


    /**
     * Invariant: Assume n >= 0
     * Fibonacci sequence:  0, 1, 1, 2, 3, 5, 8, 13........
     *
     * @param n the nth digit of the fibonacci sequence
     * @return a string containing the Fibonacci sequence up to index n
     * fibSequence(7) -> [0, 1, 1, 2, 3, 5, 8, 13]
     */
    public static String fibSequence(int n) {
        if (n == 0) {
            return "[0]";

        } else if (n == 1) {
            return "[0, 1]";
        }

        int twoBack = 0;
        int oneBack = 1;
        int i = 2;
        int[] fibSeq = new int[n + 1];
        fibSeq[0] = 0;
        fibSeq[1] = 1;

        while (i <= n) {
            int tot = twoBack + oneBack;
            fibSeq[i] = tot;
            twoBack = oneBack;
            oneBack = tot;
            i++;
        }

        return Arrays.toString(fibSeq);
    }


    /**
     * Method returns the product of the min and max of the elems array.
     * elems contains the result of querying using the operations contained in operatons
     * with the inputs x contained in x.  elems is always in sorted order.
     * @param operations
     * @param x
     * @return
     */
    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        List<Integer> elems = new ArrayList<>();
        List<Long> prods = new ArrayList<>();

        int xsz = x.size();
        int osz = operations.size();
        if (osz < 1 || xsz < 1 || osz > Math.pow(10, 5) || xsz > Math.pow(10, 5)) {
            return prods;
        }

        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int elem = x.get(i);

            if (elem < 1 || elem > Math.pow(10, 9)) {
                return prods;
            }

            if (op == "push") {
                elems.add(elem);
            } else {
                elems.remove(0);
            }

            Collections.sort(elems);
            int num = elems.get(0) * elems.get(elems.size() - 1);
            prods.add(Integer.toUnsignedLong(num));
        }

        return prods;
    }


    /**
     *  Finds the smallest element that only occurs once in arr.
     *  Invariant: arr must contain at least one value that only occurs once.
     * @param arr int[]
     * @return the smallest int that only occurs one time.
     *
     * Logic:
     * 1) Make a map of (num, count) pairs.  O(N)
     * 2) Remove any pairs with a count > 1. O(N)
     * 3) return any key left in the keySet.
     */
    public static int oneTime(int[] arr) {
        //(key, val) is (num, count)
        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];

            if (counts.containsKey(key)) {
                counts.replace(key, counts.get(key) + 1);
            } else {
                counts.put(key, 1);
            }
        }

        Object[] keys = counts.keySet().toArray();

        for (Object k : keys) {
            if (counts.get(k) != 1) {
                counts.remove(k);
            }
        }

        return (int) counts.keySet().toArray()[0];
    }













}





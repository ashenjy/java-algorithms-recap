package algorithms.sorting;

import java.util.Comparator;
import java.util.Scanner;

/* *  This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 *  (not including the input array).
 * */
public class SelectionSort {

    // This class should not be instantiated.
    public SelectionSort(){
    }

    // Rearranges the array in ascending order, using the natural order.
    public static void sort(Comparable[] a){   //[1,3,2,2,3]
        /* i
        *  0->1
        * [1, 3 , 2 , 2 , 3]
        *     j
        *     1-> 2 ->3 ->4
        *         2
        * [1, 2 , 3 , 2 , 3]
        *           ->3
        * [1, 2 , 2 , 3 , 3]
        *              ->4
        * */
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i; //minimum object
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    //  Rearranges the array in ascending order, using a comparator.
    public static void sort(Object[] a, Comparator comparator){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, comparator, 0, i);
        }
        assert isSorted(a, comparator);
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/


    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparable[] a = {1,3,2,2,3};
        SelectionSort.sort(a);
        show(a);
    }


}

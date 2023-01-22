package algorithms.sorting;

public class MergeSort {
    // This class should not be instantiated.
    private MergeSort() {}

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j] < aux[i])      a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

//    public static void mergeSort(int[] a) { // {14,9,3,2,43,11,58,22}
//        int n = a.length;
////        int[] aux = new int[n];
//        int lo = 0;
//        int hi = n-1; // 7
//
//        if(hi <= lo) return;
//        int mid = lo + (hi - lo) / 2;  // 0 + (7-0) / 2 = 7/2 = 3.5
//        sort(a,lo,mid);
//        sort(a,mid+1,hi);
//    }
                                                        //     i
//    private static void sort(int[] a, int lo, int hi){ // {14,9,3,2}
//        //insertion sort                                       j
//        for(int i=lo; i <= hi; i++){
//            for(int j=i; j > 0 && a[j] < a[j-1]; j--){
//               swap(a,j,j-1);
//            }
//        }
//        assert isSorted(a, lo, hi);
//    }

    private static void swap(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a){ // {14,9,3,2}
        return isSorted(a,0,a.length-1);
    }

    private static boolean isSorted(int[] a, int lo, int hi){ // {14,9,3,2}
        for(int i=lo; i<= hi; i++){
            if(a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {14,9,3,2,43,11,58,22};
        System.out.println("Before Merge Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        MergeSort.sort(arr1); //sorting array using merge sort

        System.out.println("After Merge Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}

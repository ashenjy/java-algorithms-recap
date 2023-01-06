package algorithms.sorting;

public class InsertionSort {
    /*  {14,9,3,2,43,11,58,22}
         for i=0
           if a[i] > a[i+1]  14 > 9
                int swap = a[i]
                a[i] = a[i+1]
                a[i+1] = swap {9,14,3,2,43,11,58,22}
         for i=1
           if a[i] > a[i+1]  14 > 3
                int swap = a[i]
                a[i] = a[i+1]
                a[i+1] = swap {9,3,14,2,43,11,58,22}
                while i-1 != -1 && a[i] < a[i-1]
                    int swap = a[i]
                    a[i] = a[i-1] {9,9,14,2,43,11,58,22}
                    a[i-1] = swap {3,9,14,2,43,11,58,22}

    *   {9,14,3,2,43,11,58,22}
    *   {9,3,14,2,43,11,58,22}
    *   {3,9,14,2,43,11,58,22}
    * */                                        //     i
    public static void insertionSort(int[] a) { // {14,9,3,2,43,11,58,22}
        int n = a.length;                       //  j

        for(int i=1; i<n; i++){
            for(int j = i; j > 0 && a[j] < a[j-1]; j--) {  // 9 < 14
                swap(a, j, j-1); // {9,14,3,2,43,11,58,22}
            }
            assert isSorted(a, 0, i);
        }

        /*for (int i = 0; i < n; i++) {
            if ( i != n-1 && a[i] > a[i+1]){
                int swap = a[i];
                a[i] = a[i+1];
                a[i+1] = swap;
                int key = i;
                while (key-1 != -1 && a[key] < a[key-1]) {
                    int shift = a[key];
                    a[key] = a[key - 1];
                    a[key - 1] = shift;
                    key--;
                }
            }
        }*/
    }

    // smallest element
    public static void selectionSort(int[] a) { // {14,9,3,2,43,11,58,22}
        int n = a.length;       //  i
        for(int i=0; i<n; i++){ // {14,9,3,2,43,11,58,22}
            int min = i;                  //     j
            for(int j = i+1; j < n; j++){ // {14,9,3,2,43,11,58,22}
                if(a[j] < a[min]){        //     min
                    min = j;              // {14,9,3,2,43,11,58,22}
                }
            }
            swap(a,i,min);
            assert isSorted(a,0,i);
        }
    }

    public static void swap(int[] a, int i, int j){
       int swap = a[i];
       a[i] = a[j];
       a[j] = swap;
    }

    public static boolean isSorted(int[] a, int lo, int hi){ // {14,9,3,2,43,11,58,22}
        int n = a.length;
        for(int i=lo; i < hi; i++){
            if(a[i] < a[i-1]){  // 9 < 14
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {14,9,3,2,43,11,58,22};
        System.out.println("Before Insertion Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        insertionSort(arr1);//sorting array using insertion sort
//        selectionSort(arr1);//sorting array using selection sort

        System.out.println("After Insertion Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}

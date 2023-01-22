package algorithms.search;

public class BinarySearch {

    public static void binarySearch(int[] a, int key) {
        if(!isSorted(a)){
           insertionSort(a);
        }
        assert isSorted(a);

        //set lo and hi
        int lo = 0;
        int hi = a.length -1;

        //find mid
        int mid = (lo + hi) / 2 ;

        while(lo <= hi){  // {2,3,9,11,14,22,43,58}
            //if the mid < key, then key to be searched is in the first half of array
            if(a[mid] < key){
                lo = mid + 1;
            }else if(key == a[mid]){
                //if key = element at mid, then print the location
                System.out.println("Element is found at index: " + mid);
                break;
            }else{
                hi = mid -1;
            }
            mid = (lo + hi) / 2 ;
        }

        if(lo > hi){
            System.out.println("Element is not found!");
        }
    }

    public static void insertionSort(int[] a){ // {14,9,3,2,43,11,58,22}
        int n = a.length;
        for(int i=1; i<n; i++){
            for(int j=i; j > 0 && a[j] < a[j-1]; j--){
                int swap = a[j];
                a[j] = a[j-1];
                a[j-1] = swap;
            }
        }
        System.out.println("After Sorting..");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] a){
        int n = a.length;
        for(int i=1; i<n; i++){
            if(a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {14,9,3,2,43,11,58,22};
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        binarySearch(arr1, 58);
    }

}

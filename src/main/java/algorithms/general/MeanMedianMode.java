package algorithms.general;

import java.util.Arrays;

public class MeanMedianMode {

    //Mean of an array = (sum of all elements) / (number of elements)
    public static double findMean(int[] a){
        if(!isSorted(a)){
            sort(a);
        }
        int n = a.length;
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return (double)sum / (double)n;
    }

    public static double findMedian(int[] a){
        if(!isSorted(a)){
            sort(a);
        }
        int n = a.length;
        int mid = n/2;
        //check if the number of elements present in the array is even or odd
        if(n % 2 != 0){
            //If odd, then simply return the mid value of the array
            return (double) a[mid];
        }else{
            //the median is the average of the two middle values
            return (double) (a[(n-1) / 2] + a[mid] ) / 2.0;
        }
    }

    public static double findMode(int[] a){
        if(!isSorted(a)){
            sort(a);
        }
        int n = a.length;
        int maxValue = 0, maxCount = 0, i, j;

        for (i = 0; i < n; ++i) {
            int count = 0;
            for (j = 0; j < n; ++j) {
                if (a[j] == a[i])
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = a[i];
            }
        }
        return maxValue;
    }

    //selection sort                  // i
    public static void sort(int[] a){ //{2, 3, 4, 1, 6, 5, 8, 7}
        int n = a.length;             //          j
        for(int i=0; i < n; i++){
            int min = i;
            for(int j=i+1; j < n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int swap = a[i];
            a[i] = a[min];
            a[min] = swap;
        }
        assert isSorted(a);
        System.out.println("Sorted Array :" + Arrays.toString(a));
    }

    public static boolean isSorted(int[] a){
        int n = a.length;
        for(int i=1; i < n; i++){
            if(a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = {1, 3, 4, 2, 6, 5, 8, 7};
        System.out.println("Mean :" + MeanMedianMode.findMean(a));
        System.out.println("Median :" + MeanMedianMode.findMedian(a));
        System.out.println("Mode :" + MeanMedianMode.findMode(a));
    }
}

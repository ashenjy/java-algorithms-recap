package array;

import java.util.Arrays;

public class RemoveElement {
    /*Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).*/

    public static int removeElement(int[] nums, int val) {
        /*approach
        * 1st step: scan array left to right -> given an element, detect all occurences
        * 2nd: swap the matched element with the end elements
        * */
        int count = 0;

        for(int i=0; i < nums.length; i++){ //0
            if(nums[i] != val){
                /*nums[count++] = nums[i]; copies the value of nums[i] into nums[count] and then increments count by 1.
                This allows the code to keep track of the number of elements that are not equal to val,
                and then those elements are copied over to the beginning of the array.*/
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums, val);
    }
}

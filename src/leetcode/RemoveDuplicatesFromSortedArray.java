package leetcode;

import java.sql.Time;
import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    /*
    scenario 1:
    Input: nums = [1,1,2]
    nums sorted in non-decreasing order
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    scenario 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
    */

    /*
    * Approach
    * Check if the current and the next element are equal.
    If they are, we will skip the next element and will continue the procedure as long as we encounter the duplicates.
    If the elements are not duplicate, we will place the next (different) element next to the current element.*/

    /*Time Complexity
    We are scanning the array once, hence the time complexity will be O(n).

    Space Complexity
    Since we are forbidden to use the external data structure (and we are not using it 😛), the space complexity will be O(1).*/

    public static int removeDuplicates(int[] nums) {
        Objects.requireNonNull(nums);
        // Length of the updated array
        int count = 0;
        // Loop for all the elements in the array
        for(int i = 0; i < nums.length; i++){
            // If the current element is equal to the next element, we skip
            if(i < nums.length - 1 && nums[i] == nums[i+1] ){
                continue;
            }
            // We will update the array in place
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}

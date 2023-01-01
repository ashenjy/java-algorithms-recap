package leetcode.array;

/*
Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
*/
public class PivotIndex {


    public static int pivotIndex(int[] nums) {
        //sum of all elements in index
        int n = nums.length;
        int sum = 0;
        for(int i=0; i < n; i++){
            sum += nums[i];
        }
        int leftSum =0;
        for(int i=0; i < n; i++){
            /*If the leftSum is equal to the sum of all elements except the current element,
            then the index of the current element is returned,
            as that is the index of the element that makes the sum of all elements equal to 0.*/
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};
        int result = pivotIndex(nums);
    }
}

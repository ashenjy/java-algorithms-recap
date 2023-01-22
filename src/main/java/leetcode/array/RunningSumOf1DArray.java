package leetcode.array;

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
*/
public class RunningSumOf1DArray {


    /*Time Complexity: O(N) where N is the length of nums
Space Complexity: O(N) for our running sum array
or O(1) with an in-place approach
    * */
    public static int[] runningSum(int[] nums) { //nums: [1,2,3,4]
        int[] ans = new int[nums.length]; //ans: [0,0,0,0]
        ans[0] = nums[0];                //ans: [1,3,0,0]
        for(int i=1; i<nums.length; i++){  //i:1 , nums: [2,3,4]         i:2, nums[3,4]
            ans[i] = ans[i-1] + nums[i];  //1st -> ans[1] = ans[0] + nums[1],  (1 + 2) | 2nd -> ans[1] + nums[2] (3 + 3)
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] result = runningSum(nums);
    }
}

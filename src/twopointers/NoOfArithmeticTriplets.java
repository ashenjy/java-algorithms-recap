package twopointers;
/*
You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k)
is an arithmetic triplet if the following conditions are met:

i < j < k,
nums[j] - nums[i] == diff, and
nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.

Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
*/
public class NoOfArithmeticTriplets {
    /*Approach
    * have 2 pointers in the nums array
    * have 2 loops iterating the array
    * */
    public static int noOfUniqueTriplets(int[] nums, int dif){
        int count = 0;

        //assume nums = [1,4,7]
        for(int i= 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k]) {
                        if ((nums[j] - nums[i] == dif) && (nums[k] - nums[j] == dif)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {0,1,4,6,7,10};
        int dif = 3;
        int n = noOfUniqueTriplets(nums, dif);
    }
}

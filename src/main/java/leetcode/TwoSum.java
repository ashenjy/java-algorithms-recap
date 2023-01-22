package leetcode;

import java.util.Arrays;
import java.util.Objects;

public class TwoSum {

    // assume new int[] = {3,2,4} , target = 6
    public static int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums);

        for(int i = 0; i < nums.length; i++){
            //1st iteration -> 3 -> not target
            //2nd iteration -> 2
           for(int z = i + 1; z < nums.length; z++ ){
                //3 -> 1st iteration -> 3    +   2      not  6
               //3 -> 2nd iteration -> 3    +   4     not  6 -> breaks
               //2 -> 1st iteration -> 2    + 4  is 6 -> returns
               if((nums[i] + nums[z]) == target){
                    return new int[] {i, z};
               }
           }
        }
        return new int[] {};
    }

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


}

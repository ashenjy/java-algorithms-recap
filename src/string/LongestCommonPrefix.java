package string;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
* */
public class LongestCommonPrefix {


    /*Approach
    * find the shortest string and its length
    *
    * */
    public static String longestCommonPrefix(String[] strs){
       StringBuilder longestCommonPrefix = new StringBuilder();

       //base condition
        if(strs == null || strs.length == 0){
            return longestCommonPrefix.toString();
        }

        //find the minimum length string from the array
        int minLength = strs[0].length();
        for(int i=1; i< strs.length; i++){
            minLength = Math.min(minLength, strs[i].length());
        }

        //loop for the minimum length
        for (int i = 0; i < minLength; i++) {
            // Get the current character from first string
            char current = strs[0].charAt(i);
            // Check if this character is found in all other strings or not
            for(String str: strs){
                if(str.charAt(i) != current){
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(current);
        }
        return longestCommonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
    }
}

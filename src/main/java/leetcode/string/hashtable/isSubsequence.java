package leetcode.string.hashtable;
/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
* */
public class isSubsequence {

    /*Analysis               i:1         i:2                     i:3
    * s -> abc = index i    -> a continue: b             continue: c
    *                          =           =                       =
    * t -> ahbgdc - index j -> a continue: h continue: b continue: g continue: d continue: c
    *                        j:1         j:2         j:3         j:4         j:5         j:6
    * */
    public static boolean isSubsequence(String s, String t) {
        int pointer = 0;
        int matchCount = 0;

        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i); //sc: a
            for(int j=pointer; j<t.length(); j++){
                char tc = t.charAt(j); //tc: a
                if(sc == tc){
                    matchCount++;
                    pointer++;
                    break;
                }
                pointer++;
            }
        }
        if(s.length() == matchCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        boolean isSubsequence = isSubsequence("axc", "ahbgdc");
    }
}

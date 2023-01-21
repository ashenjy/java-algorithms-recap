package leetcode.string.hashtable;
/*
* Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
*
* Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
* */
public class isIsomorphicStrings {

    /*
    s: "egg" , t: "add"
        e -> a
        g -> d
      = add (is Isomorphic)
       s: "foo" , t: "bar"
        f -> b
        o -> a
      = baa (Not Isomorphic)
      1. create two char arrays -> length 256 - ascii character
      2. since s and t lengths are equal, use one for loop to iterate through both strings.
      3. define the mapping rule
      4. define the scenario where characters doesn't map, return false
    * */
    public static boolean isIsomorphic(String s, String t) { //s: "egg" , t: "add"
        char[] sm = new char[256]; // sm: ["","","",...]
        char[] tm = new char[256]; // tm: ["","","",...]
        int n = s.length();

        for(int i=0; i < n; i++){
            char sChar = s.charAt(i); // sChar: e
            char tChar = t.charAt(i); // tChar: g
            if(sm[sChar] == 0 && tm[tChar] == 0){
                sm[sChar] = tChar; // sm["e"]  = g
                tm[tChar] = sChar; //tm["g"] = e
            }else if(sm[sChar] != tChar){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        boolean isIsomorhpic = isIsomorphic("egg", "add");
    }
}
//
//    public static Integer find_total( Integer[] my_numbers ) {
//        int running_total = 0;
//        for (int i = 0; i < my_numbers.length; i++) {
//            if (my_numbers[i] % 2 != 0) {
//                if (my_numbers[i] == 5) {
//                    running_total += 5;
//                } else {
//                    running_total += 3;
//                }
//            } else {
//                running_total += 1;
//            }
//        }
//        return running_total;
//    }
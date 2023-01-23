package algorithms.string;

public class ReverseString {

    public static String reverseString(String s){
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for(int i=n-1; i >= 0; i--){
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        String reversed = reverseString("abc");
    }
}

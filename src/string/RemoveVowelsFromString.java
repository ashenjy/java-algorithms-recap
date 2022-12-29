package string;
/*
* Given a string, remove the vowels from the string and print the string without vowels.

Examples:

Input : welcome to geeksforgeeks
Output : wlcm t gksfrgks

Input : what is your name ?
Output : wht s yr nm ?
* */
public class RemoveVowelsFromString {

    public String removeVowels(String s){
        return s.replaceAll("[aeiouAEIOU]","");
    }

    public static void main(String[] args){
        System.out.println("String without vowels:"+ new RemoveVowelsFromString().removeVowels("What is your name?"));
    }
}

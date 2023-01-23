package algorithms.string;

public class CountVowelsConsonants {

    public static void countVowels_and_Consonants(String s){
        int n = s.length()-1;
        int vCount = 0, cCount = 0;
        s = s.toLowerCase();
        for(int i=0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vCount++;
            }
            else if(c >= 'a' && c <= 'z'){
                cCount++;
            }
        }
        System.out.println("Number of vowels: " + vCount);
        System.out.println("Number of consonants: " + cCount);
    }

    public static void main(String[] args){
        countVowels_and_Consonants("JavaScript");
    }
}

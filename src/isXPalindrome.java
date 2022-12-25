import java.util.Scanner;

public class isXPalindrome {

/*Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.*/

    /*/*Input: x = -121
Output: false
Explanation: -121 reads as 12-1 from left to right and from right to left.*/

    /*Input: x = 10
Output: false
Explanation: 10 reads as 01 from left to right and from right to left.*/

    /*Approach
    * x = 0 then true and if x % 10 == 0, then false
    * while loop x, and reverse the number by popping each out and adding it
    * */
    public static boolean isPalindrome(int x){
        if(x == 0){
            return true;
        }

        //10 -> 01 is false
        if(x < 0 || x % 10 == 0){
            return false;
        }

        int reversed_int = 0;

        //assume x is 1234
        while(x > reversed_int){
            int remainder = x % 10; //4
            reversed_int = reversed_int * 10 + remainder; // 4
            x = x / 10; //123
        }
        // 1234 == 4321         1234 == 432
        if(x == reversed_int || x == (reversed_int / 10)){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println("Enter number:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Is the number a palindrome? :" + isXPalindrome.isPalindrome(num));
    }
}

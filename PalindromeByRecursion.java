import java.util.Scanner;

public class PalindromeByRecursion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String s = input.nextLine();
        if( isPalindrome(s)){
            System.out.println("The string is a palindrome.");
        }else{
            System.out.println("String is not a palindrome.");
        }


    }public static boolean isPalindrome(String s) {
        if (s.length() <= 1) { // Base case
            return true;
        }
        else if (s.charAt(0) != s.charAt(s.length() - 1)) { // Base case
            return false;
        }
        else {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
    }
}

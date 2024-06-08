import java.util.Scanner;

public class ReverseNum{

		public static void main (String args [] ){

			Scanner input = new Scanner(System.in);
			System.out.print("Enter the number : ");
			int num = input.nextInt();

			int reversedNum = reverse(num);

			System.out.print(reversedNum);

			if (isPalindrome(num , reversedNum)){

				System.out.print("The number is a palindrome.");

			}else {

				System.out.print("The number is not a palindrome.");
			
			}
		} 
		public static int reverse ( int num){

			int reversedNum = 0 ;
			 while (num != 0){

			 	int remainder = num % 10 ;

			 	reversedNum = reversedNum * 10 + remainder ;

			 	num = num / 10 ;
			 }
			 return reversedNum;
		}
		public static boolean isPalindrome( int num, int reversedNum ){

			if ( num == reversedNum){
				return true ;
			}
			return false ;
		}
}
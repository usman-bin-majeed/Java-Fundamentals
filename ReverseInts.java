import java.util.Scanner;

public class ReverseInts{

	public static void main (String args []){

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the integer to reverse : ");
		int num = input.nextInt();
		int result = reveseNum(num);
		System.out.print("THe reverse of the number is :  " + result);



	}
	public static int reveseNum( int num){
		int reversedNum = 0 ;
		while ( num != 0){
			int remainder = num % 10 ;
			reversedNum = reversedNum * 10 + remainder ;
			num /= 10 ;
		}
		return reversedNum;
	}

}



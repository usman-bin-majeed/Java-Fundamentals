import java.util.Scanner;

public class SumInts {

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);
		System.out.print("Enter the number : ");
		int num = input.nextInt();
		int result = sumInt(num) ;
		System.out.print("The sum of ints in the digit is : "+ result);





	}
	public static int sumInt( int num){

		int sum = 0 ;
		while ( num != 0){
			sum += num % 10 ;
			num /= 10;
		}
		return sum ;
	}


}







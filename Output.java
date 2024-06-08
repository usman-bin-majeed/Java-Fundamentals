import java.util.Scanner;

public class Output{

		public static void main (String [] args){

			Scanner input = new Scanner(System.in);
			System.out.print("ENter the number : ");
			int num = input.nextInt();
			int reverse = reverseNum(num);

			System.out.print("The reverse of your number is : "+ reverse);



		}
			public static int reverseNum(int num){

				int newNumber = 0;
				while (num > 0){

					int digit = num % 10 ;

					newNumber =newNumber * 10 + digit ;

					num /= 10 ;


				}return newNumber;



			}


}
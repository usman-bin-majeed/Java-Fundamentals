import java.util.Scanner ;

public class PrimeChecker {

	public static void main ( String args []){

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = input.nextInt();
		boolean result = isPrime(num);

		if(isPrime(num)){
			System.out.print("The number is prime.");
		}else{
			System.out.print("The number is not prime.");
		}
	}
	public static boolean isPrime( int num){

		for ( int i = 2 ; i <= num / 2 ; i++){

			if ( num % i == 0){
				return false;
			}


		}return true;

	}

}
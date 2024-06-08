import java.util.Scanner;

public class MaxPrimes{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);

		int row1 = 0;
		int row2 = 0;
		int row3 = 0;

		int [][] arr = new int[3][4] ;

		for ( int i = 0 ; i < arr.length ; i++){

			for( int j= 0 ; j < arr[i].length ; j++){

				System.out.println("Enter the number : ");
			arr[i][j] = input.nextInt();

			}
		}

		for ( int k = 0 ; k < arr.length ; k++){
			int num;
			for ( int l = 0 ; l < arr[k].length ; l++  ){

				num = arr[k][l] ;

				boolean isPrime = isPrime( num );
				if ( isPrime && k == 0){
					row1++;

				}else if ( isPrime&& k == 1){
					row2++;

				}else if ( isPrime&& k == 2){
					row3++;

				}



	}		
}

	int maxPrimeNums = Math.max( row1, Math.max( row2, row3));
	System.out.println("The number of prime numebr is : " + maxPrimeNums);

	}
	public static boolean isPrime( int num){

		for ( int i = 1 ;  i < num / 2 ; i++){
			if ( num % i == 0){
				return false ;
			}
		}return true;



	}
}
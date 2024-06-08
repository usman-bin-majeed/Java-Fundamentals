import java.util.Scanner;

public class MaxRowSum{

	public static void main ( String args [] ){

		int maximumSumRow  = 0 ;

		int maximumSumColumn  = 0 ;


		Scanner input = new Scanner( System.in);

		int[][] arr = new int[3][3];

		for ( int i = 0 ; i < arr.length ; i++){
			for ( int j = 0 ; j < arr[i].length ; j++){

				System.out.print("ENter the number : ");
			arr[i][j] = input.nextInt();
			} 	
		}
		for ( int k = 0 ; k < arr.length ; k++){

			int sum = 0 ;

			for ( int l = 0 ; l < arr[k].length ; l++){

				sum+= arr[k][l];

			}
			if ( sum > maximumSumRow){
				maximumSumRow = k + 1 ;
			}

		}

		for ( int m = 0 ; m < arr[0].length  ; m++){

			int colSum = 0 ;

			for ( int n = 0 ; n < arr.length ; n++ ){
				colSum += arr [n][m] ;

			}
				if ( colSum > maximumSumColumn){
					maximumSumColumn = m + 1;
				}
		}
		System.out.println(" The row with the maximum sum is : " + maximumSumRow );
		System.out.println(" The column with the maximum sum is : " + maximumSumColumn );
	}  

}
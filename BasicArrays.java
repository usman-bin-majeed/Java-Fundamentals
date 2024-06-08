import java.util.Scanner;

public class BasicArrays{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);
			
		int [] arr = new int[10];

			for( int i = 0 ; i < 10 ; i++){
				System.out.print("ENter the number : ");
				arr[i] = input.nextInt();

			}		

			System.out.print( printArray(arr));

	}

		public static int[] printArray( int[] arr){

			for ( int j = 0 ; j < arr.length ; j++ ){
			
				System.out.println(arr[j]);
			}
			return arr ;
		}
}
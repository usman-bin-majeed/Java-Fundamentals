import java.util.Scanner;

public class Sorted{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);

		int[] arr = { 1,2,3,4,5,6,-7};

		boolean isSorted = isSorted( arr);
		if (isSorted){
			System.out.print("THe array is sorted.");

		}else{
			System.out.print("THe array is not sorted.");
		}


	}
	public static boolean isSorted( int[] arr){

		for ( int i = 0 ; i < arr.length ; i++){

			if ( arr[i+1] >= arr[i] ){

				return false;
			}
		}
		return true;

	}

}
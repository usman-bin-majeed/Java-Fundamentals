import java.util.Scanner;

public class Deletion{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);

		int index;

		int[] arr = { 1,2,3,4,5,6,7,8,9} ;
		int[] newArray = new int[20] ;

		System.out.print("Enter the number to delete : ");
		int num = input.nextInt();

		 for ( int i = 0  ; i < arr.length ; i++ ){

		 	if ( arr[i] == num){

		 		index = i ;

		 	}
		 }

		 for( int j = 0 ; j < arr.length ; j++){

		 	if ( arr[j] == num){
		 		continue;
		 	}else{
		 	newArray[j] = arr[j] ;
		 }
		 }



	}
	

}
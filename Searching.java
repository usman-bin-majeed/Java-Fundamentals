import java.util.Scanner;

public class Searching {

	public static void main ( String [] args){

		Scanner input = new Scanner( System.in);

		int[] arr = {10, 20 , 30 , 50 , 89 , 65 , 78 , 89} ;

		System.out.print("Welcome to array Searching ");

		System.out.println("Enter the number you want to search : ");
		int key = input.nextInt();
	
		boolean isFound = isFound( key , arr);

		if ( isFound){
			System.out.print("The number is found in the array.");
		}else{
			System.out.print("THe number is not present in the array.");
		}



	}
	public static boolean isFound( int key , int[] arr){

		for ( int i = 0 ; i < arr.length ; i++){

			if ( key == arr[i]){

				return  true;
			}		
				}
				return false;
		}


	}



import java.util.Scanner;

public class MaxMin{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);

		int[] arr = { 1,2 ,6,8,0,15,99, -333,  33 ,19,-3};
		int max = arr[0] ;
		int min =  arr[0] ;


		for ( int i = 0 ; i < arr.length ; i++){

			if ( arr[i] > max){
				max = arr[i] ;
			}else if ( arr[i] < min){
				min = arr[i];
			}

		}
		System.out.println("The maximum number is : "+ max  );
		System.out.println("The minimum number is : "+ min );



	}
}
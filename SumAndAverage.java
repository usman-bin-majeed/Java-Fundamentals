import java.util.Scanner;

public class SumAndAverage{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);
		System.out.print("Welcome to Array sum and average.");
		System.out.println("Please enter the size of the array.");

		int sum = 0 ;
		int average = 0 ;

		int size = input.nextInt();

		int[] arr = new int[size];

		for ( int i = 0 ; i <  arr.length ; i++){

			System.out.println("Enter  the number to add the number at " + ( i + 1 ) + " position : ");
			arr[i] = input.nextInt();
		}


		 sum = sumOfEle(arr) ;
		 average = aveOfEle(arr);
		 System.out.println("THe sum of the elements is : " + sum);
		 System.out.println("THe average of the elements is : " + average);


	}
	public static int sumOfEle ( int[] arr){
		int sum = 0 ;
		for ( int i = 0 ; i < arr.length  ; i++){
			sum += arr[i];
		}
		return sum ;
	}

	public static int aveOfEle(int[] arr) {
    int sum = sumOfEle(arr);
    int average =  sum / arr.length;
    return average;
}

}


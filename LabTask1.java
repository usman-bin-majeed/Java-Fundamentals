import java.util.Scanner;

public class LabTask1{

	public static void main ( String args []){

		Scanner input = new Scanner( System.in);
		System.out.print("Enter the size of the array : ");
		int size = input.nextInt();

		int[] arr = new int[size];

		int bad = 0 ;
		int good = 0 ;
		int veryGood = 0 ;


		for ( int i = 0 ; i < arr.length ; i++ ){
			System.out.println("Enter the rating number from 1-10 : ");
			arr[i] = input.nextInt();

		}

		for ( int j = 0 ;  j < arr.length ; j++){

			if ( arr[j] >= 0 && arr[j] <= 3 ){

				bad++;
			}else if (arr[j] > 3 && arr[j] <=6   ){
				good++;
			}else if ( arr[j] > 6 && arr[j] <=10){
				veryGood++;
			}


		}
	System.out.println("The number of bad ratings are : " + bad);
System.out.println("The number of good ratings are : " + good);
System.out.println("The number of veryGood ratings are : " + veryGood);
	} 

}
import java.util.Scanner;

public class Qno1 {

	public static void main (String args []){

		Scanner input = new Scanner (System.in);
		int firstMax = 0;
		int secondMax = 0;
		int thirdMax = 0 ;
		int seq ;
		
		do {
			System.out.println("Enter the sequence of numbers ending with zero : ");
			seq = input.nextInt();

			if ( seq > firstMax){
				secondMax = firstMax ;
				thirdMax = secondMax ;
				firstMax = seq ;

			}else if ( seq > secondMax && seq < firstMax){

				secondMax = seq ;
				thirdMax = secondMax ;

			}else if ( seq > thirdMax && seq < secondMax){
				thirdMax = seq ;
		}
			}while(seq != 0);
		System.out.println("The three highest integers are : " + firstMax + "> " + secondMax+ "> " + thirdMax);
	}
}
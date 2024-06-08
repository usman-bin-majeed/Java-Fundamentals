import java.util.Scanner ;

public class Qno3{

	public static void main (String args []){

		Scanner input = new Scanner (System.in);

		int positive = 0 ;
		int negative = 0 ;
		float average ;
		int total  = 0;
		int seq ;
		int count = 0;

		do {

			System.out.print("Enter the number : ");
			seq = input.nextInt();

			count++ ;

			if (seq < 0){
				negative++ ;

			}else if (seq > 0){

				positive++ ;
			}
			total += seq ;


		}while(seq != 0);
		
		average = (float) total / count ;

		System.out.print("Average : " + average + " Total Integers : " + total + " Positive Integers : "+ positive + " Negative Integers : " + negative);
	}

}
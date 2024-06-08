import java.util.Scanner;

public class Recusrion2{
	public static void main ( String args []){

		Scanner input = new Scanner( System.in);

		int num  = 123456789;
		
		printReverse( num);

	}
public static void printReverse(int num) {
    if (num > 0) {
      System.out.print(num % 10);
      printReverse(num / 10);
    }
  }
}
import java.util.Scanner;

public class CharLogic {

		public static void main (String args []){

			Scanner input = new Scanner(System.in);
			System.out.print("Enter the start character : ");
			String str1 = input.nextLine();
			char ch1 =  str1.charAt(0) ;

			System.out.print("Enter the end character : ");
			String str2 = input.nextLine();
			char ch2 = str2.charAt(0);

			System.out.println("Enter the count of chars in one line : ");
			int numberPerLine = input.nextInt();

			printChars(ch1 , ch2 , numberPerLine);
			
		}
		public static void printChars( char ch1 , char ch2  , int numberPerLine){

			int count = 0 ;
			for ( int i = ch1 ; i <= ch2 ;  i++){

				// char ch = (char) i ;

				System.out.print((char) i);
				count++;

				if (count % numberPerLine == 0){

					System.out.println();
				}

			}




		}
}
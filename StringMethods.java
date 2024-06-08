import java.util.Scanner;

public class StringMethods {
	public static void main (String args []){

		Scanner input = new Scanner (System.in);
		System.out.print("Enter the string : ");
		String str = input.nextLine();
			int vowels = 0 ;

		for ( int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if ( ch == 'A' || ch == 'I' || ch == 'E' || ch == '0' || ch == 'U' || ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){

				vowels++;
			}

		}System.out.println("The number of vowels are : " + vowels);

		if ( str.contains("Usman")){
			System.out.print("String contains the first name.");
		}
		String chars = str.trim();
		int NoOfChars = chars.length();
		System.out.println("The number of characters in string are : " + NoOfChars);

		










	}

}
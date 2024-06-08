import java.util.Scanner;

public class PassCheck{
	
	public static void main (String args []){

		Scanner input = new Scanner (System.in);
		while (true){

			System.out.print("Enter the password : ");
			String pass = input.nextLine();

			if (pass.length() >= 8 && containUpperCase(pass) && containDigit(pass)){
				System.out.print("The password is strong.");
				break;

			}else {
				System.out.println("Weak password. Re-enter the password.");
			}
		}
	} public static boolean containUpperCase(String pass){
		for ( int i = 0 ; i < pass.length() ; i++){
			
			char ch = pass.charAt(i);
			
			if ( ch < 'A' && ch > 'Z' ){
					return true;
			}
		}return false;
	}public static boolean containDigit(String pass){
		
		for ( int i = 0 ; i < pass.length() ; i++){
			char ch = pass.charAt(i);
		
			if ( Character.isDigit(ch)){
				return true;
			}
		}return false;
	}
}
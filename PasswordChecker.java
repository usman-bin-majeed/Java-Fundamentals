import java.util.Scanner;

public class PasswordChecker{

	public static void main (String args []){

		Scanner input = new Scanner(System.in);
		while (true){
			System.out.print("ENter the password : ");
			String password = input.nextLine();
			if (password.length() >= 8 && containUpperCase(password) && containDigit(password)) {
				System.out.print("THe password is strong.");
				break;
			}else{
				System.out.print("Weak password. Re-enter the password.");

			}

		}
	} public static boolean containUpperCase(String password){
		for (int i = 0 ; i < password.length() ; i++){
			char ch = password.charAt(i);
			if ( ch >= 'A' && ch <= 'Z'){
				return true;
			}
		}return false;
	}

	public static boolean containDigit( String password){
		for ( int i = 0 ; i < password.length() ; i++){
			char ch = password.charAt(i);
			if ( Character.isDigit(ch)){
				return true;
			}
		}return false;
	}

}
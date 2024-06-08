import java.util.Scanner;

public class Qno2 {

	public static void main (String args []){

	
		Scanner input = new Scanner (System.in);

		while (true){
			System.out.prin("Enter the password : ");
			String password = input.nextLine();

			if ( password.length() >= 8 && containUpperCase(password)){
				System.out.println("THe password is strong.");
				break;
			}else {
				System.out.println("password is weak. Re-enter the password.");
			}
		}

	}public static boolean containUpperCase(String password){
		for (int i = 0 ; i < password.length() ; i++ ){
			char ch = password.charAt(i);
			if ( ch >= 'A' && ch <= 'Z'){
				return true;
			}
		}return false;
	}

}
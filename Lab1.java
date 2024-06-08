import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean isInt = false;
        do{
            try{
                System.out.println("Enter the number : ");
                int num1 = input.nextInt();
                System.out.println("Enter the second number : ");
                int num2 = input.nextInt();

                int sum = num1 + num2;

                isInt = true;
                System.out.println(sum);
            }catch (InputMismatchException ex){
                System.out.println("Invalid output.");
                input.nextLine();
            }
        }while (isInt != true );

    }

}

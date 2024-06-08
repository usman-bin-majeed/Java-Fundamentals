import java.util.InputMismatchException;
import java.util.Scanner;

public class SumErrorHandling {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;
        int num1 = 0 ;
        int num2 = 0 ;

        do{
            while(true){
                try {
                    System.out.println("ENter the number : ");
                    num1 = input.nextInt();
                    System.out.println("ENter the second number : ");
                    num2 = input.nextInt();
                    break;

                } catch (InputMismatchException ex) {
                    input.nextLine();
                    System.out.println("Invalid Input. Re-Enter the number.");
                }
            }

            int sum = num1 + num2 ;
            System.out.println("The sum of the numbers is : "+ sum);


            while(true){
                try {
                    System.out.println("Press 0 to exit  OR enter any number to do sum again... : ");
                    choice = input.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    input.nextLine();
                    System.out.println("Invalid Input. Re-Enter.");
                }
            }




        }while(choice != 0);



    }
}

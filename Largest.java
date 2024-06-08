import java.util.InputMismatchException;
import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num  = 0 ;
        int largest = num ;
        do{
            while(true){
                try {
                    System.out.println("ENter the number : ");
                    num = input.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input. Re-enter the number.");
                    input.nextLine();
                }
            }

            if ( num > largest){
                largest = num ;
            }

        }while (num != 0);

        System.out.println("THe largest number in the sequence is : " + largest);
    }
}

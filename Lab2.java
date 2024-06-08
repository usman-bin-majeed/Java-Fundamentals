import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] arr = new int[10];

        boolean validInput = true;

        while (validInput) {
            for (int i = 0; i < arr.length; i++) {

                System.out.println("Enter the number : ");
                try {
                    arr[i] = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid Input.");
                    i--;
                    input.nextLine();
                }
            }
            validInput = false;
        }

        System.out.println("Enter the numebr or index : ");
        boolean correctIndex = false;

        while (correctIndex == false) {
            try {
                int index = input.nextInt();
                int value = arr[index];
                System.out.println("The value at " + index + " is " + value);
                correctIndex = true;

            } catch (InputMismatchException ex) {
                System.out.println("Invalid Input...Enter the integer value.");
                input.nextLine();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Please enter the index within length of array.");
                input.nextLine();
            }


        }
    }
}

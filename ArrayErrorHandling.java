import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayErrorHandling {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int[] arr = new int[10] ;

        for ( int i = 0 ; i < arr.length ; i++){
            while(true){

                try{
                    System.out.println("Enter the number : ");
                    arr[i] = input.nextInt();
                    break;
                }catch (InputMismatchException ex){
                    input.nextLine();
                    System.out.println("Invalid Input. Re-Enter the number.");
                }
            }
        }

        System.out.println();
        System.out.println("...ARRAY INPUT COMPLETED...");
        System.out.println();

        while(true){
            try{
                System.out.println("Enter the index to get the number : ");
                int index = input.nextInt();
                System.out.println("The number at the provided index is : " + arr[index]);
                break;
            }catch (InputMismatchException ex){
                input.nextLine();
                System.out.println("Invalid Input... Please Re-Enter. ");
            }catch (IndexOutOfBoundsException ex){
                input.nextLine();
                System.out.println("Invalid Index. Please Re-Enter the Index b/w 1 - 10 .");
            }
        }




    }
}

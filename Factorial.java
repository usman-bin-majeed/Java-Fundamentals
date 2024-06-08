import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int num = input.nextInt();

        int factorial = factorial(num);
        System.out.println("The factorial of the number is :  " + factorial);





    }public static int factorial( int num){

        int result = 1;
       for ( int i = 1 ; i <= num ; i++){

           result *= i ;

       }
       return result;
    }
}

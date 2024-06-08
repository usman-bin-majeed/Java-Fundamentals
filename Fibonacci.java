import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int num = input.nextInt();

        System.out.println("Fibonacci series is : ");
        fibonacci(num) ;

    }

    public static void fibonacci ( int num){
        int first = 0 ;
        int second = 1 ;
        while( first + second <= num ){
        
        int third = first + second ;
        System.out.print( third + " ");

        first = second ;
        second = third ;

        }
    }
}

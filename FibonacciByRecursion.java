import java.util.Scanner;

public class FibonacciByRecursion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the index : ");
        int index = input.nextInt();

        int fibo = fibonacci(index);
        System.out.println("The fibonacci is : " + fibo);


    }public static int fibonacci( int index){
        if ( index == 0 || index == 1){
            return 1 ;

        }else{
            return fibonacci(index - 1 ) + fibonacci( index - 2);
        }
    }
}

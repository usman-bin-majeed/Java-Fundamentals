import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int num = input.nextInt();

        int sum = sumOfDigits(num);
        System.out.println("The sum of the digits is : " + sum);


    }public static int sumOfDigits( int num){

        int sum  = 0 ;
        while( num != 0 ){

            int remain = num % 10 ;
            sum += remain ;
            num = (int) num / 10 ;

        }
        return sum;
    }
}

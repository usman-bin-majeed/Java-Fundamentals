import java.util.Scanner;

public class ReverseDigits {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int num = input.nextInt();

        System.out.println("-------------");
        System.out.println(reverseDigits(num));


    }public static int reverseDigits( int num){

        String temp = "" ;
        int reverse = 0 ;
        while( num != 0){

            int remain = num % 10 ;

            temp += remain ;

            num =  (int) num / 10 ;
        }
//        System.out.println("The reverse of the number is : " + reverse);

        reverse = Integer.parseInt(temp);

        return  reverse ;
    }
}

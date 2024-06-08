import java.util.Scanner;

public class FactorialByRecursion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int num = input.nextInt();

        int fact = Factorial(num);
        System.out.println("Factorial : " + fact);







   }  public static int Factorial( int num){

       if ( num == 0){
           return 1;
       }
       return num * Factorial( num - 1);

    }
}

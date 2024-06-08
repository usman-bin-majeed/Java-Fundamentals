import java.util.InputMismatchException;
import java.util.Scanner;

public class EvenCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int seq;
        int count = 0;

        do{
            while(true){
                try{
                    System.out.println("Enter the number : ");
                    seq = input.nextInt();
                    break;

                }catch (InputMismatchException ex ){
                    input.nextLine();
                    System.out.println("Invalid input. Re-enter the number.");
                }
            }

            if(isPrime(seq)){
                count += 1 ;
            }

        }while(seq != 0);

        System.out.println("The number of prime number in the sequence is " + count);


    }public static boolean isPrime( int seq){

        boolean prime = true ;
            for ( int i = 2 ; i < seq / 2 ; i++){
                if ( seq % i == 0 ){
                    prime =  false;
                }
            }
        return prime;
    }
}

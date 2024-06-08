import java.util.Scanner;

public class CountOccurences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = new int[10];

        for ( int i  = 0 ; i < arr.length ; i++){
            System.out.println("Enter the number : ");
            arr[i] = input.nextInt();

        }
        for ( int j = 0 ; j < arr.length ; j++){
            int count = 0 ;
            for ( int k = 0 ; k < arr.length ; k++){

                if ( arr[j] == arr[k]){
                    count++;
                }
            }
            System.out.println("The " + arr[j] + " occurs " + count + " times ." );
            count  = 0 ;
        }
    }
}

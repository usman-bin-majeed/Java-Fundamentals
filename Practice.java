import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr = new int[5][5];

        for ( int i = 0 ; i < arr.length ; i++){
            for( int j = 0 ; j < arr[i].length ; j++){
                System.out.print("Enterr the number : ");
                arr[i][j] = input.nextInt();
            }
        }
        sumArray(arr);

    }
    public static void sumArray( int[][] arr){
        for ( int i = 0 ; i < arr.length ; i++){
            int sum = 0 ;
            for ( int j = 0 ; j < arr[i].length ; j++){
                sum += arr[i][j];
            }
            System.out.println("The sum of the row " + (i + 1) + " is " + sum);
        }
    }
}

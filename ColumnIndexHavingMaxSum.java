import java.util.Scanner;

public class ColumnIndexHavingMaxSum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int [][] arr = new int[3][4] ;

        for ( int i = 0 ; i < arr.length ; i++){
            for ( int j = 0 ; j < arr[i].length ; j++){
                System.out.print("Enter the number : ");
                arr[i][j] = input.nextInt();

            }
        }

        int maxSum = 0 ;
        int maxColIndex = 0 ;
        for ( int i = 0 ; i < arr[0].length ; i++ ){
            for ( int j = 0 ; j < arr[i].length ; j++){
                maxSum += arr[j][i] ;
            }
        }
        System.out.println(maxSum);


    }
}

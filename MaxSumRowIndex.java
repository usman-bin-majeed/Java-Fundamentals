import java.util.Scanner;

public class MaxSumRowIndex {
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
        int maxSumRowInd = 0 ;
        for( int i = 0 ; i < arr[0].length ; i++){

                maxSum += arr[0][i] ;

        }


        for ( int i = 0 ; i < arr.length ; i++){
            int sum = 0 ;
            for ( int j = 0 ; j < arr[i].length ; j++){

                sum += arr[i][j] ;

                if( sum > maxSum ){
                    maxSum = sum ;
                    maxSumRowInd = i ;
                }
            }
        }
        System.out.println("The row with the maximum sum has index : " + maxSumRowInd);


    }
}

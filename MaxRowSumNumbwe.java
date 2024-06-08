import java.util.Scanner;

public class MaxRowSumNumbwe {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[][] arr = new int[3][4] ;
        populateArray(arr);
        maxSumRow(arr);







    }
    public static void populateArray( int[][] arr){

        Scanner input = new Scanner(System.in);

        for( int i = 0 ; i < arr.length; i++){
            for ( int j = 0 ; j < arr[i].length ; j++){
                System.out.println("Enter the number : ");
                arr[i][j] = input.nextInt();
            }
        }

    }public static void maxSumRow(int[][] arr){

        int maxSum = 0 ;
        int maxRowInd = 0 ;

        for ( int i = 0 ; i < arr.length ; i++){
            for ( int j = 0 ; j < arr[0].length ; j++){
                maxSum += arr[i][j] ;
                maxRowInd = i ;
            }
        }

        for ( int k = 0 ; k < arr.length ; k++){
            int sum = 0 ;
            for ( int l = 0 ; l < arr[k].length ; l++){
                sum += arr[k][l] ;

            }
            if ( sum > maxSum){
                maxSum = sum ;
                maxRowInd = k ;
            }
        }
        System.out.println("The row with the maximum sum is : " + maxRowInd);

    }
}

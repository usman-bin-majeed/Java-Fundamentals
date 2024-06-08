import java.util.Scanner;

public class MaxColSumNum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] arr = new int[3][4];
        populateArray(arr);
        maxSumCol(arr);













    }public static void populateArray(int[][] arr) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter the number : ");
                arr[i][j] = input.nextInt();
            }
        }
    }
    public static void maxSumCol( int[][] arr){

        int maxSum = 0 ;
        int maxSumInd = 0 ;

        for ( int i = 0 ; i < arr[0].length ; i++){
            for( int j = 0 ; j < arr.length ; j++){
                maxSum += arr[j][i] ;
                maxSumInd = i ;
            }
        }

        for ( int i = 0 ; i < arr[0].length ; i++){
            int sum = 0 ;
            for ( int j = 0 ; j < arr.length ; j++){

                sum += arr[j][i] ;
            }
            if ( sum > maxSum){
                maxSum = sum ;
                maxSumInd = i ;
            }
        }
        System.out.println("The columns with the maximum sum is : " + maxSumInd);
    }
}

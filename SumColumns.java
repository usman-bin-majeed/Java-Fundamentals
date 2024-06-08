import java.util.Scanner;

public class SumColumns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows : ");
        int rows = input.nextInt();
        System.out.println("Enter the number of rows : ");
        int cols = input.nextInt();

        int[][] arr = new int[rows][cols];
        arr = populateArr(arr);
        colSum(arr);
        rowSum(arr);
        maxSumRowIndex(arr);







    }
    public static int [][]populateArr( int[][] arr){
        Scanner input = new Scanner(System.in);

        for ( int i = 0 ; i < arr.length ; i++){
            for ( int j = 0 ; j < arr[i].length ; j++){
                System.out.println("Enter the number : ");
                arr[i][j] = input.nextInt();
            }
        }
        return arr ;
    }
    public static void colSum( int [][] arr){

//        int sum = 0 ;
        for ( int i = 0 ; i < arr[0].length ; i++){
            int colSum  = 0 ;
            for ( int j = 0 ; j < arr.length ; j++ ){
                colSum += arr[j][i] ;

            }
            System.out.println("THe sum of the row is : " + colSum);
        }
    }
    public static void rowSum( int [][] arr){
        for ( int i = 0 ; i < arr.length ; i++){
            int rowSum = 0 ;
            for ( int j = 0 ; j < arr[i].length ; j++){

                rowSum += arr[i][j] ;

            }
            System.out.println("The sum of the row " + (i + 1) + " is " + rowSum);
        }
    }
    public static void maxSumRowIndex( int[][] arr){
        int maxSum = 0 ;
        for ( int k = 0 ; k < arr[0].length ; k++){
            maxSum += arr[0][k] ;
        }
        int indexOfMaxRow = 0 ;
        for( int i = 0 ; i < arr.length ; i++){
            int rowSum = 0 ;
            for ( int j = 0 ; j < arr[i].length ; j++){
                rowSum += arr[i][j] ;
            }
            if ( rowSum > maxSum){
                indexOfMaxRow = i ;
            }
        }
        System.out.println("The row with the max sum is : " + indexOfMaxRow);
    }

}

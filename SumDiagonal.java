import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows : ");
        int rows = input.nextInt();
        System.out.println("Enter the number of columns : ");
        int cols = input.nextInt();

        int[][] arr = new int[rows][cols];
        populateArray(arr);
        summingMajorDiagonals(arr);
        summingSubDiagonal(arr);

    }public static void populateArray( int[][]arr ){

        Scanner input = new Scanner(System.in);

        for ( int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.println("ENter the number : ");
                arr[i][j] = input.nextInt();
            }
        }
    }
    public static void summingMajorDiagonals( int[][] arr){

        int sum = 0 ;
        for ( int i = 0 ; i < arr.length ; i++){
            for ( int j = 0 ; j < arr[i].length ; j++){
                if ( i == j){
                    sum += arr[i][j] ;
                }
            }
        }
        System.out.println("The sum of the diagonal is : " + sum);
    }
    public static void summingSubDiagonal( int[][] arr){

        int subSum = 0 ;

        for ( int i = 0 ; i < arr.length ; i++){
            for ( int j = 0 ; j < arr[i].length ; j++){
                if ( (i + j == 2 ) ){
                    subSum += arr[i][j];
                }
            }
        }
        System.out.println("The sum of the sub diagonal is : " +subSum );
    }
}

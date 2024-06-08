import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in) ;

        int[][] arr1 = new int[3][3] ;
        int[][] arr2 = new int[3][3] ;
        populateArr1(arr1);
        System.out.println();
        System.out.println("---------ENTER ELEMENTS FOR TEH SECOND ARRAY--------");
        System.out.println();
        populateArr1(arr2);
        int[][] newArr = matrixMulitply(arr1 , arr2) ;

        for ( int i = 0 ; i < newArr.length ; i++){
            for ( int j = 0 ; j < newArr[i].length ; j++){

                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }

    }public static void populateArr1 ( int[][] arr1) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {

                System.out.println("Enter the number : ");
                arr1[i][j] = input.nextInt();
            }
        }



    }public static void populateArr2 ( int[][] arr2) {

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.println("Enter the number : ");
                arr2[i][j] = input.nextInt();
            }
        }
    }public static int[][] matrixMulitply( int[][] arr1 , int[][] arr2){

        int[][] newArr = new int[3][3] ;

        for ( int i = 0 ; i < arr1.length ; i++){
            for ( int j = 0 ; j < arr2[0].length ; j++){
                for ( int k = 0 ; k < arr2.length ; k++){
                    newArr[i][j]  += arr1[i][k] * arr2[j][k] ;
                }
            }
        }
        return newArr ;
    }

}

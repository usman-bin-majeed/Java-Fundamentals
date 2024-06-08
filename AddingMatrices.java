import java.util.Scanner;

public class AddingMatrices {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows for matrix 1 : ");
        int row1 = input.nextInt();
        System.out.println("ENter the number of columns for matrix 1 : ");
        int col1 = input.nextInt();

        System.out.println("Enter the number of rows for matrix 2 : ");
        int row2 = input.nextInt();
        System.out.println("Enter the number of columns for matrix 2 : ");
        int col2 = input.nextInt();

        int[][] arr1 = new int[row1][col1];
        for ( int j = 0 ; j < arr1.length ; j++){
            for ( int k = 0 ; k < arr1[j].length ; k++ ){
                System.out.println("Enter the number : ");
                arr1[j][k] = input.nextInt();
            }
        }

        int[][] arr2 = new int[row2][col2];
        for ( int a = 0 ; a < arr1.length ; a++){
            for ( int b = 0 ; b < arr1[a].length ; b++ ){
                System.out.println("Enter the number : ");
                arr1[a][b] = input.nextInt();
            }
        }

        int[][] newArr = addingMatrices(arr1 , arr2 , row1 , col1);
        for ( int x = 0 ; x < newArr.length ; x++){
            for ( int y = 0 ; y < newArr[x].length ; y++){
                System.out.println(newArr[x][y]);
            }
            System.out.println();
        }


    }public static int[][] addingMatrices( int[][] arr1 , int[][] arr2 , int row1 , int col1){

        int[][] newArr = new int[row1][col1] ;
        for ( int i = 0 ; i < arr1.length ; i++){
            for ( int j = 0 ; j < arr1[i].length ; j++){
                newArr[i][j] = (arr1[i][j] + arr2[i][j]) ;
            }
        }return newArr;
    }
    public static void printNewArray(int[][] newArr){
        for ( int i = 0 ; i < newArr.length ; i++ ){
            for ( int j= 0 ; j < newArr[i].length ; j++){
                System.out.print(newArr[i][j]);
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class SpecificColSum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows : ");
        int rows = input.nextInt();
        System.out.println("Enter the number of rows : ");
        int cols = input.nextInt();

        int[][] arr = new int[rows][cols];
        arr = populateArr(arr);


    }

    public static int[][] populateArr(int[][] arr) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter the number : ");
                arr[i][j] = input.nextInt();
            }
        }
        return arr;
    }
    public static void specificColSum( int[][] arr){

    }
}

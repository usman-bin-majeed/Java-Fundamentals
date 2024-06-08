import java.util.Scanner;

public class RemovingArrayDuplicates {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows : ");
        int size = input.nextInt();

        int[] arr = new int[size];

        for ( int i = 0 ; i < arr.length ; i++ ){
            System.out.println("Enter the number : ");
            arr[i] = input.nextInt();
        }

        System.out.println("Here comes the modified array.");
        System.out.println();

        int[] newArr = eliminateDuplicates(arr, size);
        for (int j : newArr) {
            System.out.println(j);
        }
        

    }public static int[] eliminateDuplicates( int[] arr , int size){

        int[] newArr = new int[size];

        for ( int j = 0 ; j < arr.length ; j++){

            for ( int k = 0 ; k < arr.length ; k++){

                if ( arr[j] != arr[k]){

                    newArr[j] = arr[j];
                }
            }
        }
        return  newArr;
    }

}

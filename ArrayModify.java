import java.util.Scanner;

public class ArrayModify {
    public static void main(String[] args) {


        int[] arr = { 1 , 2, 3 , 4, 5} ;

        reverseArr(arr);
        int[] newArr = arr ;

        for ( int i = 0 ; i < newArr.length ; i++){
            System.out.println(newArr[i]);
        }



    }public static void reverseArr( int[] arr){

        int temp;
        for ( int i = 0 ; i < arr.length / 2  ; i++){

            temp = arr[i] ;

            arr[i] = arr[(arr.length - 1) - i] ;

            arr[(arr.length - 1) - i ] = temp ;
        }
    }

}

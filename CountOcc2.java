public class CountOcc2 {
    public static void main(String[] args) {

        int[] arr  = { 1,2,3,4,4,4,7,8,9};

        countOccs(arr);

    }public static void countOccs( int[] arr){

        for ( int i = 0 ; i < arr.length ; i++){
            int count = 0 ;
            for ( int j = 0 ; j < arr.length ; j++){

                if ( arr[i] == arr[j] ){
                    count++;
                }
            }
            System.out.println("The number of occurences of " + arr[i] + " is " + count);
        }
    }
}

public class BasicArr {
    public static void main(String[] args) {

        int[] arr = { 1 , 2  , 3 , 4 , 5 };


        int[] newArr = modify(arr);

       for ( int i = 0 ; i < newArr.length ; i++ ){
           System.out.println(arr[i]);
       }

    }public static int[] modify(int[] arr){
        int[] newArr = new int[arr.length];

        for ( int i = 0 ; i < arr.length ; i++){
            arr[i] *= 3 ;
        }
        return newArr;
    }
}

public class RreverseArr {
    public static void main(String[] args) {


        int[] arr = { 1 ,2 , 3 , 4 , 5};


        arr = revArr( arr);

        int[] newArr = arr ;



       for ( int i = 0 ; i < newArr.length ; i++){
           System.out.println(newArr[i]);
       }



    }public static int[] revArr( int[] arr){



        for ( int i = 0 ; i < arr.length/2; i++){

            int temp = arr[i] ;
            arr[i] = arr[(arr.length - 1) - i] ;
            arr[(arr.length - 1) - i] =  temp ;

        }
        return arr ;
    }
}

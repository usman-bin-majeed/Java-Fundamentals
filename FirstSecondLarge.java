public class FirstSecondLarge {

	public static void main ( String  args []){

		int[] arr = { 1 ,2,3,4,5,7,8,9,10};

		int firstLarge = Integer.MIN_VALUE; 
		int secondLarge = Integer.MIN_VALUE ;
		int index = 0 ;

		for ( int i = 0 ; i <  arr.length ; i++ ){
			if ( arr[i] > firstLarge){
				firstLarge = arr[i];
				index = i ;
			}
		}

		for ( int j = 0 ; j < arr.length ; j++){

			if ( j == index){
				continue;
			}else if(arr[j] > secondLarge) {

				secondLarge = arr[j];

			}

		}



System.out.println(firstLarge);

System.out.println(secondLarge);



	}

}
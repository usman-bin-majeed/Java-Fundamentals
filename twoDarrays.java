
public class twoDarrays{

	public static void main ( String args []){

		int[][] arr = { { 0 , 1 , 2 } , { 4, 5 , 6 } , { 7 , 8  , 9} };


		for ( int rows = 0 ; rows < arr.length ; rows++){
			for ( int columns = 0 ; columns < arr[rows].length ; columns++ ){
				System.out.print(arr[rows][columns] + " ");
			}
			System.out.println();
		}


	}



}
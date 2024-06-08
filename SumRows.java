import java.util.Scanner;

public class SumRows{

 public static void main(String[] args) {

 	Scanner input = new Scanner( System.in);
 	System.out.println("Enter the number of rows : ");
 	int rows = input.nextInt();
 	System.out.println("Enter the number of columns : ");
 	int columns = input.nextInt();

 	int  maxSumOfRow = Integer.MIN_VALUE ;
 	int maxRowNo = 0 ;


 	int[][] arr = new int[rows][columns];


 	for ( int i =  0 ; i < arr.length ; i++){
 		for ( int j = 0 ; j < arr.length ; j++){
 			System.out.println("Enter the number :  ");
 			arr[i][j] = input.nextInt();
 		}
 	}

 	for ( int a = 0 ; a < arr.length ; a++){
 		int currSum = 0 ;
 		for (int b = 0 ; b < arr[a].length ; b++){
 			currSum+= arr[a][b] ;
 		}

 		if ( currSum > maxSumOfRow){
 			maxSumOfRow = currSum ;
 			maxRowNo = a ;
 		}


 		}

	}		
	
}		

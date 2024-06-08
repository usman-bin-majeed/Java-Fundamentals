import java.io.*;
import java.util.Scanner;

public class FileHandling3 {
    public static void main(String[] args) {


        try{
            File file = new File("C:\\Users\\u4usm\\Desktop\\file.txt");

            PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\u4usm\\Desktop\\file.txt" , true) );
            Scanner object = new Scanner(file);
            while( object.hasNext()){

                int num = object.nextInt();
                if( isPrime(num)){
                    continue;
                }else{
                    System.out.println(num);
                    pw.write(num);
                }
                object.close();
                pw.close();
            }


        }catch (Exception ex){
            System.out.println("Exception Occured...");
        }






    }public static boolean isPrime( int num){
        if ( num == 0 || num == 1){
            return false;

        }for ( int i = 2 ; i < Math.sqrt( num) ; i++ ){
            if ( num % i  == 0){
                return false;
            }
        }return true;
    }
}

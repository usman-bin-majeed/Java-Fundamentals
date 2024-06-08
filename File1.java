import java.io.* ;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) {

        try{
            File file = new File("C:\\Users\\u4usm\\Desktop\\file.txt");

            Scanner reader = new Scanner(file);

            while( reader.hasNext()){

                int num = reader.nextInt();

                System.out.println(num);
            }


        }catch (IOException ex){
            System.out.println("IO Exception occured...");
        }


    }

}

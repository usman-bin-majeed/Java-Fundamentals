import java.io.*;
import java.util.Scanner;


public class FileHandling2 {
    public static void main(String[] args) {

        try{
            File file = new File("C:\\Users\\u4usm\\Desktop\\file.txt");
            Scanner object = new Scanner(file);

            while (object.hasNext()) {
                int num = object.nextInt();
                System.out.println(num);
            }
        }catch (Exception ex){
            System.out.println("Exception Occured.");
        }


    }
}

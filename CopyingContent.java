import java.io.*;

public class CopyingContent {
    public static void main(String[] args) throws Exception {

        FileInputStream fileIn = new FileInputStream("C:\\Users\\u4usm\\Desktop\\File.txt");
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\u4usm\\Desktop\\FileOut.txt");

        int i;
        while( ( i = fileIn.read() ) != -1){
            fileOut.write((char) i);
        }

        System.out.println("Data has been copied...");
    }
}

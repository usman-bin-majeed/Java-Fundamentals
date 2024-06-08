import java.io.*;

public class FileReading {
    public static void main(String[] args) {

        try{
            FileReader r = new FileReader("C:\\Users\\u4usm\\Desktop\\File.txt");
            try{

                int i ;
                while( (i = r.read()) != -1 ){
                    System.out.print((char) i);
                }
            }finally {
                r.close();
                System.out.println();
                System.out.println("File has been closed.");
            }
        }catch (IOException ex){
            System.out.print("Exception Handled.");
        }
    }
}

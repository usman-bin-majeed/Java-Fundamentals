import java.io.*;

public class FileWriting {
    public static void main(String[] args)  {


        try{
            FileWriter file = new FileWriter("C:\\Users\\u4usm\\Desktop\\File.txt");

            try{
                file.write("JAva is a good language.");

            }finally{
                file.close();
            }
            System.out.println("Data successfully worte in the file.");

        }catch(IOException ex){
            System.out.println("Exception Handled.");
        }






    }
}

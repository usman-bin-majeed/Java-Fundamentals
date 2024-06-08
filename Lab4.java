import java.io.FileReader;

public class Lab4 {
    public static void main(String[] args) {

        try{
            FileReader file = new FileReader("C:\\Users\\u4usm\\Desktop\\File.txt");

            try{
                int i;
                while ((i = file.read()) != -1) {
                    System.out.println((char) i);
                }
            }finally {
                System.out.println("File closed.");

            }
        }catch (Exception ex){
            System.out.println("Wror janaa dalta exception raaly dy...");
        }
    }
}

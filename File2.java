import java.util.Scanner;
import java.io.* ;

public class File2{
    public static void main(String[] args) {


        try{
            InputStreamReader isr = new InputStreamReader(System.in);

            System.out.println("Enter the numbers : ");
            int num = isr.read();

            while (isr.ready()){

                System.out.println((char )num);
                num = isr.read();
            }

            isr.close();
            System.out.println();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

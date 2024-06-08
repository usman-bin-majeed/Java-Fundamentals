import java.io.*;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        File file = new File("C:\\Users\\u4usm\\Desktop\\File.txt");

        try{
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < 10; i++) {
                System.out.println("Enter the number : ");
                int num = input.nextInt();
                pw.println(num);
            }
            pw.close();
        }catch (Exception ex){
            System.out.println("OOO... Yea TO EXception AAGYA...");
        }
    }
}

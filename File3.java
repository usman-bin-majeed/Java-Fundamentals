import java.io.*;
import java.util.Scanner;

public class File3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        File file = new File("C:\\Users\\u4usm\\Desktop\\file.txt");

        try{
            FileOutputStream fos = new FileOutputStream("C:\\Users\\u4usm\\Desktop\\file.txt");

            PrintWriter pw = new PrintWriter(fos);

            while( true){
                System.out.print("Enter number : Press 0 to exit : ");
                int num = input.nextInt();
                if ( num == 0){
                    break;
                }else{
                    pw.println(num);
                }

            }
            pw.close();
            System.out.println("File successfully written,");



        }catch (IOException ex){
            System.out.println("Error occurred.");
        }

        int sum = 0 ;
        int count = 0 ;
        try{
            Scanner Reader = new Scanner(file);
            while (Reader.hasNext()) {
                int num = Reader.nextInt();
                sum += num ;
                count++ ;
                System.out.println(num);
            }
            Reader.close();
            System.out.println("File Read Successfully.");

        }catch (IOException ex){
            System.out.println("Exception Occurred.");
        }

        int avg = sum / count ;
        System.out.println("The average of these numbers is : " + avg);

    }
}

import java.io.*;
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args) {

        try {
            File page = new File("C:\\Users\\u4usm\\Desktop\\File.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\u4usm\\Desktop\\FileOut.txt"));
            //PrintWriter pw = new PrintWriter(page);
            Scanner obj = new Scanner(page);
            while(obj.hasNext()){
                int num = obj.nextInt();
                if(check(num)){
                    continue;
                }else{
                    System.out.println(num);
                    pw.println(num);

                }

            }
            pw.close();
            obj.close();

        } catch (Exception e) {
            System.out.println("loo aagya");
        }


    }
    public static boolean  check(int num){
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if(num % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}

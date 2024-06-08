import java.io.File;
import java.io.PrintWriter;
public class Question1 {
    public static void main(String[] args) {
        try{
            File file = new File("E:\\Text_IO.txt");
            if(file.exists()){
                System.out.println("File already exists");
            }else{
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < 100; i++) {
                int num = (int) (Math.random() * 100);
                pw.print(num + " ");
            }
            pw.close();
        }catch(Exception e){
            System.out.println("File error");
        }
    }
}

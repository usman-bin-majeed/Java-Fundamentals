import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\u4usm\\Desktop\\File.txt");
//         try{
            if(file.createNewFile()) {
                System.out.println("The file has successfully created.");

            }else{
                System.out.println("FIle already exists.");
            }
//        catch (IOException x){
//             System.out.println("Exception ahs successfully been handled.");
//         }
        System.out.println(file.exists());


    }
}

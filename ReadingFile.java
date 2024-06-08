import java.io.File;

public class ReadingFile {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\u4usm\\Desktop\\File.txt");

        if( file.exists()){
            System.out.println("FIle name : " + file.getName());
            System.out.println("File location : " + file.getAbsolutePath() );
            System.out.println("File size : " + file.length() );
            System.out.println("File readable : " + file.canRead());
            System.out.println("File Writable : " + file.canWrite() );
            System.out.println("File Writable : " + file.delete() ); // THis will delete the file from the location.

        }
        else{
            System.out.println("File does not exists...");
        }
    }
}

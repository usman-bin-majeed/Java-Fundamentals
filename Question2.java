import java.io.*;
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            File file = new File("E:\\123.txt");
            Scanner object = new Scanner(file);
            int totalWords = 0;
            int totalCharacter = 0;
            int totalLines = 0;
            while(object.hasNextLine()){
                String data = object.nextLine();
                totalCharacter += data.length();
                totalLines += 1;

                String[] words = data.split(" ");
                totalWords += words.length;

            }
            System.out.println("Total character count in the file is : " + totalCharacter);
            System.out.println("The total lines in the file is : "+ totalLines);
            System.out.println("The total words in the txt file is : "+ totalWords);


        }catch(Exception ex){
            System.out.println("File not found or mismatched issue ...");
        }

    }
}

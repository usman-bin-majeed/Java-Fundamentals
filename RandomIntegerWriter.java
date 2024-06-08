import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomIntegerWriter {

    public static void main(String[] args) {
        String fileName = "Text_IO.txt";
        int numIntegers = 100;

        // Create a Random object for generating random numbers
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(fileName, String.valueOf(true))) {
            // Loop to generate and write 100 random integers
            for (int i = 0; i < numIntegers; i++) {
                writer.print(random.nextInt() + " "); // Add space after each integer
            }
            System.out.println("Successfully wrote " + numIntegers + " random integers to " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

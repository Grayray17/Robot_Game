import java.util.*;
import java.io.*;

public class LempelZivCompress {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please call this program with one argument which is the input file name.");
        } else {
            try {
                Scanner s = new Scanner(new File(args[0]));

                // Read the entire file into one String.
                StringBuilder fileText = new StringBuilder();
                while (s.hasNextLine()) {
                    fileText.append(s.nextLine() + "\n");
                }

                System.out.println(compress(fileText.toString()));
            } catch (FileNotFoundException e) {
                System.out.println("Unable to find file called " + args[0]);
            }
        }
    }
    
    /**
     * Take uncompressed input as a text string, compress it, and return it as a
     * text string.
     */
    public static String compress(String input) {
        // TODO (currently just returns the argument).
        return input;
    }
}

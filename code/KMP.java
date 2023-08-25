import java.util.*;
import java.io.*;

public class KMP {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please call this program with " +
                    "two arguments which is the input file name " +
                    "and the string to search.");
        } else {
            try {
                Scanner s = new Scanner(new File(args[0]));

                // Read the entire file into one String.
                StringBuilder fileText = new StringBuilder();
                while (s.hasNextLine()) {
                    fileText.append(s.nextLine() + "\n");
                }

                System.out.println(search(fileText.toString(), args[1]));
            } catch (FileNotFoundException e) {
                System.out.println("Unable to find file called " + args[0]);
            }
        }
    }

    /**
     * Perform KMP substring search on the given text with the given pattern.
     * 
     * This should return the starting index of the first substring match if it
     * exists, or -1 if it doesn't.
     */
    public static int search(String text, String pattern) {
        int index = 0;
        int[] lps = new int[pattern.length()];
        createPrefixSuffixArray(pattern, lps);
        int i = 0;
        int j = 0;
        int textLength = text.length();
        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length())
                return i - j;
            else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return index;
    }

    public static void createPrefixSuffixArray(String pattern, int[] lps) {
        lps[0] = 0;
        int index = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index;
                i++;
                index++;
            } else {
                if (index != 0) {
                    index = lps[-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
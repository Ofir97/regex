import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester2 {
    public static void main(String[] args) {

        final String inputFilePath1 = "files/regex13.txt";
        final String inputFilePath2 = "files/regex14.txt";
        final String inputFilePath3 = "files/regex15.txt";
        final String inputFilePath4 = "files/regex16.txt";
        final String inputFilePath5 = "files/regex17.txt";
        final String inputFilePath6 = "files/regex18.txt";
        final String inputFilePath7 = "files/regex19.txt";
        final String inputFilePath8 = "files/regex20.txt";
        final String inputFilePath9 = "files/regex21.txt";
        final String inputFilePath10 = "files/regex22.txt";

        // -------------------------------------------------------- //

        // RegEx Patterns:
        Pattern pattern1 = Pattern.compile("^foo");
        Pattern pattern2 = Pattern.compile("bar$");
        Pattern pattern3 = Pattern.compile("^foo$");
        Pattern pattern4 = Pattern.compile("^[0-9]{3}$");
        Pattern pattern5 = Pattern.compile("^[a-z]{4,6}$");
        Pattern pattern6 = Pattern.compile("^(ha){4,}$");
        Pattern pattern7 = Pattern.compile("fooa+bar");
        Pattern pattern8 = Pattern.compile("^https?://website$");
        Pattern pattern9 = Pattern.compile("(log|ply)wood");
        Pattern pattern10 = Pattern.compile("([0-9]+)x([0-9]+)");

        printRegexFromFile(inputFilePath1, pattern1);
        printRegexFromFile(inputFilePath2, pattern2);
        printRegexFromFile(inputFilePath3, pattern3);
        printRegexFromFile(inputFilePath4, pattern4);
        printRegexFromFile(inputFilePath5, pattern5);
        printRegexFromFile(inputFilePath6, pattern6);
        printRegexFromFile(inputFilePath7, pattern7);
        printRegexFromFile(inputFilePath8, pattern8);
        printRegexFromFile(inputFilePath8, pattern8);
        printRegexFromFile(inputFilePath9, pattern9);
        printRegexFromFile(inputFilePath10, pattern10);

    }

    public static void printRegexFromFile(String inputFilePath, Pattern pattern) {
        try {
            File file = new File(inputFilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------------------");
    }

}
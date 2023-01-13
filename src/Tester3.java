import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester3 {
    public static void main(String[] args) {

        // Find and Replcae

        final String inputFilePath1 = "files/regex22.txt";
        final String inputFilePath2 = "files/regex23.txt";
        final String inputFilePath3 = "files/regex24.txt";
        final String inputFilePath4 = "files/regex25.txt";
        final String inputFilePath5 = "files/regex26.txt";
        final String inputFilePath6 = "files/regex27.txt";

        // -------------------------------------------------------- //

        // RegEx Patterns:
        Pattern pattern1 = Pattern.compile("([0-9]+)x([0-9]+)");
        Pattern pattern2 = Pattern.compile("([a-zA-Z]+)\s([a-zA-Z]+)");
        Pattern pattern3 = Pattern.compile("([0-9]{1,2}):([0-9]{2})");
        Pattern pattern4 = Pattern.compile("[0-9]{3}.[0-9]{3}.([0-9]{4})");
        Pattern pattern5 = Pattern.compile("([a-zA-Z]{3})\s([0-9]{1,2})[a-z]{2}\s[0-9]{2}([0-9]{2})");
        Pattern pattern6 = Pattern.compile("\\(([0-9]{3})\\)(.[0-9]{3}.[0-9]{4})");

        printRegexFromFile(inputFilePath1, pattern1, "$1 pix by $2 pix");
        printRegexFromFile(inputFilePath2, pattern2, "$2, $1");
        printRegexFromFile(inputFilePath3, pattern3, "$2 mins past $1");
        printRegexFromFile(inputFilePath4, pattern4, "xxx.xxx.$1");
        printRegexFromFile(inputFilePath5, pattern5, "$2-$1-$3");
        printRegexFromFile(inputFilePath6, pattern6, "$1$2");

    }

    public static void printRegexFromFile(String inputFilePath, Pattern pattern, String replacement) {
        try {
            File file = new File(inputFilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    line = matcher.replaceAll(replacement);
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
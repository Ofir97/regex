import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester1 {
    public static void main(String[] args) {

        final String inputFilePath1 = "files/regex01.txt";
        final String inputFilePath2 = "files/regex02.txt";
        final String inputFilePath3 = "files/regex03.txt";
        final String inputFilePath4 = "files/regex04.txt";
        final String inputFilePath5 = "files/regex05.txt";
        final String inputFilePath6 = "files/regex06.txt";
        final String inputFilePath7 = "files/regex07.txt";
        final String inputFilePath8 = "files/regex08.txt";
        final String inputFilePath9 = "files/regex09.txt";
        final String inputFilePath10 = "files/regex10.txt";
        final String inputFilePath11 = "files/regex11.txt";
        final String inputFilePath12 = "files/regex12.txt";

        // -------------------------------------------------------- //

        // RegEx Patterns:
        Pattern pattern1 = Pattern.compile("fooa*bar");
        Pattern pattern2 = Pattern.compile("foo.bar");
        Pattern pattern3 = Pattern.compile("foo.*bar");
        Pattern pattern4 = Pattern.compile("foo\s*bar");
        Pattern pattern5 = Pattern.compile("[fcl]oo");

        // same result
        Pattern pattern6 = Pattern.compile("[fcdplb]oo");
        Pattern pattern7 = Pattern.compile("[^mh]oo");

        Pattern pattern8 = Pattern.compile("[j-m]oo");
        Pattern pattern9 = Pattern.compile("[j-mz]oo");
        Pattern pattern10 = Pattern.compile("[j-mJ-Mz]");
        Pattern pattern11 = Pattern.compile("x*\\.y*");
        Pattern pattern12 = Pattern.compile("x[#:.]y");
        Pattern pattern13 = Pattern.compile("x[#^:]y");
        Pattern pattern14 = Pattern.compile("x[#\\\\^]y");

        printRegexFromFile(inputFilePath1, pattern1);
        printRegexFromFile(inputFilePath2, pattern2);
        printRegexFromFile(inputFilePath3, pattern3);
        printRegexFromFile(inputFilePath4, pattern4);
        printRegexFromFile(inputFilePath5, pattern5);
        printRegexFromFile(inputFilePath6, pattern6);
        printRegexFromFile(inputFilePath6, pattern7);
        printRegexFromFile(inputFilePath7, pattern8);
        printRegexFromFile(inputFilePath7, pattern9);
        printRegexFromFile(inputFilePath8, pattern10);
        printRegexFromFile(inputFilePath9, pattern11);
        printRegexFromFile(inputFilePath10, pattern12);
        printRegexFromFile(inputFilePath11, pattern13);
        printRegexFromFile(inputFilePath12, pattern14);
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
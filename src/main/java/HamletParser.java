import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
//    private Pattern pattern;
//    private Matcher matcher;

    public HamletParser() {
        this.hamletData = loadFile();

    }


    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }


    public String replaceHamletWithLeon(String input) {

        Pattern patternLowerCase = Pattern.compile("Hamlet");
        Matcher m1 = patternLowerCase.matcher(input);
        String result1 = m1.replaceAll("Leon");

        Pattern patternUpperCase = Pattern.compile("HAMLET");
        Matcher m2 = patternUpperCase.matcher(result1);
        String result2 = m2.replaceAll("LEON");

        return result2;

    }

    public String replaceHoratioWithTariq(String input) {
        Pattern patternLowerCase = Pattern.compile("Horatio");
        Matcher m1 = patternLowerCase.matcher(input);
        String result1 = m1.replaceAll("Tariq");

        Pattern patternUpperCase = Pattern.compile("HORATIO");
        Matcher m2 = patternUpperCase.matcher(result1);
        String result2 = m2.replaceAll("TARIQ");

        return result2;

    }

    public boolean findHamlet(String input)
    {
        if (input.contains("Hamlet") || input.contains("HAMLET"))
        {
            return true;
        }

        return false;
    }

    public boolean findHoratio(String input)
    {
        if (input.contains("Horatio") || input.contains("HORATIO"))
        {
            return true;
        }

        return false;

    }

    public String getHamletData()
    {
        return hamletData;
    }





}

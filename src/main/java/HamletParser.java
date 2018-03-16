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

    public String getHamletData() {
        return hamletData;
    }

    public String changeHamletToLeon(String input) {
        Pattern smallCase = Pattern.compile("Hamlet");
        Matcher m1 = smallCase.matcher(input);
        String result1 = m1.replaceAll("Leon");

        Pattern upperCase = Pattern.compile("HAMLET");
        Matcher m2 = upperCase.matcher(result1);
        String result2 = m2.replaceAll("LEON");
        return result2;
    }

    public String changeHoratioToTariq(String input) {
        Pattern smallCase = Pattern.compile("Horatio");
        Matcher m1 = smallCase.matcher(input);
        String result1 = m1.replaceAll("Tariq");

        Pattern upperCase = Pattern.compile("HORATIO");
        Matcher m2 = upperCase.matcher(result1);
        String result2 = m2.replaceAll("TARIQ");
        return result2;
    }

    public boolean findHamlet(String input) {
        if (hamletData.contains("HAMLET") || hamletData.contains("Hamlet")) {
        }
        return true;
    }

    public boolean findHoratio(String input) {
        if (hamletData.contains("HORATIO") || hamletData.contains("Horatio")) {
        }
        return true;
    }
}
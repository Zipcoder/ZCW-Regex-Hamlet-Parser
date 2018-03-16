
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    String hamletPattern = "[Hh][Aa][Mm][Ll][Ee][Tt]";
    Pattern hamletC = Pattern.compile(hamletPattern);


    String horatioPattern = "[Hh][Oo][Rr][Aa][Tt][Ii][Oo]";
    Pattern horatioC = Pattern.compile(horatioPattern);


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
        Matcher hamletMatcher = hamletC.matcher(input);
        return hamletMatcher.replaceAll("Leon");
    }

    public String changeHoratioToTariq(String input) {
        Matcher horatioMatcher = horatioC.matcher(input);
        return horatioMatcher.replaceAll("Tariq");
    }


}

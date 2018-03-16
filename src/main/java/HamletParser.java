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
    private int count = 0;


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

    public String changeHamletToLeon(String text) {

        Pattern replacement = Pattern.compile("Hamlet");
        Matcher match = replacement.matcher(text);
        String hamletData1 = match.replaceAll("Leon");

        Pattern replacement1 = Pattern.compile("HAMLET");
        Matcher match1 = replacement1.matcher(hamletData1);
        String hamletData2 = match1.replaceAll("LEON");

        return hamletData2;
    }

    public String changeHoratioToTariq(String text) {

        Pattern replacement = Pattern.compile("Horatio");
        Matcher match = replacement.matcher(text);
        String hamletData1 = match.replaceAll("Tariq");

        Pattern replacement1 = Pattern.compile("HORATIO");
        Matcher match1 = replacement1.matcher(hamletData1);
        String hamletData2 = match1.replaceAll("TARIQ");

        return hamletData2;
    }


    private int findMatch(String regexSearch, String text) {
        Pattern checkName = Pattern.compile(regexSearch);
        Matcher regexCheck = checkName.matcher(text);

        while (regexCheck.find()) {
            if (regexCheck.group().length() != 0) {
                count++;
            }
        }
        return count;

    }
    public int findHoratio() {

        return findMatch("[H|h|][O|o][R|r][A|a][T|t][I|i][O|o]", hamletData);

    }

    public int findHamlet() {

      return findMatch("[H|h|][A|a][M|m][L|l][E|e][T|t]", hamletData);
    }
}

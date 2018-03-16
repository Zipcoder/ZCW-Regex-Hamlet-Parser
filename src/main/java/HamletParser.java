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
    private Pattern pattern;
    private Matcher matcher;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    public void changeHamletToLeon() {
        String hamlet = "(Hamlet|HAMLET)";
        this.hamletData = change(hamlet, "LEON");
    }

    public void changeHoratioToTariq() {
        String horatio = "(Horatio|HORATIO)";
        this.hamletData = change(horatio, "TARIQ");
    }

    public boolean findHoratio() {
        String horatio = "(Horatio|HORATIO)";
        return find(horatio);
    }

    public boolean findHamlet() {
        String hamlet = "(Hamlet|HAMLET)";
        return find(hamlet);
    }

    private boolean find(String aString) {
        pattern = Pattern.compile(aString);
        matcher = pattern.matcher(hamletData);
        return matcher.find();
    }

    private String change(String original, String convertTo) {
        pattern = Pattern.compile(original);
        matcher = pattern.matcher(hamletData);
        return matcher.replaceAll(convertTo);
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

}

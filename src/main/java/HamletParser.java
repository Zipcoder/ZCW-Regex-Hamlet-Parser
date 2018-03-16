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
    private Pattern thePattern;
    private Matcher m;
    private String s;

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

    //Testing
    public String changeHamletToLeon(String name) {
        s = null;
        if (findHamlet(name)) {
            s = m.replaceAll("Leon");
        }
        return s;
    }

    public String changeHamletToLeon() {
        s = null;
        if (find("Hamlet")) {
            s = m.replaceAll("Leon");
        }
        return s;
    }


    public String changeHoratioToTariq(String name) {
        s = null;
        if (findHoratio(name)) {
            s = m.replaceAll("Tariq");
        }
        return s;
    }


    public boolean findHamlet(String name) {
        thePattern = Pattern.compile("Hamlet");
         m = thePattern.matcher((name));
        return m.find();
    }

    public boolean findHoratio(String name) {
        thePattern = Pattern.compile(("Horatio"));
        m = thePattern.matcher((name));
        return m.find();
    }

    public boolean find(String name) {
        thePattern = Pattern.compile((name));
        m = thePattern.matcher(getHamletData());
        return m.find();
    }


}










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

    public String changeHamletToLeon(String hamletData) {
        String input = hamletData;
        Pattern p = Pattern.compile("Hamlet");
        Matcher m = p.matcher(input);
        String hamletToLeon = m.replaceAll("Leon");
        Pattern upperP = Pattern.compile("HAMLET");
        Matcher upperM = upperP.matcher(hamletToLeon);
        String hamletToLeonUpper = upperM.replaceAll("LEON");

        return hamletToLeonUpper.toString();
    }

    public String changeHoratioToTariq(String hamletData) {
        String input = hamletData;
        Pattern p = Pattern.compile("Horatio");
        Matcher m = p.matcher(input);
        String horatioToTariq = m.replaceAll("Tariq");
        Pattern upperP = Pattern.compile("HORATIO");
        Matcher upperM = upperP.matcher(horatioToTariq);
        String horatioToTariqUpper = upperM.replaceAll("TARIQ");

        return horatioToTariqUpper.toString();
    }

    public String changeAll(String hamletData) {
        String changeAll = changeHoratioToTariq(changeHamletToLeon(hamletData));


        return changeAll;
    }


    public Integer findHalmet(String hamletData) {
        String input = hamletData;
        Pattern p = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        int count = 0;
        while (m.find())
            count++;
        return count;
    }

    public Integer findHoratio(String hamletData) {
        String input = hamletData;
        Pattern p = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        int count = 0;
        while (m.find())
            count++;
        return count;
    }

}

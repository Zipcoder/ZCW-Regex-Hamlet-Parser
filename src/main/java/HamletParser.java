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


    public void changeIfHamlet() {
        Pattern p = Pattern.compile("(Hamlet| HAMLET).*");
        Matcher m = p.matcher(hamletData);
        if (m.find()) {
            hamletData = m.replaceAll("Leon");
        } else if (m.find()){
            hamletData = m.replaceAll("LEON");
        }
        }

    public void changeIfHoratio(){
        Pattern p = Pattern.compile("(Horatio | HORATIO).*");
        Matcher m = p.matcher(hamletData);
        if (m.find()){
            hamletData = m.replaceAll("Tariq");
        } else if (m.find()) {
            hamletData = m.replaceAll("TARIQ");
        }
    }
    public boolean findHamlet(){
        Pattern p = Pattern.compile("(Hamlet| HAMLET).*");
        Matcher m = p.matcher(hamletData);
        return m.find();
    }
    public boolean findHoratio(){
        Pattern p = Pattern.compile("(Horatio | HORATIO).*");
        Matcher m = p.matcher(hamletData);
        return m.find();
    }
}


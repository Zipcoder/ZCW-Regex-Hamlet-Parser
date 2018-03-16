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


    private Pattern horatioP = Pattern.compile("(\\bHoratio\\b|\\bHORATIO\\b)");


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

    public void changeHoratioToTariq() {
        Pattern horatioL = Pattern.compile("Horatio");
        Matcher tariqL = horatioL.matcher(hamletData);
        hamletData = tariqL.replaceAll("Tariq");
        Pattern horatioU = Pattern.compile("\\bHORATIO\\b");
        Matcher tariqU = horatioU.matcher(hamletData);
        hamletData = tariqU.replaceAll("TARIQ");
    }

    public void changeHamletToLeon() {
        Pattern hamletL = Pattern.compile("Hamlet");
        Matcher leonL = hamletL.matcher(hamletData);
        hamletData = leonL.replaceAll("Leon");
        Pattern hamletU = Pattern.compile("\\bHAMLET\\b");
        Matcher leonU = hamletU.matcher(hamletData);
        hamletData = leonU.replaceAll("LEON");
    }

    public void replaceBothNames(){
        changeHamletToLeon();
        changeHoratioToTariq();
    }

    public boolean contains(String wordToLookOutFor){
        String[] hamletArray = getHamletData().split(" ");
        for(String word : hamletArray){
            if(word.equals(wordToLookOutFor)){
                return true;
            }
        }
        return false;
    }

}

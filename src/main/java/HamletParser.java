import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private String[] words;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    // My constructor
    public HamletParser(String input) {
        this.hamletData = input;
        this.words = input.split("\\W");
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon() {
        String HamletString = "Hamlet";
        String LeonString = "Leon";

        Pattern HamletPattern = Pattern.compile(HamletString);
        Matcher HamletMatcher = HamletPattern.matcher(hamletData);
        hamletData = HamletMatcher.replaceAll(LeonString);
    }

    public static void main(String[] args) {
        String inputString = "Change hamleta;ldsfjkhamletHamlet and Hamlet and also Hamlet to Leon";
        HamletParser hamletParser = new HamletParser(inputString);
        System.out.println(hamletParser.getHamletData());
        hamletParser.changeHamletToLeon();
        System.out.println(hamletParser.getHamletData());
    }

}

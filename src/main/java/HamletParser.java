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


    Pattern hamletLowerPattern = Pattern.compile("Hamlet");
    Pattern horatioLowerPattern = Pattern.compile("Horatio");

    Pattern hamletUpperPattern = Pattern.compile("HAMLET");
    Pattern horatioUpperPattern = Pattern.compile("HORATIO");

    Matcher hamletLowerMatcher = hamletLowerPattern.matcher(hamletData);
    Matcher horatioLowerMatcher = horatioLowerPattern.matcher(hamletData);

    Matcher hamletUpperMatcher = hamletUpperPattern.matcher(hamletData);
    Matcher horatioUpperMatcher = horatioUpperPattern.matcher(hamletData);


    public HamletParser(){

        this.hamletData = loadFile();
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
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){

        return hamletData;
    }

    public void changeHamletToLeon(String string) {

        hamletData = hamletLowerMatcher.replaceAll("Leon");
        hamletData = hamletUpperMatcher.replaceAll("LEON");
    }

    public void changeHoratioToTariq(String string) {
        hamletData = horatioLowerMatcher.replaceAll("Tariq");
        hamletData = horatioUpperMatcher.replaceAll("TARIQ");
    }

    public boolean findMatch(String regExS, String hamletData) {
        return false;
    }



}

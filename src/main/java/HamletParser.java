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

    public String changeText(String string){
        changeHamletToLeon(string);
        changeHoratioToTariq(string);
        return string;
    }

    public String changeHamletToLeon(String string) {

        Pattern hamletLowerPattern = Pattern.compile("Hamlet");
        Matcher hamletLowerMatcher = hamletLowerPattern.matcher(string);
        String string1 = hamletLowerMatcher.replaceAll("Leon");

        Pattern hamletUpperPattern = Pattern.compile("HAMLET");
        Matcher hamletUpperMatcher = hamletUpperPattern.matcher(string1);
        String string2 = hamletUpperMatcher.replaceAll("LEON");
        return string2;
    }

    public String changeHoratioToTariq(String string) {


        Pattern horatioLowerPattern = Pattern.compile("Horatio");
        Matcher horatioLowerMatcher = horatioLowerPattern.matcher(string);
        String string1 = horatioLowerMatcher.replaceAll("Tariq");

        Pattern horatioUpperPattern = Pattern.compile("HORATIO");
        Matcher horatioUpperMatcher = horatioUpperPattern.matcher(string1);
        String string2 = horatioUpperMatcher.replaceAll("TARIQ");
        return string2;
    }



    public boolean findMatch(String regEx, String hamletData) {

        if (hamletData.contains(regEx)) return false;

        else { return true; }

    }



}

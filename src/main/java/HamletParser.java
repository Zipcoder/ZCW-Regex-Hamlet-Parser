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
    public int counter = 0;


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


    public String changeHamletToLeon(String text) {
        Pattern replace = Pattern.compile("Hamlet");
        Matcher regexMatcher = replace.matcher(text);
        String joe = regexMatcher.replaceAll("Leon");

        Pattern replace1 = Pattern.compile("HAMLET");
        Matcher regexMatcher1 = replace1.matcher(joe);
        String garrett = regexMatcher1.replaceAll("LEON");

        return garrett;
    }


    public String changeHoratioToTariq(String text) {

        Pattern replace = Pattern.compile("Horatio");
        Matcher regexMatcher = replace.matcher(text);
        String joe = regexMatcher.replaceAll("Tariq");

        Pattern replace1 = Pattern.compile("HORATIO");
        Matcher regexMatcher1 = replace1.matcher(joe);
        String joe1 = regexMatcher1.replaceAll("TARIQ");


        return joe1;

    }

    public String changeAll(String text){
       return changeHamletToLeon(changeHoratioToTariq(text));

    }


    public int findHoratio() {
        return findMatch("[Hh][Oo][Rr][Aa][Tt][Ii][Oo]",hamletData);
        }


    public int findHamlet () {
        return findMatch("[Hh][Aa][Mm][Ll][Ee][Tt]", hamletData);

    }

    public int findMatch(String regexStatement, String text) {
        Pattern checkRegex = Pattern.compile(regexStatement);
        Matcher regexMatcher = checkRegex.matcher(text);

        while (regexMatcher.find()) {
            counter++;
        }
        return counter;

    }
}







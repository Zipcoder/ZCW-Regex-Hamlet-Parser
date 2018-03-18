import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

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

    public String changeHamletToLeon(String string) {
        Pattern lowerCase = Pattern.compile("Hamlet");
        Matcher match1 = lowerCase.matcher(string);
        String result1 = match1.replaceAll("Leon");

        Pattern upperCase = Pattern.compile("HAMLET");
        Matcher match2 = upperCase.matcher(result1);
        String result2 = match2.replaceAll("LEON");

        return result2;
    }

    public String changeHoratioToTariq(String string) {
        Pattern lowerCase = Pattern.compile("Horatio");
        Matcher match1 = lowerCase.matcher(string);
        String result1 = match1.replaceAll("Tariq");

        Pattern upperCase = Pattern.compile("HORATIO");
        Matcher match2 = upperCase.matcher(result1);
        String result2 = match2.replaceAll("TARIQ");

        return result2;
    }

    public boolean findHamlet(String input){
        if ( hamletData.contains("Hamlet") || hamletData.contains("HAMLET")) {
        }
        return true;
    }

    public boolean findHoratio(String input){
        if ( hamletData.contains("Horatio") || hamletData.contains("HORATIO")) {
        }
        return true;
    }

}
/*
REGEX

Directions

Make a project that will go through the hamlet file provided and
using regex replace every instance of "Hamlet" with "Leon" and every instance of Horatio with "Tariq".

Beginning with tests, you are to program all the steps it will take to complete that process.
Some tests have been stubbed out for you but
these will not cover all the methods you should have in your project.

IMPORTANT: You are not to use String Utilities to simply replace words. You must use Pattern and Matcher.
 */

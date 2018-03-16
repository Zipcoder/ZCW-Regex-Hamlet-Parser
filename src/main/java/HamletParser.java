import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @TODO
 * @1. Go through the hamlet file , use Regular expressions (Regex)
 * Replace all instances of the string "Hamlet" with "Leon"
 * Replace all instances of the string "Horatio" with "Tariq"
 * Breakdown all the logic to complete this process
 * Must use Pattern && Matcher to replace the words ^Hint: replaceAll();^
 */
//     LOGIC
// ==============
// Iterate through the file
// Use regular expressions/ Pattern & Matcher to target specific strings or matches of characters
// in this case "Hamlet" & "Horatio"
// After I've locked on to all targeted strings/characters then replace them,
// Maybe replace them using the replaceAll(); function
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

    public String nameSwapper(String match, String newMatch, String nameInput){
        Pattern namePattern = Pattern.compile(match); //instance class of pattern compressed version of Regex
        Matcher nameMatch = namePattern.matcher(nameInput); //use my pattern object to make an instance of matcher, which will then parse my nameinput
        return nameMatch.replaceAll(newMatch);
    }

    public String getHamletData(){
        return hamletData;
    }

}
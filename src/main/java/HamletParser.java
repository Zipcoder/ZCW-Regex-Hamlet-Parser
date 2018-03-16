import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

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

    public void fileChanger(){
        hamletChanger();
        horatioChanger();
    }

    private void hamletChanger(){
        Pattern hamletPatternLowerCase = Pattern.compile("Hamlet");
        Matcher hamletMatcherLowerCase = hamletPatternLowerCase.matcher(hamletData);
        hamletData = hamletMatcherLowerCase.replaceAll("Leon");
        Pattern hamletPatternUpperCase = Pattern.compile("HAMLET");
        Matcher hamletMatcherUpperCase = hamletPatternUpperCase.matcher(hamletData);
        hamletData = hamletMatcherUpperCase.replaceAll("LEON");
    }

    private void horatioChanger(){
        Pattern horatioPatterLowerCase = Pattern.compile("Horatio");
        Matcher horatioMatcherLowerCase = horatioPatterLowerCase.matcher(hamletData);
        hamletData = horatioMatcherLowerCase.replaceAll("Tariq");
        Pattern horatioPatterUpperCase = Pattern.compile("HORATIO");
        Matcher horatioMatcherUpperCase = horatioPatterUpperCase.matcher(hamletData);
        hamletData = horatioMatcherUpperCase.replaceAll("TARIQ");
    }

    public String getHamletData(){
        return hamletData;
    }

}

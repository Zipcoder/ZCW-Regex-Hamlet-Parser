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
    private Pattern hamlet = Pattern.compile("(Hamlet)");
    private Pattern HAMLET = Pattern.compile("(HAMLET)");
    private Pattern horatio = Pattern.compile("(Horatio)");
    private Pattern HORATIO = Pattern.compile("(HORATIO)");

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

    public String replaceHoratioAndHamlet(String text){
        String output;
        output = replaceHamlet(text);
        output = replaceHAMLET(output);
        output = replaceHoratio(output);
        output = replaceHORATIO(output);
        return output;
    }

    public String replaceHamlet(String text){

        Matcher m = hamlet.matcher(text);
        return m.replaceAll("Leon");
    }
    public String replaceHAMLET(String text){

        Matcher m = HAMLET.matcher(text);
        return m.replaceAll("LEON");
    }

    public String replaceHoratio(String text){

        Matcher m = horatio.matcher(text);
        return m.replaceAll("Tariq");
    }

    public String replaceHORATIO(String text){

        Matcher m = HORATIO.matcher(text);
        return m.replaceAll("TARIQ");
    }

    public boolean findHoratio (String text){
        Matcher m = horatio.matcher(text);
        return m.find();
    }
    public boolean findHORATIO (String text){
        Matcher m = HORATIO.matcher(text);
        return m.find();
    }

    public boolean findHamlet (String text){
        Matcher m = hamlet.matcher(text);
        return m.find();
    }
    public boolean findHAMLET (String text){
        Matcher m = HAMLET.matcher(text);
        return m.find();
    }

}

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

    public void horatioToTariq(){
        Pattern pattern = Pattern.compile("(H)(oratio|ORATIO)");
        Matcher matcher = pattern.matcher(this.hamletData);
        hamletData = matcher.replaceAll("Tariq");
        }
    public void hamletToLeon(){
        Pattern pattern = Pattern.compile("(H)(amlet|AMLET)");
        Matcher matcher = pattern.matcher(this.hamletData);
        hamletData = matcher.replaceAll("Leon");
        }

    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        hamletParser.hamletToLeon();
        hamletParser.horatioToTariq();
        System.out.println(hamletParser.getHamletData());
    }
}

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
    private Pattern hamletPattern;
    private Pattern horatioPattern;
    private Matcher matcher;

    public HamletParser(){
        this.hamletData = loadFile();
        hamletPattern = Pattern.compile("(Hamlet|hamlet|HAMLET)");
        horatioPattern = Pattern.compile("(Horatio|horatio|HORATIO)");
    }

    public void changeHamletToLeon() {
        matcher = hamletPattern.matcher(hamletData);
        this.hamletData = matcher.replaceAll("LEON");
    }

    public void changeHoratioToTariq() {
        matcher = horatioPattern.matcher(hamletData);
        this.hamletData = matcher.replaceAll("TARIQ");
    }

    public boolean findHoratio() {
        matcher = horatioPattern.matcher(hamletData);
        return matcher.find();

    }

    public boolean findHamlet() {
        matcher = hamletPattern.matcher(hamletData);
        return matcher.find();

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

}

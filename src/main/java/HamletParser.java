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

    public String getHamletData(){
        return hamletData;
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

    public String changeHamletToLeon(){
        Pattern pattern1 = Pattern.compile("Hamlet");
        Matcher matcher1 = pattern1.matcher(loadFile());
        String leon = matcher1.replaceAll("Leon");
        matcher1.reset(leon);
        matcher1.usePattern(Pattern.compile("Horatio"));
        return matcher1.replaceAll("Tariq");
    }

    //alternative method
    public String changeName(String hamletName, String zcwName){
        Pattern pattern = Pattern.compile(hamletName);
        Matcher matcher = pattern.matcher(loadFile());
        return matcher.replaceAll(zcwName);
    }



}

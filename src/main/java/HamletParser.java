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

    public HamletParser(String sentence){
        this.hamletData = sentence;
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

    public String changeHamletToLeon(String sentence){

        Pattern pattern = Pattern.compile("(h|H)amlet");

        String str = sentence;

        Matcher m = pattern.matcher(str);

        String str2 = m.replaceAll("Leon");

        System.out.println(str2);









        return str2;
    }

}

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

    public String replaceHamletWithLeon()
    {
//        HamletParser hamletParser = new HamletParser();
//        String input = hamletData;
//
//        Pattern p1 = Pattern.compile("\\bHamlet\\b");
//        Matcher m1 = p1.matcher(input);
//        String replaceHamletWithLeon = m1.replaceAll("Leon");
//
//
//        String capitalInput = hamletData;
//        Pattern p2 = Pattern.compile("\\bHAMLET\\b");
//        Matcher m2 = p2.matcher(capitalInput);
//        String replaceHamletWithLeonCapital = m2.replaceAll("LEON");
//
//        return hamletData;
    }

    public String replaceHiratioWithTariq()
    {
//        HamletParser hamletParser = new HamletParser();
//        String input = hamletData;
//
//        Pattern p3 = Pattern.compile("\\bHiratio\\b");
//        Matcher m3 = p3.matcher(input);
//        String replaceHamletWithLeon = m3.replaceAll("Tariq");
//
//
//        String capitalInput = hamletData;
//        Pattern p4 = Pattern.compile("\\bHIRATIO\\b");
//        Matcher m4 = p4.matcher(capitalInput);
//        String replaceHamletWithLeonCapital = m4.replaceAll("TARIQ");
//
//        return hamletData;
    }

    public String getHamletData()
    {


        return hamletData;
    }

}

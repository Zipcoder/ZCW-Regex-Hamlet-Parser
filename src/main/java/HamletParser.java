import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private HamletParser hamletParser;
    private String hamletData;
    private String inputText;

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

    public boolean findHoratio(String inputText){
        if (inputText.contains("HORATIO") || inputText.contains("Horatio"));
        return true;
    }

    public boolean findHamlet(String inputText){
        if (inputText.contains("HAMLET") || inputText.contains("Hamlet"));
        return true;
    }

    public String changeHoratioToTariq(String inputText){

        String str = inputText;
        Pattern p = Pattern.compile("\\bHoratio\\b");
        Matcher m = p.matcher(str);
        String capital = m.replaceAll("Tariq");

        String lower = capital;
        Pattern p2 = Pattern.compile("\\bHORATIO\\b");
        Matcher m2 = p2.matcher(lower);
        String result = m2.replaceAll("TARIQ");
        return result;
    }

    public String changeHamletToLeon(String inputText){

        String str = inputText;
        Pattern p = Pattern.compile("\\bHamlet\\b");
        Matcher m = p.matcher(str);
        String capital = m.replaceAll("Leon");

        String lower = capital;
        Pattern p2 = Pattern.compile("\\bHAMLET\\b");
        Matcher m2 = p2.matcher(lower);
        String result = m2.replaceAll("LEON");
        return result;
    }

    public String changeBothNames(String inputText){
        String str = inputText;
        Pattern p = Pattern.compile("\\bHoratio\\b");
        Matcher m = p.matcher(str);
        String capital = m.replaceAll("Tariq");

        String lower = capital;
        Pattern p2 = Pattern.compile("\\bHORATIO\\b");
        Matcher m2 = p2.matcher(lower);
        String resultOne = m2.replaceAll("TARIQ");

        String hamBoy = resultOne;
        Pattern p3 = Pattern.compile("\\bHamlet\\b");
        Matcher m3 = p3.matcher(hamBoy);
        String ham1 = m3.replaceAll("Leon");

        String ham2 = ham1;
        Pattern p4 = Pattern.compile("\\bHAMLET\\b");
        Matcher m4 = p4.matcher(ham2);
        String result = m4.replaceAll("LEON");
        return result;

    }

    public String getHamletData(){
        return hamletData;
    }


    }
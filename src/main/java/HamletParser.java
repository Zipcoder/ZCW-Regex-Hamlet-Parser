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
    private String hamlet = "\\bHamlet\\b";
    private String horatio = "\\bHoratio\\b";
    private String leon = "Leon";
    private String tariq = "Tariq";

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

    public boolean findLeon(){
        if (getHamletData().contains(leon)){
            return true;
        }
        return false;
    }
    public boolean findTariq(){
        if (getHamletData().contains(tariq)) {
            return true;
        }
        return false;
        }
    public boolean findHamlet(){
        if (getHamletData().contains("HAMLET")){
            return true;
        }
        return false;
    }

    public boolean findHoratio(){
        if (getHamletData().contains("HORATIO")) {
            return true;
        }
        return false;
    }

    public void changeHamletToLeon(){
        Pattern hamleon = Pattern.compile(hamlet, Pattern.CASE_INSENSITIVE);
        Matcher matcher = hamleon.matcher(hamletData);
        while (matcher.find()){
            this.hamletData = matcher.replaceAll("Leon");
        }

    }
    public void changeHoratioToTariq(){
        Pattern horatariq = Pattern.compile(horatio, Pattern.CASE_INSENSITIVE);
        Matcher matcher = horatariq.matcher(hamletData);
        while (matcher.find()){
            this.hamletData = matcher.replaceAll("Tariq");
        }
    }

}

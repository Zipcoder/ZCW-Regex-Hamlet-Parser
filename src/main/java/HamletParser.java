import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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

    public boolean checkHamlet(){
        if (getHamletData().contains("HAMLET")) return true;
        return false;
    }

    public boolean checkLeon(){
        if (getHamletData().contains("LEON")) return true;
        return false;
    }

    public boolean checkHoratio(){
        if (getHamletData().contains("HORATIO")) return true;
        return false;
    }

    public boolean checkTariq(){
        if (getHamletData().contains("TARIQ")) return true;
        return false;
    }

    public void changeHamletToLeon(){
        Pattern hamlet = Pattern.compile("(HAMLET)");
        this.hamletData = hamlet.matcher(hamletData).replaceAll("LEON");
    }

    public void changeHoratioToTariq(){
        Pattern hamlet = Pattern.compile("(HORATIO)");
        this.hamletData = hamlet.matcher(hamletData).replaceAll("TARIQ");
    }
}

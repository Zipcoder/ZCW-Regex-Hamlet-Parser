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
        if (getHamletData().contains("HAMLET")||getHamletData().contains("Hamlet")) return true;
        return false;
    }

    public boolean checkLeon(){
        if (getHamletData().contains("LEON")||getHamletData().contains("Leon")) return true;
        return false;
    }

    public boolean checkHoratio(){
        if (getHamletData().contains("HORATIO")||getHamletData().contains("Horatio")) return true;
        return false;
    }

    public boolean checkTariq(){
        if (getHamletData().contains("TARIQ")||getHamletData().contains("Tariq")) return true;
        return false;
    }

    public void changeHamletToLeon(){
        Pattern hamlet = Pattern.compile("(HAMLET)");
        this.hamletData = hamlet.matcher(hamletData).replaceAll("LEON");
        Pattern hamletlowercase = Pattern.compile("(Hamlet)");
        this.hamletData = hamletlowercase.matcher(hamletData).replaceAll("Leon");
    }

    public void changeHoratioToTariq(){
        Pattern horatio = Pattern.compile("(HORATIO)");
        this.hamletData = horatio.matcher(hamletData).replaceAll("TARIQ");
        Pattern horatiolowercase = Pattern.compile("(Horatio)");
        this.hamletData = horatiolowercase.matcher(hamletData).replaceAll("Tariq");
    }
}

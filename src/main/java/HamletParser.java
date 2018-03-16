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
    private Pattern pattern;
    private Matcher matcher;

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


    public void changeHoratioToTariq(){

        String horatio = "(Horatio|HORATIO)";

        pattern = Pattern.compile(horatio);

        matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Tariq");

    }


    public void changeHamletToLeon() {
        String hamlet = "(Hamlet| HAMLET)";

        pattern = Pattern.compile(hamlet);
        matcher = pattern.matcher(hamletData);

        hamletData = matcher.replaceAll("Leon");

    }
        public String printOut(){
        System.out.println(this.hamletData);
        return this.hamletData;
    }


    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        hamletParser.changeHamletToLeon();
        hamletParser.printOut();
    }

    public boolean findHoratio() {
        String horatio = "(Horatio|HORATIO)";

        pattern = Pattern.compile(horatio);

        matcher = pattern.matcher(hamletData);

        if(hamletData.contains("(Horatio|HORATIO)")){
            return true;
        }
        return false;

    }


    public boolean findHamlet() {
        String hamlet = "(Hamlet| HAMLET)";

        pattern = Pattern.compile(hamlet);
        matcher = pattern.matcher(hamletData);

        if (hamletData.contains("(Hamlet| HAMLET)")) {
            return true;
        }
        return false;

    }

}

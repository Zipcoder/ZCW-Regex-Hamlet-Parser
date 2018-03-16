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

    protected String replaceAllWith(String replace, String in, String with) {

        Pattern pattern = Pattern.compile(replace, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(in);

        return matcher.replaceAll(with);
    }

    protected String replaceAllHamletWithLeon() {
        return replaceAllHamletWithLeon(hamletData);
    }

    protected String replaceAllHamletWithLeon(String input) {
        return replaceAllWith("Hamlet", input, "Leon");
    }

    protected String replaceAllHoratioWithTariq() {
        return replaceAllHoratioWithTariq(hamletData);
    }

    protected String replaceAllHoratioWithTariq(String input) {
        return replaceAllWith("Horatio", input, "Tariq");
    }

    protected String replaceBoth() {
        return replaceAllHamletWithLeon(replaceAllHoratioWithTariq());
    }
}

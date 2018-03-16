import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private static String hamletData;

    HamletParser(){
        hamletData = loadFile();
    }

    public String loadFile(){
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

    public static String changeHamletToLeon(String string) {
        StringBuffer sb = new StringBuffer();
        String hamletPattern = "([Hh][Aa][Mm][Ll][Ee][Tt])";
        Pattern pattern = Pattern.compile(hamletPattern);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matcher.appendReplacement(sb, "Leon");
        }
        return matcher.appendTail(sb).toString();
    }

    public static String changeHoratioToTariq(String string) {
        StringBuffer sb = new StringBuffer();
        String horatioPattern = "([Hh][Oo][Rr][Aa][Tt][Ii][Oo])";
        Pattern pattern = Pattern.compile(horatioPattern);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matcher.appendReplacement(sb, "Tariq");
        }
        return matcher.appendTail(sb).toString();
    }

    private void changeEverythingAndPutInFile() throws IOException {
        String fixedFile = changeHamletToLeon(changeHoratioToTariq(hamletData));
        FileWriter fileWriter = new FileWriter("src/main/resources/zipcodeHamlet.txt", true);
        fileWriter.write(fixedFile);
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        HamletParser h = new HamletParser();
        h.changeEverythingAndPutInFile();
    }

}

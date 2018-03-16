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
    private int counter = 0;

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

    public boolean findHoratio(){
        return findMatch("[Hh][Oo][Rr][Aa][Tt][Ii][Oo]", hamletData);
    }


    public boolean findHamlet(){
        return findMatch("[Hh][Aa][Mm][Ll][Ee][Tt]", hamletData);
    }

    public String changeHamletToLeon(String stringBook){

        Pattern patternReplace = Pattern.compile("[Hh][a][m][l][e][t]");
        Matcher matcher = patternReplace.matcher(stringBook);
        String finalReplace = matcher.replaceAll("Leon");

        Pattern patternReplaceCaps = Pattern.compile("HAMLET");
        Matcher matcherCaps = patternReplaceCaps.matcher(finalReplace);
        String finalReplaceCaps = matcherCaps.replaceAll("LEON");

        return finalReplaceCaps;

    }

    public String changeHoratioToTariq(String stringBook){

        Pattern patternReplace = Pattern.compile("[Hh][o][r][a][t][i][o]");
        Matcher matcher = patternReplace.matcher(stringBook);
        String finalReplace = matcher.replaceAll("Tariq");

        Pattern patternReplaceCaps = Pattern.compile("HORATIO");
        Matcher matcherCaps = patternReplaceCaps.matcher(finalReplace);
        String finalReplaceCaps = matcherCaps.replaceAll("TARIQ");

        return finalReplaceCaps;
    }

    public int getCounterTimeSeen(){
        return counter;
    }


    public boolean findMatch(String regexSearch, String hamletData){

        Pattern checkRegex = Pattern.compile(regexSearch);

        Matcher regexMatcher = checkRegex.matcher(hamletData);

        boolean findMatch = false;

        while(regexMatcher.find()){
            findMatch = true;
            counter++;
        }

        return findMatch;
    }

}

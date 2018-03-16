import jdk.nashorn.internal.runtime.regexp.RegExp;

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
    private String hamletDataTemp = hamletData;

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

    public boolean findHoratio(String hamletDataTemp){
        return hamletDataTemp.contains("Horatio");


//        int hamletCount =regexChecker("[Hh][Oo][Ra][Aa][Tt][Ii][Oo]",hamletDataTemp);
//
//        if(hamletCount>0){
//            return true;
//        }
//        return false;
    }
    public boolean findHamlet(String hamletDataTemp){
      return hamletDataTemp.contains("Horatio");
    }
    public String changeHoratioToTariq(String hamletDataTemp){

        Pattern replaceHoratio1 = Pattern.compile("[H|h][O|o][R|r][A|a][T|t][I|i][O|o]");
        Matcher regexMatcher1 = replaceHoratio1.matcher(hamletDataTemp);
        String replaced1 = regexMatcher1.replaceAll("Tariq");

        return replaced1;
    }

    public String changeHamletToLeon(String hamletDataTemp){


        Pattern replaceHamlet1 = Pattern.compile("[H|h][A|a][M|m][L|l][E|e][T|t]");
        Matcher regexMatcher1 = replaceHamlet1.matcher(hamletDataTemp);
        String replaced1 = regexMatcher1.replaceAll("Leon");

        return replaced1;
    }

    public int regexChecker(String input, String hamletDataTemp){

        Pattern checkRegex = Pattern.compile(input);
        Matcher regexMatcher = checkRegex.matcher(hamletDataTemp);

        int count = 0;
        while(regexMatcher.find()){
            count++;
            }
            return count;
        }


}

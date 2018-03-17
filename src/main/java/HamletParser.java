

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String[] words;
    private String hamletData;

    public HamletParser(){

        this.hamletData = loadFile();
    }

    public HamletParser(String input){
        this.hamletData = input;
        this.words = input.split("\\W");
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

    //I know I need pattern and I know I need matching
//    public static void changeHamletToLeon(String hamlet, String file2Check){
//
//        Pattern checkHamletRegex = Pattern.compile(hamlet);
//        Matcher regexMatcher = checkHamletRegex.matcher(file2Check);
//
//        while(regexMatcher.find()){
//            if(regexMatcher.group().length()!=0){
//
//            }
//        }
//    }


    public String getHamletData(){

        return hamletData;
    }


    public void changeHamletToLeon(){
        String hamletText = "Hamlet";
        String leonText = "Leon";

        Pattern checkRegex = Pattern.compile(hamletText);
        Matcher m = checkRegex.matcher(hamletData);

        hamletData = m.replaceAll(leonText);
    }

    public void changeHoratioToTariq(){
        String horatioText = "Horatio";
        String tariqText = "Tariq";

        Pattern checkRegex = Pattern.compile(horatioText);
        Matcher m = checkRegex.matcher(hamletData);

        hamletData = m.replaceAll(tariqText);
    }

    public boolean findHamlet(){
        boolean findHamlet = false;

        String hamletString = "Hamlet";

        Pattern checkHamletRegex = Pattern.compile(hamletString);
        Matcher regexHamletMatcher = checkHamletRegex.matcher(hamletData);

        if(regexHamletMatcher.find()){
            findHamlet = true;
        }

        return findHamlet;
    }

    public boolean findHoratio(){
        boolean findHoratio = false;

        String horatioString = "Horatio";

        Pattern checkHoratioRegex = Pattern.compile(horatioString);
        Matcher regexHoratioMatcher = checkHoratioRegex.matcher(hamletData);

        if(regexHoratioMatcher.find()){
            findHoratio = true;
        }

        return findHoratio;
    }

}

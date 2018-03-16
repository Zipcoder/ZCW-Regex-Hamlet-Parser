import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {

        HamletParser hamletParser = new HamletParser();
        String hamletText = hamletParser.getHamletData();

        String output = hamletParser.replaceHoratioAndHamlet(hamletText);
        BufferedWriter hamletWriter = new BufferedWriter(new FileWriter("/Users/ericbarnaba/Dev/Labs/Hamlet/src/main/resources/LeonPrinceOfDenmark.txt"));
        hamletWriter.write(output);
        hamletWriter.close();


    }

}

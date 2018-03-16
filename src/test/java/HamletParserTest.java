import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
//        this.hamletParser = new HamletParser();
//        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String inputLine = "Change Hamlet to Leon. Change Hamlet to Leon.";
        String[] searchStr = {"Hamlet", "Horatio"};
        String[] repStr = {"Leon", "Tariq"};
        String fileName = "test.txt";
        HamletParser test = new HamletParser(fileName, searchStr, repStr);
        String actual = test.getHamletData();
        String expect = "Change Leon to Leon. Change Leon to Leon.\n";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String inputLine = "Change Horatio to Tariq. Change Horatio to Tariq.";
        String[] searchStr = {"Hamlet", "Horatio"};
        String[] repStr = {"Leon", "Tariq"};
        String fileName = "test.txt";
        HamletParser test = new HamletParser(fileName, searchStr, repStr);
        String actual = test.getHamletData();
        String expect = "Change Leon to Leon. Change Leon to Leon.\n" +
                "Change Tariq to Tariq. Change Tariq to Tariq.\n";
        Assert.assertEquals(expect, actual);
    }


    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}



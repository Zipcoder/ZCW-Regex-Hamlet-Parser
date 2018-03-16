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
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.changeHamletToLeon();
        Pattern pattern = Pattern.compile("Hamlet");
        Pattern pattern2 = Pattern.compile("Leon");
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Matcher matcher2 = pattern2.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());
        Assert.assertTrue(matcher2.find());
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile("Horatio");
        Pattern pattern2 = Pattern.compile("Tariq");
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Matcher matcher2 = pattern2.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());
        Assert.assertTrue(matcher2.find());

    }

    @Test
    public void testFindHoratio() {
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());

    }

    @Test
    public void testFindHamlet() {
        hamletParser.changeHamletToLeon();
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        Assert.assertFalse(matcher.find());
    }
}
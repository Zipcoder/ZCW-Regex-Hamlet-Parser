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
        hamletParser.fileChanger();
        Pattern leonPattern = Pattern.compile("Leon");
        Matcher leonMatcher = leonPattern.matcher(hamletParser.getHamletData());
        boolean actual = leonMatcher.find();
        Assert.assertTrue(actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.fileChanger();
        Pattern tariqPattern = Pattern.compile("Tariq");
        Matcher tariqMatcher = tariqPattern.matcher(hamletParser.getHamletData());
        boolean actual = tariqMatcher.find();
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHoratio() {
        hamletParser.fileChanger();
        Pattern horatioPattern = Pattern.compile("Horatio");
        Matcher horatioMatcher = horatioPattern.matcher(hamletParser.getHamletData());
        boolean actual = horatioMatcher.find();
        Assert.assertFalse(actual);
    }

    @Test
    public void testFindHamlet() {
        hamletParser.fileChanger();
        Pattern hamletPattern = Pattern.compile("Hamlet");
        Matcher hamletMatcher = hamletPattern.matcher(hamletParser.getHamletData());
        boolean actual = hamletMatcher.find();
        Assert.assertFalse(actual);
    }
}
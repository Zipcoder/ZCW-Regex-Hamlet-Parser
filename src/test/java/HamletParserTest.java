import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
    public void testChangeHamletToLeon1()
    {
        HamletParser hamletParser = new HamletParser();

        String input = "Hamlet.HAMLET.";

        String expected = "Leon.LEON";

        String actual = hamletParser.replaceHamletWithLeon(input);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeHamletToLeon2()
    {
        HamletParser hamletParser = new HamletParser();

        String testString = "This is HAMLET.";

        String expected = "This is LEON.";

        String actual = hamletParser.replaceHamletWithLeon(testString);

        Assert.assertEquals(expected, actual);

    }



    @Test
    public void testChangeHoratioToTariq()
    {
        HamletParser hamletParser = new HamletParser();

        String testString = "This is Horatio.";

        String expected = "This is Tariq.";

        String actual = hamletParser.replaceHoratioWithTariq(testString);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}
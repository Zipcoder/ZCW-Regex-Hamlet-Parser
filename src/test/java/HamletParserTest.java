import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String startingString = "Here are some words Hamlet and here are some words Horatio.";
        String expected = "Here are some words Leon and here are some words Horatio.";
        String actual = hamletParser.changeHamletToLeon(startingString);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String startingString = "Here are some words Hamlet and here are some words Horatio.";
        String expected = "Here are some words Hamlet and here are some words Tariq.";
        String actual = hamletParser.changeHoratioToTariq(startingString);
        Assert.assertEquals(expected, actual);
    }

}
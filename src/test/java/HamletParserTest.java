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
        //given
        String sentence = "Hamlet loves cheese";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Leon loves cheese";
        String actual = hamletParser.changeHamletToLeon(sentence);
        Assert.assertEquals(expected,actual);






    }
    @Test
    public void testChangeHamletToLeon2() {
        //given
        String sentence = "Hamlet loves cheese & hamlet loves milk with cookies";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Leon loves cheese & Leon loves milk with cookies";
        String actual = hamletParser.changeHamletToLeon(sentence);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}
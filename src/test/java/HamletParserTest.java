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
        String expected = "Leon";
        String actual = hamletParser.replaceAllHamletWithLeon("Hamlet");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = "Tariq";
        String actual = hamletParser.replaceAllHoratioWithTariq("Horatio");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCaseInsensitivity() {
        String expectedL = "Leon";
        String expectedT = "Tariq";

        String actualL = hamletParser.replaceAllHamletWithLeon("hamLEt");
        String actualT = hamletParser.replaceAllHoratioWithTariq("hOrATiO");

        Assert.assertEquals(expectedL, actualL);
        Assert.assertEquals(expectedT, actualT);
    }
}
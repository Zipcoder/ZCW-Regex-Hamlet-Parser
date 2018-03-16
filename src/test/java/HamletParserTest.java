import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    private String leonText;
    private String tariqText;

    @Before
    public void setUp() {

        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
        this.leonText = hamletParser.getHamletData();
        this.tariqText = hamletParser.getHamletData();

    }

    @Test
    public void testChangeHamletToLeon() {
        String stringTest = "Hamlet is a cool person because HAMLET likes to eat cheese.";

        String expected = "Leon is a cool person because LEON likes to eat cheese.";
        String actual = hamletParser.changeHamletToLeon(stringTest);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String stringTest = "Horatio is a cool person because HORATIO likes to eat cheese.";

        String expected = "Tariq is a cool person because TARIQ likes to eat cheese.";
        String actual = hamletParser.changeHoratioToTariq(stringTest);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {

        Assert.assertTrue(hamletParser.findHoratio());
    }

    @Test
    public void testFindHamlet() {

        Assert.assertTrue(hamletParser.findHamlet());
    }

    @Test
    public void getCounterTest(){
        hamletParser.findMatch("[Hh][Aa][Mm][Ll][Ee][Tt]", hamletText);

        int expected = 472;
        int actual = hamletParser.getCounterTimeSeen();

        Assert.assertEquals(expected, actual);
    }
}
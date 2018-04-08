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
        hamletParser.changeHamletToLeon();

        boolean expected = false;
        boolean actual = hamletParser.findHamlet();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();

        boolean expected = false;
        boolean actual = hamletParser.findHoratio();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testFindHamlet() {
        hamletParser.changeHamletToLeon();

        boolean expected = false;
        boolean actual = hamletParser.findHamlet();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindHoratio() {
        hamletParser.changeHoratioToTariq();

        boolean expected = false;
        boolean actual = hamletParser.findHamlet();

        Assert.assertEquals(actual, expected);
    }


}
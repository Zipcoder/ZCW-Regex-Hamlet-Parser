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
        Assert.assertTrue(hamletParser.checkHamlet());
        Assert.assertFalse(hamletParser.checkLeon());
        hamletParser.changeHamletToLeon();
        Assert.assertFalse(hamletParser.checkHamlet());
        Assert.assertTrue(hamletParser.checkLeon());
    }

    @Test
    public void testChangeHoratioToTariq() {
        Assert.assertTrue(hamletParser.checkHoratio());
        Assert.assertFalse(hamletParser.checkTariq());
        hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletParser.checkHoratio());
        Assert.assertTrue(hamletParser.checkTariq());
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}
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
        HamletParser testlet = new HamletParser();
        testlet.changeHamletToLeon();
        Assert.assertTrue(testlet.findLeon());
        Assert.assertFalse(testlet.findHamlet());
    }

    @Test
    public void testChangeHoratioToTariq() {
        HamletParser testlet = new HamletParser();
        testlet.changeHoratioToTariq();
        Assert.assertTrue(testlet.findTariq());
        Assert.assertFalse(testlet.findHoratio());
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio());
        Assert.assertTrue(hamletParser.findHamlet());
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet());
        assertTrue(hamletParser.findHoratio());
    }
}
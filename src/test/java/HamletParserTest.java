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
        HamletParser hamletParser = new HamletParser();
        String beforeAnyChangesMade = hamletParser.getHamletData();
        hamletParser.hamletToLeon();
        String afterChangesMade = hamletParser.getHamletData();
        Assert.assertNotEquals(beforeAnyChangesMade, afterChangesMade);
    }

    @Test
    public void testChangeHoratioToTariq() {
        HamletParser hamletParser = new HamletParser();
        String beforeAnyChangesMade = hamletParser.getHamletData();
        hamletParser.horatioToTariq();
        String afterChangesMade = hamletParser.getHamletData();
        Assert.assertNotEquals(beforeAnyChangesMade, afterChangesMade);
    }

    @Test
    public void testFindHoratio() {
        HamletParser hamletParser = new HamletParser();
        String beforeAnyChangesMade = "Hello Horatio hello HORATIO";
        hamletParser.horatioToTariq();
        String actual = "Hello Tariq hello Tariq";
        Assert.assertNotEquals(beforeAnyChangesMade, actual);
    }

    @Test
    public void testFindHamlet() {
        HamletParser hamletParser = new HamletParser();
        String beforeAnyChangesMade = "Hello Hamlet hello HAMLET";
        hamletParser.horatioToTariq();
        String actual = "Hello Leon hello Leon";
        Assert.assertNotEquals(beforeAnyChangesMade, actual);
    }
}
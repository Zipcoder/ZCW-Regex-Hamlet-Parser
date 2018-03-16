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
        String preChanges = hamletParser.getHamletData();
        hamletParser.changeHamletToLeon();
        String postChanges = hamletParser.getHamletData();
        Assert.assertNotEquals(preChanges, postChanges);
    }

    @Test
    public void testChangeHoratioToTariq() {
        HamletParser hamletParser = new HamletParser();
        String preChanges = hamletParser.getHamletData();
        hamletParser.changeHoratioToTariq();
        String postChanges = hamletParser.getHamletData();
        Assert.assertNotEquals(preChanges, postChanges);
    }

    @Test
    public void testFindHoratioBeforeChange(){
        HamletParser hamletParser = new HamletParser();
        Assert.assertTrue(hamletParser.contains("Horatio") || hamletParser.contains("HORATIO"));
    }

    @Test
    public void testFindHoratioAfterChange(){
        HamletParser hamletParser = new HamletParser();
        hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletParser.contains("Horatio") || hamletParser.contains("HORATIO"));
    }

    @Test
    public void testFineHamletBeforeChange(){
        HamletParser hamletParser = new HamletParser();
        Assert.assertTrue(hamletParser.contains("Hamlet") || hamletParser.contains("HAMLET"));
    }
    @Test
    public void testFineHamletAfterChange(){
        HamletParser hamletParser = new HamletParser();
        hamletParser.changeHamletToLeon();
        Assert.assertFalse(hamletParser.contains("Hamlet") || hamletParser.contains("HAMLET"));
    }

    @Test
    public void testChangeBothNames(){
        HamletParser hamletParser = new HamletParser();
        String preChanges = hamletParser.getHamletData();
        hamletParser.replaceBothNames();
        String postChanges = hamletParser.getHamletData();
        Assert.assertNotEquals(preChanges, postChanges);
    }
}
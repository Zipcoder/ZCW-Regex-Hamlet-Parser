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
        Assert.assertEquals(true, hamletText.contains("Hamlet"));
        String replaced = hamletParser.changeHamletToLeon();
        Assert.assertEquals(true, replaced.contains("Leon"));
        Assert.assertEquals(false, replaced.contains("Hamlet"));
        Assert.assertEquals(false, replaced.contains("Horatio"));
        Assert.assertEquals(true, replaced.contains("Tariq"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        Assert.assertTrue(hamletText.contains("Horatio"));
        String replaced = hamletParser.changeHamletToLeon();
        Assert.assertTrue(replaced.contains("Tariq"));
        Assert.assertTrue(replaced.contains("Leon"));
        Assert.assertFalse(replaced.contains("Hamlet"));
        Assert.assertFalse(replaced.contains("Horatio"));
    }

    @Test
    public void testChangeName(){
        Assert.assertTrue(hamletText.contains("Horatio"));
        hamletText = hamletParser.changeName("Horatio", "Tariq");
        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("Horatio"));
    }
}
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String expected = hamletParser.changeName("(h|H)amlet", "Leon", this.hamletText);
        Assert.assertFalse(expected.contains("(h|H)amlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletParser.changeName("(h|H)oratio", "Tariq", this.hamletText);
        Assert.assertFalse(expected.contains("(h|H)oratio"));
    }

    @Test
    public void testFindHoratio() {
        String testHoratioStr = "My name is Horatio";
        String horatioPattern = ("(h|H)oratio");

        String expected = "My name is Tariq";
        String actual = hamletParser.changeName(horatioPattern, "Tariq", testHoratioStr);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        String testHoratioStr = "My name is Hamlet, hamlet";
        String hamletPattern = ("(h|H)amlet");

        String expected = "My name is Leon, Leon";
        String actual = hamletParser.changeName(hamletPattern, "Leon", testHoratioStr);

        Assert.assertEquals(expected, actual);
    }
}
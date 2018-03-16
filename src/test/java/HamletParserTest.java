import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
        String input  = "Hamlet, HAMLET, HAMLET, hamlet, hamlet!";
        String expected = "Leon, Leon, Leon, Leon, Leon!";
        String actual = hamletParser.changeHamletToLeon(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String input = "HORATIO, HORATIO, Horatio, horatio!";
        String expected = "Tariq, Tariq, Tariq, Tariq!";
        String actual = hamletParser.changeHoratioToTariq(input);
        Assert.assertEquals(expected, actual);
    }
}
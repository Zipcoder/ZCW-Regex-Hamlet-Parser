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
        String name = "Hamlet";
        String expected = "Leon";
        String actual = this.hamletParser.changeHamletToLeon(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeonFalse() {
        String name = "Tim";
        String expected = null;
        String actual = this.hamletParser.changeHamletToLeon(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String name = "Horatio";
        String expected = "Tariq";
        String actual = this.hamletParser.changeHoratioToTariq(name);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
       String hor = "Horatio";
        boolean expected = true;
        boolean actual = this.hamletParser.findHoratio(hor);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {

        boolean expected = true;
        boolean actual = this.hamletParser.findHamlet("Hamlet");
        Assert.assertEquals(expected, actual);
    }


}
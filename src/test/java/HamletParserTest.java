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
        //Given
        HamletParser testHamletParser = new HamletParser();
        String input = "Hamlet. HAMLET. Hamlet!";

        //When
        String expected = "Leon. LEON. Leon!";
        String actual = testHamletParser.changeHamletToLeon(input);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        HamletParser testHamletParser = new HamletParser();
        String input = "Horatio. HORATIO. Horatio!";

        //When
        String expected = "Tariq. TARIQ. Tariq!";
        String actual = testHamletParser.changeHoratioToTariq(input);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio() {
        boolean expected = true;
        boolean actual = hamletParser.findHamlet("Horatio found");
        assertEquals(expected, actual);
    }
    @Test
    public void testFindHamlet() {
        boolean expected = true;
        boolean actual = hamletParser.findHamlet("Hamlet found");
        assertEquals(expected, actual);
    }
}
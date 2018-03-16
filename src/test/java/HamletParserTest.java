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
        String test = "Hamlet Hamlet HAMLET";
        //When
        String expected = "Leon Leon LEON";
        String actual = hamletParser.changeHamletToLeon(test);
        //THen
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String test = "Hamlet Hamlet HAMLET";
        //When
        String expected = "Leon Leon LEON";
        String actual = hamletParser.changeHamletToLeon(test);
        //THen
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //When
        int actual = 158;
        int expected = hamletParser.findHoratio();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        //When
        int actual = 472;
        int expected = hamletParser.findHamlet();
        //Then
        Assert.assertEquals(expected, actual);
    }

}
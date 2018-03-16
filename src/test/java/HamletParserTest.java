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
    public void testreplaceHoratioAndHamlet() {
        //Given
        //hamletParser
        String text = "Hamlet HAMLET Horatio HORATIO";

        //When
        String actual = hamletParser.replaceHoratioAndHamlet(text);
        String expected = "Leon LEON Tariq TARIQ";

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        //hamletParser
        String text = "Hamlet";

        //When
        String actual = hamletParser.replaceHamlet(text);
        String expected = "Leon";

        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testChangeHAMLETToLEON() {
        //Given
        //hamletParser
        String text = "HAMLET HAMLET";

        //When
        String actual = hamletParser.replaceHAMLET(text);
        String expected = "LEON LEON";

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        //hamletParser
        String text = "Horatio";

        //When
        String actual = hamletParser.replaceHoratio(text);
        String expected = "Tariq";

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHORATIOToTARIQ() {
        //Given
        //hamletParser
        String text = "HORATIO HORATIO";

        //When
        String actual = hamletParser.replaceHORATIO(text);
        String expected = "TARIQ TARIQ";

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        //hamletParser
        String text = "Horatio";

        //When

        //Then
        Assert.assertTrue(hamletParser.findHoratio(text));


    }

    @Test
    public void testFindHORATIO(){
        //Given
        //hamletParser
        String text = "HORATIO";

        //When

        //Then
        Assert.assertTrue(hamletParser.findHORATIO(text));

    }

    @Test
    public void testFindHamlet() {
        //Given
        //hamletParser
        String text = "Hamlet";

        //When

        //Then
        Assert.assertTrue(hamletParser.findHamlet(text));

    }

    @Test
    public void testFindHAMLET(){
        //Given
        //hamletParser
        String text = "HAMLET";

        //When

        //Then
        Assert.assertTrue(hamletParser.findHAMLET(text));

    }
}
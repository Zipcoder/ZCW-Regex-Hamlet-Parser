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
        String testString = "Hamlet. HAMLET. Hamlet!";
        //When
        String expected = "Leon. LEON. Leon!";
        String actual = testHamletParser.changeHamletToLeon(testString);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        HamletParser testHamletParser = new HamletParser();
        String testString = "Horatio. HORATIO. Horatio!";
        //When
        String expected = "Tariq. TARIQ. Tariq!";
        String actual = testHamletParser.changeAll(testString);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeAll() {
        //Given
        HamletParser testHamletParser = new HamletParser();
        String testString = "Horatio. HORATIO. Horatio! Hamlet. HAMLET. Hamlet!";
        //When
        String expected = "Tariq. TARIQ. Tariq! Leon. LEON. Leon!";
        String actual = testHamletParser.changeAll(testString);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        HamletParser testHamletParser = new HamletParser();
        String testString = "Horatio. HORATIO. Horatio!";

        //When
        Integer expected = 158;
        Integer actual = testHamletParser.findHoratio(hamletText);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        //Given
        HamletParser testHamletParser = new HamletParser();

        //When
        Integer expected = 472;
        Integer actual = testHamletParser.findHalmet(hamletText);

        //Then
        Assert.assertEquals(expected, actual);
    }
}
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
        String input = "LAERTES wounds Hamlet; then in scuffling, they change rapiers, and Hamlet wounds LAERTES";
        String expected = "LAERTES wounds Leon; then in scuffling, they change rapiers, and Leon wounds LAERTES";

        HamletParser hamletParser = new HamletParser(input);

        //When
        hamletParser.changeHamletToLeon();

        //Then
        String actual = hamletParser.getHamletData();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        String input = "Horatio needs to change to Horatio";
        String expected = "Tariq needs to change to Tariq";

        HamletParser hamletParser = new HamletParser(input);

        //When
        hamletParser.changeHoratioToTariq();

        //Then
        String actual = hamletParser.getHamletData();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        boolean expected = true;
        HamletParser hamletParser = new HamletParser();
        //When
        boolean actual = hamletParser.findHamlet();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {

        //Given
        boolean expected = true;
        HamletParser hamletParser = new HamletParser();
        //When
        boolean actual = hamletParser.findHoratio();
        //Then
        Assert.assertEquals(expected, actual);
    }
}
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
        String test = "Hamlet HAMLET HORATIO. Horatio";

        //When
        String expected = "Leon LEON HORATIO. Horatio";
        String actual = hamletParser.changeHamletToLeon(test);

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String test = "Hamlet HAMLET HORATIO. Horatio";

        //When
        String expected = "Hamlet HAMLET TARIQ. Tariq";
        String actual = hamletParser.changeHoratioToTariq(test);

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testChangeALL() {
        //Given
        String test = "Hamlet HAMLET HORATIO. Horatio";

        //When
        String expected = "Leon LEON TARIQ. Tariq";
        String actual = hamletParser.changeAll(test);

        Assert.assertEquals(expected, actual);
    }


        @Test
    public void testFindHoratio() {

        int expected = 158;
        int actual = hamletParser.findHoratio();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testFindHamlet() {
        int expected = 472;
        int actual = hamletParser.findHamlet();
        Assert.assertEquals(expected,actual);

    }
}
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
        String testHamletText = "HaMlet, HAMLET will be replaced by Hamlet.";
        System.out.println(testHamletText);
        testHamletText=hamletParser.changeHamletToLeon(testHamletText);

        boolean actual = hamletParser.findHamlet(testHamletText);
        Assert.assertFalse(actual);

        System.out.println(testHamletText);

    }

    @Test
    public void testChangeHoratioToTariq() {
        String testHoratioText = "Horatio will be replaced by Tariq, HoRaTIo HORATIO to Tariq";
        testHoratioText=hamletParser.changeHoratioToTariq(testHoratioText);

        boolean actual = hamletParser.findHoratio(testHoratioText);
        Assert.assertFalse(actual);

        System.out.println(testHoratioText);
    }

    @Test
    public void testFindHoratio1() {
        String test = "Hor, will go Horatio, life is beautiful and HORATIO enjoys it.";
        boolean actual = hamletParser.findHoratio(test);
        Assert.assertTrue(actual);
    }
    @Test
    public void testFindHoratio2(){

        boolean actual = hamletParser.findHoratio(hamletText);
        Assert.assertTrue(actual);

    }

    @Test
    public void testFindHamlet() {

        boolean actual = hamletParser.findHamlet(hamletText);
        System.out.println(hamletParser.regexChecker("[Hh][Aa][Mm][Ll][Ee][Tt]",hamletText));
        Assert.assertTrue(actual);
    }

}
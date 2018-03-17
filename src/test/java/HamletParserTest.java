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
        //given
        String sentence = "Hamlet loves cheese";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Leon loves cheese";
        String actual = hamletParser.changeHamletToLeon(sentence);
        Assert.assertEquals(expected,actual);






    }
    @Test
    public void testChangeHamletToLeon2() {
        //given
        String sentence = "Hamlet loves cheese & hamlet loves milk with cookies";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Leon loves cheese & Leon loves milk with cookies";
        String actual = hamletParser.changeHamletToLeon(sentence);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String sentence = "Horatio hates cowboy fans and will kill them all";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Tariq hates cowboy fans and will kill them all";
        String actual = hamletParser.changeHoratioToTariq(sentence);
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testChangeHoratioToTariq2() {
        String sentence = "Horatio loves the eagles horatio was happy when the eagles won the superbowl";
        HamletParser hamletParser = new HamletParser(sentence);
        String expected = "Tariq loves the eagles Tariq was happy when the eagles won the superbowl";
        String actual = hamletParser.changeHoratioToTariq(sentence);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindHoratio() {
        //Given
        boolean expected = true;

        //when
        hamletParser = new HamletParser();
        boolean actual = hamletParser.findHoratio();

        //Then
        Assert.assertEquals(expected,actual);








    }

    @Test
    public void testFindHamlet() {
        //Given
        boolean expected = true;

        //when
        hamletParser = new HamletParser();
        boolean actual = hamletParser.findHoratio();

        //Then
        Assert.assertEquals(expected,actual);
    }
}
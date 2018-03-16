import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String expected = "Leon";
        String actual = hamletParser.changeHamletToLeon("Hamlet");
        assertEquals(expected, actual);
    }


    @Test
    public void testChangeHoratioToTariq() {
        String expected = "Tariq";
       String actual = hamletParser.changeHoratioToTariq("Horatio");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        boolean expected = true;
        boolean actual = hamletParser.findHoratio("This is a string with the name Horatio in it");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        boolean expected = true;
        boolean actual = hamletParser.findHamlet("This is a string with the name Hamlet in it");
        assertEquals(expected, actual);
    }

    @Test
    public void testChangedBothNames(){
        String expected = "Tariq and Leon are friends";
        String actual = hamletParser.changeBothNames("Horatio and Hamlet are friends");
        assertEquals(expected, actual);

    }
}
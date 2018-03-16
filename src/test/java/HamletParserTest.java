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
        System.out.println(hamletParser.changeHamletToLeon());
    }


    @Test
    public void testChangeHoratioToTariq() {
        System.out.println(hamletParser.changeHoratioToTariq());

    }

    @Test
    public void testFindHoratio() {
        hamletParser.findHamlet(hamletParser.changeHamletToLeon());
        assertTrue(true);
    }

    @Test
    public void testFindHamlet() {
        hamletParser.findHoratio();
    }

    @Test
    public void testChangedBothNames(){
        System.out.println(hamletParser.changeBothNames());
    }
}
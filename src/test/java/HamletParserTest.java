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

        String inputTest = "Hamlet's hunt hath wrought but many a curse upon thine land.  HAMLET " +
                "Doth thou Hamlet haveth hatched eggs to say about these claims?  Whom soever may Hamlet harm further?";

        String expected = "Leon's hunt hath wrought but many a curse upon thine land.  LEON " +
                "Doth thou Leon haveth hatched eggs to say about these claims?  Whom soever may Leon harm further?";

        Assert.assertEquals(expected, hamletParser.findMatch());

    }

    @Test
    public void testChangeHoratioToTariq() {

        String inputTest = "HORATIO: Horatio Horatios Horatio's";
        String expected = "TARIQ: Tarig Tariqs Tariq's";


        Assert.assertEquals(expected, hamletParser.findMatch());

    }

    @Test
    public void testFindHoratio() {

    }

    @Test
    public void testFindHamlet() {
    }

    @Test
    public void testMatchHoratio() {

    }

    @Test
    public void testMatchHamlet() {

    }




}
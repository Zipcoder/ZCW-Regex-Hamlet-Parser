import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HamletParserTest {
    private String hamletText;
    public HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String before = hamletParser.getHamletData();
        //When
        hamletParser.changeIfHamlet();
        String after = hamletParser.getHamletData();
        //Then
        Assert.assertNotEquals(before, after);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String before = hamletParser.getHamletData();
        //When
        hamletParser.changeIfHoratio();
        String after = hamletParser.getHamletData();
        //Then
        Assert.assertNotEquals(before, after);
    }

    @Test
    public void testFindHoratio() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String s = "Horatio";
        //When
        hamletParser.findHoratio();
        //Then
        Assert.assertTrue(s, hamletParser.findHoratio());
    }

    @Test
    public void testFindHamlet() {
        //Given
        HamletParser hamletParser = new HamletParser();
        String s = "Hamlet";
        //When
        hamletParser.findHamlet();
        //Then
        Assert.assertTrue(s, hamletParser.findHamlet());
    }
}
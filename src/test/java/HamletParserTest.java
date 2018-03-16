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
        // Given
        String inputString = "Change Hamlet to Leon";
        String expectedString = "Change Leon to Leon";
        hamletParser = new HamletParser(inputString);
        // When
        hamletParser.changeHamletToLeon();
        String actualString = hamletParser.getHamletData();
        // Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        String inputString = "Change Horatio to Tariq";
        String expectedString = "Change Tariq to Tariq";
        hamletParser = new HamletParser(inputString);
        // When
        hamletParser.changeHoratioToTariq();
        String actualString = hamletParser.getHamletData();
        // Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testFindHoratio() {
        // Given
        boolean expectedFindHoratio = true;
        // When
        hamletParser = new HamletParser();
        boolean actualFindHoratio = hamletParser.findHoratio();
        // Then
        Assert.assertEquals(expectedFindHoratio, actualFindHoratio);
    }

    @Test
    public void testFindHamlet() {
        // Given
        boolean expectedFindHamlet = true;
        // When
        hamletParser = new HamletParser();
        boolean actualFindHamlet = hamletParser.findHamlet();
        // Then
        Assert.assertEquals(expectedFindHamlet, actualFindHamlet);
    }
}
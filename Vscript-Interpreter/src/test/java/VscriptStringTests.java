import DataTypes.VscriptString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VscriptStringTests {
    @Test
    public void testCapitalize() {
        String expected = "Banana";

        // average case
        VscriptString toTest = new VscriptString("banana");
        assertEquals(toTest.capitalize(), expected);

        // case in which there is a space as first character
        toTest = new VscriptString(" banana");
        assertNotEquals(toTest.capitalize(), expected);
    }

    @Test
    public void testCenter() {
        String expected = "OOOOOOObananaOOOOOOO";

        VscriptString toTest = new VscriptString("banana");
        assertEquals(toTest.center(20, 'O'),expected);
    }

}

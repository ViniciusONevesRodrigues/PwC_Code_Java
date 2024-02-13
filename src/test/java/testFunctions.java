import org.junit.*;

import br.com.pwcode.functions.functions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class testFunctions {
    
    @Test
    public void testSimpleAddress() {
        functions functions = new functions();

        String result = functions.simpleAddress("Miritiba 339");

        assertEquals("{Miritiba, 339}", result);
    }
    @Test
    public void testBiggerAddress() {
        functions functions = new functions();

        String result = functions.simpleAddress("Quirino dos Santos 23 b");

        assertEquals("{Quirino dos Santos, 23 b}", result);
    }
    @Test
    public void testForeignAddressWithCommaAndNumber() {
        functions functions = new functions();

        String result = functions.simpleAddress("4, Rue de la République");

        assertEquals("{Rue de la République, 4}", result);
    }
    @Test
    public void testForeignAddressWithNumber() {
        functions functions = new functions();

        String result = functions.simpleAddress("100 Broadway Av");

        assertEquals("{Broadway Av, 100}", result);
    }
    @Test
    public void testForeignAddressWithComma() {
        functions functions = new functions();

        String result = functions.simpleAddress("Calle Sagasta, 26");

        assertEquals("{Calle Sagasta, 26}", result);
    }
    @Test
    public void testForeignAddressWithNo() {
        functions functions = new functions();

        String result = functions.simpleAddress("Calle 44 No 1991");

        assertEquals("{Calle 44, No 1991}", result);
    }
    @Test
    public void testIsForeignAddress() {
        functions functions = new functions();

        List<String> list = Arrays.asList("Calle", "44", "No", "1991");

        int result = functions.isForeignAddress(list);

        assertEquals(4, result);
    }
    @Test
    public void testContainsNumber() {
        functions functions = new functions();

        boolean result = functions.containsNumber("test123");

        assertEquals(true, result);
    }
}

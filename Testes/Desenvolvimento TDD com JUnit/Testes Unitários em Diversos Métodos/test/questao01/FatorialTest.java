package questao01;

import org.junit.Test;
import static org.junit.Assert.*;

public class FatorialTest {
    
    public FatorialTest() {
    }

    @Test
    public void testCT01() {
        assertEquals("True",120, Fatorial.fatorial(5));
    }
    
    @Test
    public void testCT02() {
        assertEquals("True",3628800, Fatorial.fatorial(10));
    }
    
}

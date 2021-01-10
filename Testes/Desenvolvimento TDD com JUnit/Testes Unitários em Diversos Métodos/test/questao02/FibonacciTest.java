package questao02;

import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {
    
    public FibonacciTest() {
    }
    
    @Test
    public void testCT01() {
        assertEquals(8, Fibonacci.fibo(6));
    }
    
    @Test
    public void testCT02() {
         assertEquals(55, Fibonacci.fibo(10));
    }
    
    @Test
    public void testCT03() {
        assertEquals(89, Fibonacci.fibo(11));
    }
    
}

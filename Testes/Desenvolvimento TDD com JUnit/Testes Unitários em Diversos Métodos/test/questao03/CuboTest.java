package questao03;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuboTest {
    
    public CuboTest() {
    }

    @Test
    public void CT01() {
        assertEquals(25, Cubo.areaLadoCubo(5));
    }

    @Test
    public void CT02() {
        assertEquals(100, Cubo.areaLateralCubo(5));
    }
    
    @Test
    public void CT03() {
        assertEquals(150, Cubo.areaTotalCubo(5));
    }
    
    @Test
    public void CT04() {
        assertEquals(125, Cubo.volumeCubo(5));
    }
    
    @Test
    public void CT05(){
        int a = 5;
        int resultadoEsperado = 1000;        
        assertFalse("O resultado é falso", Cubo.volumeCubo(a)==resultadoEsperado);
    }
    
    @Test
    public void CT06(){
        int a = 5;
        int resultadoEsperado = 125;        
        assertTrue("O resultado é verdadeiro", Cubo.volumeCubo(a)==resultadoEsperado);
    }    
        
}

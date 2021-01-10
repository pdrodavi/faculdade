package questao05;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestVerificarTriangulo {
    
    public TestVerificarTriangulo() {
    }
    
    @Test
    public void CT01(){
        assertTrue("True", VerificarTriangulo.triangulo(5, 6, 10));
    }
    
    @Test
    public void CT02(){
        assertFalse("False",VerificarTriangulo.triangulo(5, 6, 20));
    }
    
    @Test
    public void CT03(){
        assertFalse("Não é um Triângulo",VerificarTriangulo.triangulo(5, 6, 20));
    }
    
    @Test
    public void CT04(){
        assertEquals("Triangulo Equilátero", true, VerificarTriangulo.triangulo(6, 6, 6));
    }
    
    @Test
    public void CT05(){
        assertEquals("Triangulo Isóceles", true, VerificarTriangulo.triangulo(6, 6, 10));
    }
    
    @Test
    public void CT06(){
        assertEquals("Triangulo Isóceles", true, VerificarTriangulo.triangulo(6, 10, 6));
    }
    
    @Test
    public void CT07(){
        assertEquals("Triangulo Isóceles", true, VerificarTriangulo.triangulo(10, 6, 6));
    }
    
    @Test
    public void CT08(){
        assertEquals("Triangulo Escaleno", true, VerificarTriangulo.triangulo(5, 6, 7));
    }
}

package questao05;

public class VerificarTriangulo {
    
    public static boolean triangulo(int a, int b, int c){
        if((a < b + c) && (b < a + c) && (c < a + b)){
            if((a==b) && (b==c) && (a==c)){ //Condição para indentificar se é um triangulo Equilátero
                return true;
            }else{
                if((a==b) || (b==c) || (a==c)){ //Condição para identificar se é um triangulo Isóceles
                    return true;
                }else{ //Caso não seja Equilátero ou Isóceles, será Escaleno
                    return true;
                }                
            }
        }else{ //Caso não atenda nenhum das condições, então não será um triangulo
            return false;
        }            
    }
}

package questao03;

public class Cubo {
    
    public Cubo() {
    }   
    
    public static int areaLadoCubo(int a){
        int areaCubo = a*a;
        return areaCubo;
    }
    
    public static int areaLateralCubo(int a){
        int areaLateral = 4*(a*a);
        return areaLateral;
    }
    
    public static int areaTotalCubo(int a){
        int areaTotal = 6*(a*a);
        return areaTotal;
    }
    
    public static int volumeCubo(int a){
        int volume = a*a*a;
        return volume;
    }
    

}

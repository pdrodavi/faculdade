package prototypepattern;

public class PrototypePattern {

    public static void main(String[] args) {
        
        Televisao tvPrototype = new Televisao();
        
        TelevisaoPrototype tv1 = tvPrototype.clonar();
        TelevisaoPrototype tv2 = tvPrototype.clonar();
        
        tv1.setValor(2000);
        tv2.setValor(3000);
        
        System.out.println("Tv 1: " + tv1.exibirInfo());
        System.out.println("Tv 2: " + tv2.exibirInfo());
    }
    
}

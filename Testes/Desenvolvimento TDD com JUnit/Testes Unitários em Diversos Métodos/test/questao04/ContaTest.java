package questao04;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContaTest {
    
    Conta c1, c2;
    
    public ContaTest(){
    }
   
    @Test // depositar
    public void CT01(){
        System.out.println("");
        System.out.println("CT01 - Depositar valor válido");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.depositar(c1, 1000));
    }
    
    @Test // depositar valor negativo
    public void CT02(){
        System.out.println("");
        System.out.println("CT02 - Depositar valor negativo");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.depositar(c1, -2));
    }
    
    @Test // sacar dentro do limite
    public void CT03(){
        System.out.println("");
        System.out.println("CT03 - Sacar dentro do limite");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.sacar(c1, 1000));
    }
    
    @Test // sacar fora do limite
    public void CT04(){
        System.out.println("");
        System.out.println("CT04 - Sacar fora do limite");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.sacar(c1, 3100));
    }
    
    @Test // comprar dentro do limite de crédito
    public void CT05(){
        System.out.println("");
        System.out.println("CT05 - Compra dentro do limite do crédito");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.comprarNoCredito(1500));
    }
    
    @Test // comprar fora do limite de crédito
    public void CT06(){
        System.out.println("");
        System.out.println("CT06 - Compra fora do limite do crédito");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        assertEquals(true, Conta.comprarNoCredito(2200));
    }
    
    @Test // transferência válida
    public void CT07(){
        System.out.println("");
        System.out.println("CT07 - Transferência válida entre duas contas");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        c2 = new Conta(2, "Solon Diego", 4000, 3000);
        assertEquals(true, Conta.transferir(c2, c1, 1000));
    }
    
    @Test // transferência inválida - salvo negativo
    public void CT08(){
        System.out.println("");
        System.out.println("CT08 - Transferência inválida entre duas contas");
        c1 = new Conta(1, "Pedro Davi", 3000, 2000);
        c2 = new Conta(2, "Solon Diego", 4000, 3000);
        assertEquals(true, Conta.transferir(c1, c2, 5000));
    }
}

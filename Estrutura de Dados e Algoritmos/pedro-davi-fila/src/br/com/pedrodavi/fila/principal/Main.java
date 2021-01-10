package br.com.pedrodavi.fila.principal;

import br.com.pedrodavi.fila.classes.Aluno;
import br.com.pedrodavi.fila.classes.Fila;

public class Main {
 
    public static void main(String[] args) {
        
        Fila fila = new Fila();
        
        Aluno a1 = new Aluno("Pedro", 111, "Ciencia da Computacao");
        Aluno a2 = new Aluno("Amanda", 222, "Ciencia da Computacao");
        Aluno a3 = new Aluno("Daniel", 333, "Sistemas de Informação");
        
        fila.inserir(a1);
        fila.inserir(a2);
        fila.inserir(a3);
        fila.verifica(111);
        fila.verifica(222);
        fila.verifica(444);
        
        System.out.println(fila.imprimir());
        System.out.println("Tamanho: " + fila.getTamanho());
        
        fila.remover();
        System.out.println(fila.imprimir());
        System.out.println("Tamanho: " + fila.getTamanho());
        
        fila.retornaTopo();
        System.out.println(fila.imprimir());
        
    }
    
}

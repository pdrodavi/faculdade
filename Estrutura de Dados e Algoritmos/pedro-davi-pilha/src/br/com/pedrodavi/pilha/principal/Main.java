package br.com.pedrodavi.pilha.principal;

import br.com.pedrodavi.pilha.classes.Pilha;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        pilha.empilhar(2);
        pilha.empilhar(4);
        pilha.empilhar(6);
        pilha.empilhar(1);
        System.out.println(pilha.getTamanho());
        System.out.println(pilha.imprimir());
        pilha.retornaTopo();

        if (pilha.getTamanho() > 0) {

            try {

                File arquivo = new File("numeros_da_pilha.txt");
                arquivo.createNewFile();

                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(pilha.imprimir());
                bw.newLine();

                bw.close();
                fw.close();

            } catch (IOException e) {

                System.out.println("Erro! Arquivo não criado.");
            }

        }

    }

}

package br.com.pedrodavi.listaduplamenteencadeada.principal;

import br.com.pedrodavi.listaduplamenteencadeada.classes.ListaDuplamenteEncadeada;
import br.com.pedrodavi.listaduplamenteencadeada.classes.No;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // lista 1
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(7);
        lista.inserir(5);
        System.out.println("Lista 1: " + lista.imprimir());

        // lista 2
        ListaDuplamenteEncadeada lista2 = new ListaDuplamenteEncadeada();

        No atual = lista.getPrimeiro();
        for (int i = 0; i < lista.getTamanho(); i++) {

            lista2.inserir(atual.getNumero() * 3);
            atual = atual.getProximo();

        }

        System.out.println("Lista 2: " + lista2.imprimir());

        // lista 3
        ListaDuplamenteEncadeada lista3 = new ListaDuplamenteEncadeada();

        No atualLista3 = lista.getPrimeiro();
        for (int i = 0; i < lista.getTamanho(); i++) {

            lista3.inserir(atualLista3.getNumero());
            atualLista3 = atualLista3.getProximo();

        }

        No atualLista3_1 = lista2.getPrimeiro();
        for (int i = 0; i < lista2.getTamanho(); i++) {

            lista3.inserir(atualLista3_1.getNumero());
            atualLista3_1 = atualLista3_1.getProximo();

        }

        System.out.println("Lista 3: " + lista3.imprimir());

        try {

            File arquivo = new File("lista_final.txt");
            arquivo.createNewFile();

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(lista3.imprimir());
            bw.newLine();

            bw.close();
            fw.close();

        } catch (IOException e) {

            System.out.println("Erro! Arquivo não criado.");
        }

    }

}

package br.grupo.so;

import br.grupo.so.model.GeredorProcessos;
import br.grupo.so.model.Processo;

public class Main {
  public static void main(String[] args) {
    System.out.println("Esse eh um simulador de processamento de processos de uma CPU!!");
    
    GeredorProcessos gerador = new GeredorProcessos();

    // Gera 3 processos de exemplo
    for (int i = 0; i < 3; i++) {
        Processo p = gerador.gerarProcesso();
        System.out.println(p);

        System.out.println("Processo " + p.getId() + " finalizado!");
    };
  };
};
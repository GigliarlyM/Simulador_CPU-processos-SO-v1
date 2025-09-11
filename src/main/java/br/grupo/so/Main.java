package br.grupo.so;

import br.grupo.so.model.*;
import br.grupo.so.model.escalonador.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Esse eh um simulador de processamento de processos de uma CPU!!");

    Random random = new Random();
    CPU cpu;
    GeredorProcessos gerador = new GeredorProcessos();
    Escalonador escalonador;
    Scanner sc = new Scanner(System.in);
    System.out.println("Tipo de escalonador: ");
    String tipo = sc.nextLine();

    switch (tipo) {
      case "FCFS" -> {
        escalonador = new FCFS();
      }
      case "SJF" -> {
        escalonador = new SJF();
      }
      default -> {
        escalonador = new RoundRobin(random.nextInt(6));
      }
    };

    // Gera 3 processos automaticamente
    for (int i = 0; i < 3; i++) {
      Processo p = gerador.gerarProcesso();
      escalonador.adicionarProcesso(p);
      System.out.println(p);
    };

    cpu = new CPU(escalonador);
    cpu.executar();
    sc.close();
  };
};
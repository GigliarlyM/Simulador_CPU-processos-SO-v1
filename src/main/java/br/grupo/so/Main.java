package br.grupo.so;

import br.grupo.so.model.GeredorProcessos;
import br.grupo.so.model.Processo;
import br.grupo.so.model.escalonador.FCFS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Esse eh um simulador de processamento de processos de uma CPU!!");

        GeredorProcessos gerador = new GeredorProcessos();
        FCFS fcfs = new FCFS();

        // Gera 3 processos automaticamente
        for (int i = 0; i < 3; i++) {
            Processo p = gerador.gerarProcesso();
            fcfs.adicionarProcesso(p);   // adiciona no escalonador
            System.out.println("Gerado: " + p.getId() + " (chegada=" + p.getChegada() + ", burst=" + p.getBurst() + ")");
        }

        // Simula com os processos gerados
        fcfs.simular();
    }
}
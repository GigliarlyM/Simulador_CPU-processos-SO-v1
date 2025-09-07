package br.grupo.so.model.escalonador;

import br.grupo.so.model.Escalonador;
import br.grupo.so.model.Processo;

import java.util.ArrayDeque;
import java.util.Queue;

import java.util.*;

public class FCFS extends Escalonador {
	Queue<Processo> processos;

	public FCFS() {
		this.processos = new ArrayDeque<Processo>();
	};

	@Override
	public void adicionarProcesso(Processo processo) {
		this.processos.offer(processo);
	};

	@Override
	public Processo proximoProcesso() {
		return this.processos.poll();
	};

	@Override
	public void removerProcesso(Processo processo) {
		this.processos.remove(processo);
	};

	@Override
	public boolean temProcesso() {
		return !this.processos.isEmpty();
	};

	public void simular() {
	    List<Processo> lista = new ArrayList<>(processos);
	    lista.sort(Comparator.comparingInt(Processo::getChegada));

	    int tempoAtual = 0;
	    for (Processo p : lista) {
	        if (tempoAtual < p.getChegada()) {
	            tempoAtual = p.getChegada();
	        }

	        p.setInicio(tempoAtual);
	        p.setTermino(p.getInicio() + p.getBurst());
	        p.setTurnaround(p.getTermino() - p.getChegada());
	        p.setEspera(p.getTurnaround() - p.getBurst());

	        tempoAtual = p.getTermino();
	    }

	    System.out.println("ID | Chegada | Burst | Início | Término | Turnaround | Espera");
	    for (Processo p : lista) {
	        System.out.printf("%s  |   %d      |   %d   |   %d     |   %d      |     %d      |   %d\n",
	                p.getId(), p.getChegada(), p.getBurst(),
	                p.getInicio(), p.getTermino(), p.getTurnaround(), p.getEspera());
	    };
	};
};
package br.grupo.so.model.escalonador;

import br.grupo.so.model.Escalonador;
import br.grupo.so.model.Processo;

import java.util.ArrayDeque;
import java.util.Queue;

public class FCFS extends Escalonador {
  Queue<Processo> processos;

  public FCFS() {
    this.processos = new ArrayDeque<Processo>();
  }

  @Override
  public void adicionarProcesso(Processo processo) {
    this.processos.offer(processo);
  }

  @Override
  public Processo proximoProcesso() {
    return this.processos.poll();
  }

  @Override
  public void removerProcesso(Processo processo) {
    this.processos.remove(processo);
  }

  @Override
  public boolean temProcesso() {
    return !this.processos.isEmpty();
  }
}

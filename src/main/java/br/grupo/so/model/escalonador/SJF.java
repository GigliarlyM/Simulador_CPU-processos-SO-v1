package br.grupo.so.model.escalonador;

import br.grupo.so.model.Escalonador;
import br.grupo.so.model.Processo;

import java.util.PriorityQueue;

// Nao preemptivo
public class SJF extends Escalonador {
  private PriorityQueue<Processo> queue;

  public SJF() {
    this.queue = new PriorityQueue<>();
  };

  @Override
  public void adicionarProcesso(Processo processo) {
    this.queue.offer(processo);
  };

  @Override
  public Processo proximoProcesso() {
    return this.queue.poll();
  };

  @Override
  public void removerProcesso(Processo processo) {
    this.queue.remove(processo);
  };

  @Override
  public boolean temProcesso() {
    return !this.queue.isEmpty();
  };
};
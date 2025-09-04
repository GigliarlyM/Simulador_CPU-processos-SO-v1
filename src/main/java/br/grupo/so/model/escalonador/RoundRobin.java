package br.grupo.so.model.escalonador;

import br.grupo.so.model.Escalonador;
import br.grupo.so.model.Processo;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Escalonador {
  private Queue<Processo> queue;
  private int quantum;
  private int contadorQuantum;

  public RoundRobin(int quantum) {
    this.contadorQuantum = 0;
    this.quantum = quantum;
    this.queue = new LinkedList<>();
  }

  @Override
  public void adicionarProcesso(Processo processo) {
    this.queue.offer(processo);
  }

  @Override
  public Processo proximoProcesso() {
    return this.queue.poll();
  }

  @Override
  public void removerProcesso(Processo processo) {
    this.queue.remove(processo);
  }

  @Override
  public boolean temProcesso() {
    return !this.queue.isEmpty();
  }

  public void somarQuantum() {
    this.contadorQuantum++;

    if (this.contadorQuantum >= this.quantum) {
      this.contadorQuantum = 0;
    }
  }

  public boolean atingiuQuantum() {
    return this.contadorQuantum >= this.quantum;
  }

}

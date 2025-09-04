package br.grupo.so.model.escalonador;

import br.grupo.so.model.Escalonador;
import br.grupo.so.model.Processo;

import java.util.ArrayDeque;

public class FCFS extends Escalonador {


  public FCFS() {
    this.processos = new ArrayDeque<Processo>();
  }

  @Override
  public void adicionarProcesso(Processo processo) {

  }

  @Override
  public Processo proximoProcesso() {
    return null;
  }

  @Override
  public void removerProcesso(Processo processo) {

  }

  @Override
  public boolean temProcesso() {
    return false;
  }
}

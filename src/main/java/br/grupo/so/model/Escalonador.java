package br.grupo.so.model;

public abstract class Escalonador {
  public int contador;

  abstract public void adicionarProcesso(Processo processo);

  abstract public Processo proximoProcesso();

  abstract public void removerProcesso(Processo processo);

  abstract public boolean temProcesso();

}

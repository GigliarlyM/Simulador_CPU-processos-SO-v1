package br.grupo.so.model;


/* Todas as classes filhas terao esses metodos mudando o tipo de estruturacao de dados
* */
public abstract class Escalonador {
  public int contador;

  abstract public void adicionarProcesso(Processo processo);

  abstract public Processo proximoProcesso();

  abstract public void removerProcesso(Processo processo);

  abstract public boolean temProcesso();

}

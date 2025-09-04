package br.grupo.so.model;

public class Processo implements Comparable<Processo>{
  int id;
  int quantidadeInstrucoes;

  @Override
  public int compareTo(Processo outro) {
    return Integer.compare(quantidadeInstrucoes, outro.quantidadeInstrucoes);
  }
}

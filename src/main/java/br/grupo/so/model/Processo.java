package br.grupo.so.model;

public class Processo implements Comparable<Processo>{
  int id;
  int quantidadeInstrucoes;

  public Processo(int id, int quantidadeInstrucoes) {
    this.id = id;
    this.quantidadeInstrucoes = quantidadeInstrucoes;
  };

  public void executarInstrucao() {
    if(quantidadeInstrucoes > 0) {
      quantidadeInstrucoes--;
      System.out.println("O processo de " + id + " foi executado. Restam " + quantidadeInstrucoes + " processos");
    }

    else {
      System.out.println("Os processos acabaram. Processo finalizado");
    };
  };

  public int getId() {
    return id;
  };

  public void setId(int id) {
    this.id = id;
  };

  public int getQuantidadeInstrucoes() {
    return quantidadeInstrucoes;
  };

  public void setQuantidadeInstrucoes(int quantidadeInstrucoes) {
    this.quantidadeInstrucoes = quantidadeInstrucoes;
  };

  @Override
  public int compareTo(Processo outro) {
    return Integer.compare(quantidadeInstrucoes, outro.quantidadeInstrucoes);
  }

  @Override
  public String toString() {
	return "Processo [id=" + id + ", quantidadeInstrucoes=" + quantidadeInstrucoes + "]";
  };
};
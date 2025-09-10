package br.grupo.so.model;

public class Processo implements Comparable<Processo> {
  private int id;
  private int quantidadeInstrucoes;

  public Processo(int id, int quantidadeInstrucoes) {
    this.id = id;
    this.quantidadeInstrucoes = quantidadeInstrucoes;
  }

  public void reduzirIntrucoes() {
    if (quantidadeInstrucoes >= 0) {
      this.quantidadeInstrucoes--;
    }
  }

  public int getQuantidadeInstrucoes() {
    return quantidadeInstrucoes;
  }

  @Override
  public String toString() {
    return "Processo{" +
            "id=" + id +
            ", quantidadeInstrucoes=" + quantidadeInstrucoes +
            '}';
  }

  @Override
  public int compareTo(Processo o) {
    return Integer.compare(this.quantidadeInstrucoes, o.getQuantidadeInstrucoes());
  }
};
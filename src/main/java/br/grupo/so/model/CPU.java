package br.grupo.so.model;

import br.grupo.so.model.escalonador.RoundRobin;

public class CPU {
  Escalonador escalonador;
  Processo processo;
  int contadorCiclos;

  public CPU(Escalonador escalonador) {
    this.escalonador = escalonador;
  };

  // Loop simples para executar os processos
  public void executar() {
    do {
      if (this.processo == null) {
        this.processo = this.escalonador.proximoProcesso();
        System.out.println("Ai bebe 👻\n" + this.processo);
        System.out.println();
      }
      this.executarCiclo();
    } while (this.escalonador.temProcesso());
  };

  // Solicita novo processo ao escalonador independente do seu tipo
  private void solicitarNovoProcesso() {
    if (this.processo.getQuantidadeInstrucoes() > 0) {
      this.escalonador.adicionarProcesso(this.processo);
    };

    this.processo = this.escalonador.proximoProcesso();
  };

  // Executa o ciclo levando em consideração o numero limite
  private void executarCiclo() {
    this.processo.reduzirIntrucoes();
    System.out.println("Instrucao reduzida 📃\n" + this.processo);

    if (this.escalonador instanceof RoundRobin) {
      ((RoundRobin) this.escalonador).somarQuantum();

      if (((RoundRobin) this.escalonador).atingiuQuantum()) {
        System.out.println("Atingiu o quantum 🤔:\n"+this.processo);
        this.solicitarNovoProcesso();
      }
    }

    this.contadorCiclos++;
    if (this.processo.getQuantidadeInstrucoes() <= 0) {
      System.out.println("Acabou as instrucoes 🧑‍💻\n" + this.processo);
      this.solicitarNovoProcesso();
      this.contadorCiclos=0;
    }

    System.out.println();
  }
}
package br.grupo.so.model;

import br.grupo.so.model.escalonador.RoundRobin;

public class CPU {
  Escalonador escalonador;
  Processo processo;
  int ciclosInterrupcao;
  int contadorCiclos;

  public CPU(Escalonador escalonador, int ciclosInterrupcao) {
    this.escalonador = escalonador;
    this.ciclosInterrupcao = ciclosInterrupcao;
  };

  // Loop simples para executar os processos
  public void executar() {
    do {
      if (this.processo == null) {
        this.processo = this.escalonador.proximoProcesso();
      }
      this.executarCiclo();
    } while (this.escalonador.temProcesso());
  };

  // Solicita novo processo ao escalonador independente do seu tipo
  private void solicitarNovoProcesso() {
    if (this.processo.quantidadeInstrucoes > 0) {
      this.escalonador.adicionarProcesso(this.processo);
    }

    this.processo = this.escalonador.proximoProcesso();
  };

  // Executa o ciclo levando em consideração o numero limite
  private void executarCiclo() {
    this.processo.quantidadeInstrucoes--;

    if (this.escalonador instanceof RoundRobin) {
      ((RoundRobin) this.escalonador).somarQuantum();

      if (((RoundRobin) this.escalonador).atingiuQuantum()) {
        this.solicitarNovoProcesso();
      };
      return;
    };

    this.contadorCiclos++;
    if (this.contadorCiclos == this.ciclosInterrupcao ||
            this.processo.quantidadeInstrucoes == 0) {
      this.solicitarNovoProcesso();
      this.contadorCiclos=0;
    };
  };
};
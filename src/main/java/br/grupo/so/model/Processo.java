package br.grupo.so.model;

public class Processo {
    public int id;
    private int chegada;
    private int burst;
    private int inicio;
    private int termino;
    private int turnaround;
    private int espera;
	public int quantidadeInstrucoes;

    // Construtor
    public Processo(int id, int chegada, int burst, int quantidadeInstrucoes) {
        this.id = id;
        this.chegada = chegada;
        this.burst = burst;
        this.inicio = 0;
        this.termino = 0;
        this.turnaround = 0;
        this.espera = 0;
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

	// Getters
    public int getId() {
        return id;
    };

    public int getChegada() {
        return chegada;
    };

    public int getBurst() {
        return burst;
    };

    public int getInicio() {
        return inicio;
    };

    public int getTermino() {
        return termino;
    };

    public int getTurnaround() {
        return turnaround;
    };

    public int getEspera() {
        return espera;
    };

    public int getQuantidadeInstrucoes() {
		return quantidadeInstrucoes;
	};
    
    // Setters
    public void setInicio(int inicio) {
        this.inicio = inicio;
    };

    public void setTermino(int termino) {
        this.termino = termino;
    };

    public void setTurnaround(int turnaround) {
        this.turnaround = turnaround;
    };

    public void setEspera(int espera) {
        this.espera = espera;
    };

	public void setQuantidadeInstrucoes(int quantidadeInstrucoes) {
		this.quantidadeInstrucoes = quantidadeInstrucoes;
	};
};
package br.grupo.so.model;

public class Processo {
    public String id;
    private int chegada;
    private int burst;
    private int inicio;
    private int termino;
    private int turnaround;
    private int espera;
	public int quantidadeInstrucoes;

    // Construtor
    public Processo(String id, int chegada, int burst) {
        this.id = id;
        this.chegada = chegada;
        this.burst = burst;
        this.inicio = 0;
        this.termino = 0;
        this.turnaround = 0;
        this.espera = 0;
    }

    public Processo(int i, int quantidadeInstrucoes, int chegada2, int burst2) {
		// TODO Auto-generated constructor stub
	}

	// Getters
    public String getId() {
        return id;
    }

    public int getChegada() {
        return chegada;
    }

    public int getBurst() {
        return burst;
    }

    public int getInicio() {
        return inicio;
    }

    public int getTermino() {
        return termino;
    }

    public int getTurnaround() {
        return turnaround;
    }

    public int getEspera() {
        return espera;
    }

    // Setters
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public void setTurnaround(int turnaround) {
        this.turnaround = turnaround;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }
}
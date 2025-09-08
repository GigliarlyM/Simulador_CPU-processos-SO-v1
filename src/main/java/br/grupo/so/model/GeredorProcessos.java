package br.grupo.so.model;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
	public String quantidadeInstrucoes;

    public Processo gerarProcesso() {
        int id = random.nextInt(41);
        int quantidadeInstrucoes = 10 + random.nextInt(41);
        int chegada = random.nextInt(10);
        int burst = 1 + random.nextInt(10); 

        return new Processo(id, chegada, burst, quantidadeInstrucoes);
	};

	@Override
	public String toString() {
		return "GeredorProcessos [random=" + random + "]";
	};
};
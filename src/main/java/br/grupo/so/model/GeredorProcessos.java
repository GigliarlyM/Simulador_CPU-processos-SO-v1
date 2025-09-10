package br.grupo.so.model;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
	public String quantidadeInstrucoes;

    public Processo gerarProcesso() {
        int id = random.nextInt(41);
        int quantidadeInstrucoes = 10 + random.nextInt(41);

        return new Processo(id, quantidadeInstrucoes);
	};

	@Override
	public String toString() {
		return "GeredorProcessos [random=" + random + "]";
	};
};
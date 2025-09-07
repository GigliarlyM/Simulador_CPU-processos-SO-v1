package br.grupo.so.model;

import java.util.Random;

public class GeredorProcessos {
    private Random random = new Random();
    private int contador = 1;

    public Processo gerarProcesso() {
        String id = "P" + contador++;
        int chegada = random.nextInt(10);
        int burst = 1 + random.nextInt(10); 

        return new Processo(id, chegada, burst);
	};

	@Override
	public String toString() {
		return "GeredorProcessos [random=" + random + "]";
	};
};
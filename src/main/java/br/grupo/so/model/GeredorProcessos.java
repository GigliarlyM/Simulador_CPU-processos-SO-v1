package br.grupo.so.model;

import java.util.Random;

public class GeredorProcessos {
	static int contadorId = 1;
	
	Random random = new Random();
	
	public Processo gerarProcesso() {
		int quantidadeInstrucoes = 10 + random.nextInt(41);
        Processo processo = new Processo(contadorId++, quantidadeInstrucoes);
        return processo;
	};

	public static int getContadorId() {
		return contadorId;
	};

	public static void setContadorId(int contadorId) {
		GeredorProcessos.contadorId = contadorId;
	}

	@Override
	public String toString() {
		return "GeredorProcessos [random=" + random + "]";
	};
};
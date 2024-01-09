package view;

import java.util.concurrent.Semaphore;

import controller.ThreadRequisicoes;

public class Servidor {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int id = 1; id < 22;id++){
			Thread tRequisicoes = new ThreadRequisicoes(id, semaforo);
			tRequisicoes.start();
		}
	}
}

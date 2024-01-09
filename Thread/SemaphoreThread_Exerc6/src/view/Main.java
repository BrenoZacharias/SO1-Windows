package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorrida;

public class Main {

	public static void main(String[] args) {

		Semaphore [] semaforo = new Semaphore [9];
		semaforo [0] = new Semaphore(1); semaforo [1] = new Semaphore(1);
		semaforo [2] = new Semaphore(1); semaforo [3] = new Semaphore(1);
		semaforo [4] = new Semaphore(1); semaforo [5] = new Semaphore(1);
		semaforo [6] = new Semaphore(1); semaforo [7] = new Semaphore(1);
		semaforo [8] = new Semaphore(5);
		
		for(int escuderia = 1; escuderia <= 7; escuderia++){
			for(int piloto = 1; piloto <= 2; piloto++){
				Thread t = new ThreadCorrida(escuderia, piloto, semaforo);
				t.start();
			}
		}
	}
}

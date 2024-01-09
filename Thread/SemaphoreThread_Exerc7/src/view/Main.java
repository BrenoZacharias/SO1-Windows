package view;

import java.util.concurrent.Semaphore;

import controller.ThreadControleBanco;

public class Main {

	public static void main(String[] args) {

		Semaphore [] semaforo = new Semaphore [2];
		semaforo [0] = new Semaphore(1); semaforo [1] = new Semaphore(1);
		
		for(int i = 0; i < 20; i++){
			Thread t = new ThreadControleBanco(semaforo);
			t.start();
		}
	}
}

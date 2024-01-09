package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i <=  5;i++){
			ThreadSapo s = new ThreadSapo(i, semaforo);
			s.start();
		}
	}
}

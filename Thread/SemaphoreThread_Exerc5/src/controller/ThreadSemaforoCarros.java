package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforoCarros extends Thread{

	private String sentido;
	private int i;
	private Semaphore semaforo = new Semaphore(1);
	
	public ThreadSemaforoCarros(int i, Semaphore semaforo) {
		this.i = i;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Parada();
	}

	private void Parada() {
		try {
			semaforo.acquire();
			Sentido();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
	}

	private void Sentido() {
		switch(i){
			case 1 : 
				sentido = "Leste para Oeste";
				System.out.println("Carro passando de " + sentido);
				break;
			case 2 : 
				sentido = "Sul para Norte";
				System.out.println("Carro passando de " + sentido);
				break;
			case 3 : 
				sentido = "Oeste para Leste";
				System.out.println("Carro passando de " + sentido);
				break;
			case 4 : 
				sentido = "Norte para Sul";
				System.out.println("Carro passando de " + sentido);
				break;
		}
	}
}

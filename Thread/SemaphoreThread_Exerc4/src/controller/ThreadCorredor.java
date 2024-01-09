package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {

	private int i;
	private Semaphore semaforo;
	private final int CORREDOR = 200;
	private final int TEMPO = 1000; 
	
	public ThreadCorredor(int i, Semaphore semaforo) {
		this.i = i;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		caminhar();
		try {
			semaforo.acquire();
			cruzarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
	}

	private void caminhar() {
		int dist_percorrida = 0;
		while(dist_percorrida < CORREDOR){
			int passo = (int)(Math.random() * 2.1 ) + 4;
			dist_percorrida += passo;
			try {
				sleep(TEMPO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(dist_percorrida >= 200){
				System.out.println("Pessoa #" + i + " CRUZOU O CORREDOR. Distância percorrida: 200m");
			} else{
				System.out.println("Pessoa #" + i + " deu um passo de " + passo + "m/s. Distância percorrida: " + dist_percorrida + "m");
			}
		}
	}

	private void cruzarPorta() {
		System.out.println("Pessoa #" + i + " está CRUZANDO A PORTA");
		int cruzaPorta = (int)(Math.random() * 1001 ) + 1000;
		try {
			sleep(cruzaPorta);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pessoa #" + i + " CRUZOU A PORTA");
	}
}

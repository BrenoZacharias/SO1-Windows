package controller;

import java.util.concurrent.Semaphore;

public class ThreadSapo extends Thread{

	private int idSapo;
	private final int DISTANCIA_FINAL = 100;
	private final int MIN_PULO = 1;
	private final int MAX_PULO = 5;
	private static int posicao;
	private Semaphore semaforo;
	
	public ThreadSapo(int idSapo, Semaphore semaforo) {
		this.idSapo = idSapo;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
//		------------PARALELO----------
		pulaSapo();
//		--------INÍCIO DA SEÇÃO CRÍTICA-----------
		try {
			semaforo.acquire();
			posicaoSapo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
		
//		-----------FIM DA SEÇÃO CRÍTICA-----------
	}

	private void pulaSapo() {
		int perc = 0;
		while(perc < DISTANCIA_FINAL){
			int pulo = (int)(Math.random() * MAX_PULO) + MIN_PULO;
			perc += pulo;
			System.out.println("Sapo #" + idSapo + " pulou " + pulo + "cm. e percorreu " + perc + "cm");
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void posicaoSapo() {
		posicao++;
		System.out.println("Sapo #" + idSapo + " foi o " + posicao + " a chegar");
	}
}


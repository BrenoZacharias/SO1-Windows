package controller;

import java.util.concurrent.Semaphore;

public class ThreadRequisicoes extends Thread {

	private int id;
	private Semaphore semaforo; 
	
	public ThreadRequisicoes(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		if(id%3==1){
			int tempoCalculo = (int) (Math.random() * 801) + 200;
			int tempoTransacao = 1000;
			int contador = 2;
			Operacao(tempoCalculo, tempoTransacao, contador);
		}
		
		else if(id%3==2){
			int tempoCalculo = (int) (Math.random() * 1001) + 500;
			int tempoTransacao = 1500;
			int contador = 3;
			Operacao(tempoCalculo, tempoTransacao, contador);
		
		}
		else if(id%3==0){
			int tempoCalculo = (int) (Math.random() * 1001) + 1000;
			int tempoTransacao = 1500;
			int contador = 3;
			Operacao(tempoCalculo, tempoTransacao, contador);
		}
	}
	
	private void Operacao(int tempoCalculo, int tempoTransacao, int contador) {
		while(contador>0){
			System.out.println("Thread #" + id + " Processando ...");
			try {
				sleep(tempoCalculo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				semaforo.acquire();
				System.out.println("Thread #" + id + " Transação BD ...");
				sleep(tempoTransacao);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				semaforo.release();
			}
			contador--;
		}
	}
}

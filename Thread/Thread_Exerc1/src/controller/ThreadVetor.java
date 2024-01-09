package controller;

public class ThreadVetor extends Thread{

	private int numero;
	private int[] vetorThread = new int [1000];
	
	public ThreadVetor(int numero, int[] vetorThread) {
		this.numero = numero;
		this.vetorThread = vetorThread;
	}
	
	@Override
	public void run() {
		compara();
	}

	private void compara() {
		if(numero % 2 == 0) {
			double tempoInicial = System.nanoTime();
			for(int i = 0; i < vetorThread.length; i++) {
				
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = (tempoFinal - tempoInicial);
			tempoTotal = tempoTotal / Math.pow(10,9);
			System.out.println("TID #" + getId() + " ==> For ==> " + tempoTotal + "s. ");
		}
		else {
			double tempoInicial = System.nanoTime();
			for(int i : vetorThread) {
				
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = (tempoFinal - tempoInicial);
			tempoTotal = tempoTotal / Math.pow(10,9);
			System.out.println("TID #" + getId() + " ==> ForEach ==> " + tempoTotal + "s. ");
		}

	}
	
}

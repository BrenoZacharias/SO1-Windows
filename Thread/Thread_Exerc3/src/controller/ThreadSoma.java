package controller;

public class ThreadSoma extends Thread{
	
	private int[] vetor = new int [5];
	private int linha;
	
	public ThreadSoma(int [] matriz, int linha) {
		vetor = matriz;
		this.linha = linha;
	}
	
	@Override
	public void run() {
		soma();
	}

	private void soma() {
		int soma = 0;
		for(int i = 0; i < 5; i++) {
			 soma += vetor[i];
		}
		System.out.println("Linha " + linha + "  Soma = " + soma);
		
	}
}




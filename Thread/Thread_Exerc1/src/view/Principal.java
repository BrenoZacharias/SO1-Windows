package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		
		int[] vetorThread = new int [1000];
		for(int i = 0; i < vetorThread.length ; i++) {
			vetorThread[i] = (int) (Math.random() * 99) + 1;
		}
		
		
		for(int i = 1 ; i < 3 ; i++) {
			Thread tvetor = new ThreadVetor(i, vetorThread);
			tvetor.start();
		}
	}
}

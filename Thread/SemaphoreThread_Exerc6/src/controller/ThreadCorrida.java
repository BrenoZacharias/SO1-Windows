package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread{

	private int escuderia;
	private int piloto;
	private Semaphore semaforo[] = new Semaphore [9];
	private static int cruzouLinhaChegada;
	private static ArrayList<DadosGrid> listaGridLargada = new ArrayList<DadosGrid>();
	
	public ThreadCorrida(int escuderia, int piloto, Semaphore [] semaforo) {
		this.escuderia = escuderia;
		this.piloto = piloto;
		for(int i = 0;i <= semaforo.length - 1; i++){
			this.semaforo[i] = semaforo[i];
		}
	}
	
	@Override
	public void run() {
		Escuderia();
		if(cruzouLinhaChegada==14){
			GridDeLargada();
		}
	}

	private void Escuderia() {
		switch(escuderia){
			case 1:
				Escuderia1();
				break;
			case 2:
				Escuderia2();
				break;
			case 3:
				Escuderia3();
				break;
			case 4:
				Escuderia4();
				break;
			case 5:
				Escuderia5();
				break;
			case 6:
				Escuderia6();
				break;
			case 7:
				Escuderia7();
				break;
		}
	}

	private void Escuderia1() {
		try {
			semaforo[1].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[1].release();
		}
	}

	private void Escuderia2() {
		try {
			semaforo[2].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[2].release();
		}
	}

	private void Escuderia3() {
		try {
			semaforo[3].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[3].release();
		}
	}

	private void Escuderia4() {
		try {
			semaforo[4].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[4].release();
		}
	}

	private void Escuderia5() {
		try {
			semaforo[5].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[5].release();
		}
	}

	private void Escuderia6() {
		try {
			semaforo[6].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[6].release();
		}
	}

	private void Escuderia7() {
		try {
			semaforo[7].acquire();
			Controle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[7].release();
		}
	}
	
	private void Controle() {
		try {
			semaforo[8].acquire();
			Corrida();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			semaforo[8].release();
		}
	}
	

	private void Corrida() {
		int [] vetor = new int [3];
		for(int i = 0; i < 3; i++){
			int tempoVolta = (int)(Math.random() * 41) + 80; 
				try {
					sleep(tempoVolta);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Escuderia:" + escuderia + " Piloto:" + piloto + " Volta:" + (i + 1) + " Tempo:" + tempoVolta);
				vetor [i] = tempoVolta; 
		}
		boolean troca=true;
		int aux;
		while (troca) {
             troca = false;
             for (int c = 0; c < vetor.length - 1; c++) {
                 if (vetor[c] > vetor[c + 1]) {
                     aux = vetor[c];
                     vetor[c] = vetor[c + 1];
                     vetor[c + 1] = aux;
                     troca = true;
                 }
             }
		}
		try {
			semaforo[0].acquire();
			DadosGrid dados = new DadosGrid(escuderia, piloto, vetor[0]);
			listaGridLargada.add(dados);
			cruzouLinhaChegada++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo[0].release();
		}
	}
	
	private void GridDeLargada() {
		Collections.sort(listaGridLargada,new OrdenaPorTempo());
		System.out.println(listaGridLargada);
	}
}






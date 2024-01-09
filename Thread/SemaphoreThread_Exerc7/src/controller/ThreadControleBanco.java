package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class ThreadControleBanco extends Thread {
	
	private int codigo = (int)(Math.random() * 1000);
	private int tipo =  (((int)(Math.random() * 100) + 1) % 2);
	private double saldo = (Math.random() * 10000);
	private Semaphore semaforo [] = new Semaphore [2];
	
	DecimalFormat df = new DecimalFormat("#,###.##");
	
	public ThreadControleBanco(Semaphore [] semaforo) {
		for(int i = 0;i < 2;i++)
		this.semaforo[i] = semaforo[i];
	}
	
	@Override
	public void run() {
		pre_processamento();
	}

	private void pre_processamento() {
		double valor = 0;
		if(tipo==0){
			valor = (Math.random() * saldo);
			try {
				semaforo[0].acquire();
				ProessamentoSaque(codigo, valor, saldo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo[0].release();
			}
		}
		else {
			valor = (Math.random() * 10000);
			try {
				semaforo[1].acquire();
				ProcessamentoDeposito(codigo, valor, saldo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo[1].release();
			}
		}	
	}

	private void ProessamentoSaque(int codigo, double valor, double saldo) {
		saldo-=valor;
		System.out.println("SAQUE - código:" + codigo + "  valor sacado: R$" + df.format(valor) + "  saldo atual: R$" + df.format(saldo));
	}

	private void ProcessamentoDeposito(int codigo, double valor, double saldo) {
		saldo+=valor;
		System.out.println("DEPÓSITO - código:" + codigo + "  valor depositado: R$" + df.format(valor) + "  saldo atual: R$" + df.format(saldo));
	}
}


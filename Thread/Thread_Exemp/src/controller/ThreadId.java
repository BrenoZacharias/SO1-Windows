package controller;

//extends Thread
//Parâetros por construtor
//método run

public class ThreadId extends Thread{

	private int idThread;
	
	public  ThreadId(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		//só sexecuta o que está aqui dentro
		System.out.println(idThread);
	}
}

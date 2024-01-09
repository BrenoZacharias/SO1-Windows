package controller;

public class IdThread extends Thread{
	
	public IdThread () {
		super();
	}
	
	@Override
	public void run() {
		pegaid();
	}

	private void pegaid() {
		int id = (int) getId();
		System.out.println(id);
	}
}

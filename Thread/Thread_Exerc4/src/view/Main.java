package view;

import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {

		for(int i = 1; i <=  5;i++){
			ThreadSapo t = new ThreadSapo(i);
			t.start();
		}
	}
}

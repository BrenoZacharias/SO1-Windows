package view;

import java.io.IOException;

import controller.ArquivosControllerEx;

public class Main {

	public static void main(String[] args) {

		ArquivosControllerEx arqCont = new ArquivosControllerEx();
		String path = "C:\\TEMP";
		String nome = "generic_food.csv";
		try {
			arqCont.readFruitsOfFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosControllerEx {

	public void readFruitsOfFile(String path, String nome) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] sla = linha.split(",");
					if ((sla[2].equals("Fruits"))||(sla[2].equals("GROUP"))) {
						for (int i = 0; i < 4; i++) {
							if (i != 2) {
								System.out.print(sla[i] + "\t");
							}
						}
						System.out.println();
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				System.out.println(("Arquivo Inválido"));
			}
		} else {
			System.out.println("Diretório Inválido");
		}
	}

}

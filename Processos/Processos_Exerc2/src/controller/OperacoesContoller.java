package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class OperacoesContoller {
	
	public OperacoesContoller(){
		super();
	}

	public static String So() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void listaProcessos(String so) {
		if(so.contains("Windows")){
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null){
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(so.contains("Linux")){
			try {
				Process p = Runtime.getRuntime().exec("ps -f");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null){
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void matapPID(String so) {
		if(so.contains("Windows")){
			try {
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
				Runtime.getRuntime().exec("TASKKILL /PID " + pid);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(so.contains("Linux")){
			try {
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
				Runtime.getRuntime().exec("kill -9 " + pid);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void matapnome(String so) {
		if(so.contains("Windows")){
			try {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				Runtime.getRuntime().exec("TASKKILL /IM " + nome);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(so.contains("Linux")){
			try {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				Runtime.getRuntime().exec("pkill -f " + nome);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

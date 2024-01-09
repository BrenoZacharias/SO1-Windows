package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		super();
	}
	
	public void ip (String so){
		if(so.contains("Windows")){
			String process = "ipconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String temAdaptador = "";
				String linha = buffer.readLine();
				while(linha != null){
					if(linha.contains("Adaptador")){
						temAdaptador = linha;
					}
					if(linha.contains("IPv4")){	
							String[] vetorIPv4 = linha.split(". :");
							System.out.println(temAdaptador + vetorIPv4[1]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();			
			}
			catch(Exception e){		
				e.printStackTrace();
			}
		}
	
		if(so.contains("Linux")){
			String process = "ifconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String temAdaptador = "";
				String linha = buffer.readLine();
				while(linha != null){
					if(linha.contains("flags")){
						temAdaptador = linha;
					}
					if(linha.contains("inet ")){	
							String[] temAdaptadorAux = temAdaptador.split(" f");
							String[] vetorIPv4 = linha.split("  n");
							String[] vetorIPv4aux = vetorIPv4[0].split("t ");
							System.out.println(temAdaptadorAux[0] + vetorIPv4aux[1]);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();			
			}
			catch(Exception e){		
				e.printStackTrace();
			}
		}
	}
	
	public void ping (String so){
		if(so.contains("Windows")){
			String process = "ping -4 -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null){
					if(linha.contains("dia =")){
						String[] vetorMedia = linha.split("dia ");
						System.out.println("Media " + vetorMedia [1]);
					}
					linha = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(so.contains("Linux")){
			String process = "ping -4 -c 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null){
					if(linha.contains("avg")){
						String[] vetorMedia = linha.split("/");
						System.out.println("Media = " + vetorMedia [4] + "ms");
					}
					linha = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}

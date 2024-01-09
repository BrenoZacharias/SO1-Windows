package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.sun.imageio.spi.InputStreamImageInputStreamSpi;

public class ProcessosController {

	public ProcessosController() {
		super();
	}
	
	//Retorne o S.O. que est� em excu��o na m�quina
	public String os(){
		String os = System.getProperty("os.name");
		//pegar o nome do S.O.
		String arch = System.getProperty("os.arch");
		//pegar a arquitetura do S.O. (se � 32 ou 64 bits)
		String version = System.getProperty("os.version");
		//pega a vers�o do S.O.
		return os + " - v. " + version + " - arch. " + arch;
	}
	
	public void callProcess(String process){
		try {
			Runtime.getRuntime().exec(process);
			//para a aplica��o java chamar um novo processo
		} catch (Exception e) {
			String msgErro = e.getMessage();//pegou apenas a primeira linha do erro
//			System.err.println(msgErro);
			if (msgErro.contains("740")){
				//cmd /c caminho_do_processo
				//para virar admin
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else{
				System.err.println(msgErro);;
			}
		}
		
	}
	
	public void readProcess(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);
			//recebe os dados do processo enquanto ele est� em execu��o
			InputStream fluxo = p.getInputStream();
			//recebe o fluxo de bits (fluxo de entrada dos dados do processo)
			InputStreamReader leitor = new InputStreamReader(fluxo);
			//l� o fluxo e converte em String
			BufferedReader buffer = new BufferedReader(leitor);
			//buffer din�mico, que pode ir crescendo
			String linha = buffer.readLine();
			while(linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killProcess(String param){
		String cmdPid = "TASKKILL /PID";
		//Para matar o processo pelo PID
		String cmdNome = "TASKKILL /IM"; 
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try{
			//TASKKILL /PID XXXX
			pid = Integer.parseInt(param);
			//se for n�mero vai transformar pra int; se n�o for dar� erro de NumberFormatException
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);	
		} catch(NumberFormatException e){
			//TASKKILL /IM nomedo processo.exe
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
		
		callProcess(buffer.toString());
	}	
}

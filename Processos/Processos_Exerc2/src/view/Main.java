package view;

import javax.swing.JOptionPane;

import controller.OperacoesContoller;

public class Main {

	public static void main(String[] args) {
		OperacoesContoller oc = new OperacoesContoller();
		String so = oc.So();
		int resp = Integer.parseInt(JOptionPane.showInputDialog(" Digite:\n "
				+ "1 para Listar procesos\n 2 para Matar por PID"
				+ "\n 3 para Matar por nome"));
		switch(resp){
			case 1: 
				oc.listaProcessos(so);
				break;
				
			case 2:
				oc.matapPID(so);
				break;
				
			case 3:
				oc.matapnome(so);
				break;
			
			default:
				System.out.println("Opcao invalida");
		}
		
	}

}

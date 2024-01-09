package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redescontrol = new RedesController();
		String so = System.getProperty("os.name");
		int resp = Integer.parseInt(JOptionPane.showInputDialog(" Digite:\n"
				+ " 1 para IP \n 2 para Ping \n 3 para Finaliza"));
		switch(resp){
			case 1:
				redescontrol.ip(so);
				break;
				
			case 2:
				redescontrol.ping(so);
				break;
				
			case 3:	
				break;
				
			default:
				System.out.println("Opcao invalida");
				
		}
		
	}
	
}

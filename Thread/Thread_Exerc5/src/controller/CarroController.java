package controller;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController {

	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JButton btnCorrer;
	
	public CarroController(JLabel lblCarro1, JLabel lblCarro2, JButton btnCorrer) {
		this.btnCorrer = btnCorrer;
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
	}
	
	private void botaoCorrer(){
		Thread t1 = new ThreadCarro(lblCarro1, btnCorrer);
		Thread t2 = new ThreadCarro(lblCarro2, btnCorrer);
		t1.start();
		t2.start();
	}
	
	private void actionPerformed (ActionEvent e) {
		botaoCorrer ();

	}
}

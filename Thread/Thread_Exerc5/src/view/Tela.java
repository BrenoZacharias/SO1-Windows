package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfPerdedor;
	private JTextField tfVencedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(10, 272, 89, 23);
		contentPane.add(btnCorrer);
		
		tfPerdedor = new JTextField();
		tfPerdedor.setBounds(363, 236, 86, 20);
		contentPane.add(tfPerdedor);
		tfPerdedor.setColumns(10);
		
		tfVencedor = new JTextField();
		tfVencedor.setBounds(363, 192, 86, 20);
		contentPane.add(tfVencedor);
		tfVencedor.setColumns(10);
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setBounds(10, 121, 72, 29);
		contentPane.add(lblCarro2);
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setBounds(10, 43, 72, 23);
		contentPane.add(lblCarro1);
		
		JTextPane txtpnVencedor = new JTextPane();
		txtpnVencedor.setBackground(Color.WHITE);
		txtpnVencedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnVencedor.setText("Vencedor");
		txtpnVencedor.setBounds(296, 192, 57, 20);
		contentPane.add(txtpnVencedor);
		
		JTextPane txtpnPerdedor = new JTextPane();
		txtpnPerdedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnPerdedor.setText("Perdedor");
		txtpnPerdedor.setBounds(296, 236, 57, 20);
		contentPane.add(txtpnPerdedor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 97, 635, 2);
		contentPane.add(separator);
		
		CarroController carroController = new CarroController()
	}
}

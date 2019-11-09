import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kardex {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kardex window = new Kardex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Kardex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Registrar Nuevos productos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Reg_Producto j = new Reg_Producto();
				j.setVisible(true);
				Kardex.this.frame.dispose();
				
				
			}
		});
		btnNewButton.setBounds(117, 72, 213, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registro de ventas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
try	{
				Reg_Venta V = new Reg_Venta();
				V.setVisible(true);
				Kardex.this.frame.dispose();
				
}
catch(Exception Ex) 
{
	}
			}
		});
		btnNewButton_1.setBounds(117, 148, 213, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblSistemaKardex = new JLabel("Sistema Kardex");
		lblSistemaKardex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaKardex.setBounds(182, 28, 88, 14);
		frame.getContentPane().add(lblSistemaKardex);
	}

}

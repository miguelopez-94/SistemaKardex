import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.rpc.ServiceException;

import src.Business;
import src.BusinessServiceLocator;
import src.Item;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reg_Venta extends JFrame {

	private JPanel contentPane;
	private JTextField cant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg_Venta frame = new Reg_Venta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ServiceException 
	 * @throws RemoteException 
	 * @throws src.Exception 
	 */
	public Reg_Venta() throws ServiceException, src.Exception, RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 11, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Producto");
		lblNewLabel_1.setBounds(107, 62, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(107, 124, 46, 14);
		contentPane.add(lblCantidad);
		
		final JComboBox product = new JComboBox();
		
		BusinessServiceLocator l = new BusinessServiceLocator();
		Business port = (Business)l.getPort(Business.class);

		Item[] res = port.lista_Productos();
      
		for(Item i : res ) 
		{
			product.addItem(i.getValue());
		}
		
		product.setBounds(215, 53, 169, 20);
		contentPane.add(product);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					BusinessServiceLocator l = new BusinessServiceLocator();
					Business port = (Business)l.getPort(Business.class);
				
					Item i =(Item) product.getSelectedItem();
					
					
			       String res = port.registro_Venta(i.getValue(), cant.getText() );
			       JOptionPane.showMessageDialog(null, res);
					}
					catch(Exception f)
					{	
						 JOptionPane.showMessageDialog(null, f.getMessage());
					}
					
				
			}
		});
		btnNewButton.setBounds(197, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		cant = new JTextField();
		cant.setColumns(10);
		cant.setBounds(215, 121, 91, 20);
		contentPane.add(cant);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Kardex nuevo = new Kardex();
				nuevo.frame.setVisible(true);
				Reg_Venta.this.setVisible(false);
			}
		});
		btnVolver.setBounds(22, 28, 89, 23);
		contentPane.add(btnVolver);
		
		
	}
}

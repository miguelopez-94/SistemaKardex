import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.Business;
import src.BusinessServiceLocator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.jms.Message;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reg_Producto extends JFrame {

	private JPanel contentPane;
	private JTextField Cod;
	private JTextField nom;
	private JTextField cant;
	private JTextArea desc;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg_Producto frame = new Reg_Producto();
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
	public Reg_Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeProducto = new JLabel("Registro de Producto");
		lblRegistroDeProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeProducto.setBounds(166, 26, 125, 14);
		contentPane.add(lblRegistroDeProducto);
		
		JButton btnNewButton = new JButton("Registrar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				BusinessServiceLocator l = new BusinessServiceLocator();
				Business port = (Business)l.getPort(Business.class);
		       String res = port.registro_Producto(Cod.getText(), nom.getText(), desc.getText(), cant.getText());
		       JOptionPane.showMessageDialog(null, res);
				}
				catch(Exception e)
				{	
					 JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(166, 227, 135, 23);
		contentPane.add(btnNewButton);
		
		Cod = new JTextField();
		Cod.setBounds(226, 65, 86, 20);
		contentPane.add(Cod);
		Cod.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(226, 96, 86, 20);
		contentPane.add(nom);
		
		cant = new JTextField();
		cant.setColumns(10);
		cant.setBounds(226, 196, 86, 20);
		contentPane.add(cant);
		
		desc = new JTextArea();
		desc.setBounds(226, 129, 115, 52);
		contentPane.add(desc);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(121, 68, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(121, 99, 46, 14);
		contentPane.add(lblNombre);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(121, 134, 54, 14);
		contentPane.add(lblDescripcion);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(121, 199, 46, 14);
		contentPane.add(lblCantidad);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Kardex nuevo = new Kardex();
				nuevo.frame.setVisible(true);
				Reg_Producto.this.setVisible(false);
			}
		});
		btnVolver.setBounds(27, 22, 89, 23);
		contentPane.add(btnVolver);
	}
}

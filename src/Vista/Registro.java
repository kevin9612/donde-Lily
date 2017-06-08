package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlador.Controlador;

public class Registro extends JFrame implements ActionListener, ListSelectionListener{

	private Controlador ctrl;
	private JTextField Codigo, nombre, marca, precio, cantidad;
	private JLabel codititulo, nombretitulo, marcatitulo, preciotitulo, cantidadtitulo;
	private JList<String> list;
	private JScrollPane listaopc;
	private String [] lista={"Aceite", "Dulces", "Licor", "Bebidas energeticas", "Arroz", "Lentejas", "Gaseosa", "Lacteos", "Papas"};
	private JButton registrar, devolver;
	private String codigo, Nombre, Marca, Precio, Cantidad;
	private ImageIcon devolverimagen;
	
	
	public Registro(Controlador ctrl) {
		
		setTitle("REGISTRO");
		setSize(750, 500);
		setResizable(false);
		setLayout(null);
		this.ctrl=ctrl;
		
		Codigo= new JTextField();
		Codigo.setBounds(50, 100, 300, 20);
		
		codititulo= new JLabel("Codigo:");	
		codititulo.setBounds(50, 70, 100, 20);
		
		nombre= new JTextField();
		nombre.setBounds(50, 160, 300, 20);
		
		nombretitulo= new JLabel("Nombre:");
		nombretitulo.setBounds(50, 130, 100, 20);
		
		marca= new JTextField();
		marca.setBounds(50, 220, 300, 20);
		
		marcatitulo= new JLabel("Marca:");
		marcatitulo.setBounds(50,190, 100,20);
		
		precio= new JTextField();
		precio.setBounds(50, 280, 300, 20);
		
		preciotitulo= new JLabel("Precio:");
		preciotitulo.setBounds(50, 250, 100, 20);
		
		cantidad= new JTextField();
		cantidad.setBounds(50, 340, 300, 20);
		
		cantidadtitulo= new JLabel("Cantidad: ");
		cantidadtitulo.setBounds(50, 310, 300, 20);
		
		list= new JList<>(lista);
		list.setVisibleRowCount(9);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		listaopc= new JScrollPane(list);
		listaopc.setBounds(550, 100, 100, 190);
		getContentPane().add(listaopc);
		
		registrar= new JButton("Registrar");
		registrar.setBounds(300, 400, 100, 20);
		registrar.addActionListener(this);
		
		devolverimagen= new ImageIcon("src/Imagen/devolver.jpg");				
		devolver= new JButton("Atras");
		devolver.setIcon(devolverimagen);
		devolver.setBounds(10, 10, 110, 50);
		devolver.setOpaque(false);
	    devolver.setBorderPainted(false);
	    devolver.setContentAreaFilled(false);
		devolver.addActionListener(this);
		
		getContentPane().setBackground(new Color(110, 254, 19));
		getContentPane().add(Codigo);
		getContentPane().add(registrar);
		getContentPane().add(codititulo);
		getContentPane().add(nombre);
		getContentPane().add(nombretitulo);
		getContentPane().add(marca);
		getContentPane().add(marcatitulo);
		getContentPane().add(precio);
		getContentPane().add(preciotitulo);
		getContentPane().add(cantidad);
		getContentPane().add(cantidadtitulo);
		getContentPane().add(devolver);
		
		setVisible(true);
				
	}
	
	public void setCodigo(String codigo){Codigo.setText(codigo);}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()) {
			
			JList<String> source= (JList<String>)e.getSource();
			String select= source.getSelectedValue().toString();
			
			
			switch (select) {
			case "Aceite":
				
				ctrl.Registrar("Aceite");
				
				break;
				
			case "Dulces":
				ctrl.Registrar("Dulces");
				break;
				
			case "Licor":
				
				ctrl.Registrar("Licor");
				break;
				
			case "Bebidas energeticas":
				
				ctrl.Registrar("Bebidas energeticas");
				break;
				
			case "Arroz":
				
				ctrl.Registrar("Arroz");
				break;
	
			case "Lentejas":
				
				ctrl.Registrar("Lentejas");
				break;

			case "Gaseosa":
				
				ctrl.Registrar("Gaseosa");
				break;

			case "Lacteos":
				
				ctrl.Registrar("Lacteos");
				break;

			case "Papas":
				
				ctrl.Registrar("Papas");
				break;


			default:
				break;
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		codigo=Codigo.getText();
		Nombre=nombre.getText();
		Marca=marca.getText();
		Precio=precio.getText();
		Cantidad=cantidad.getText();
		
		String accion=e.getActionCommand();
		
		if (accion.equals("Registrar")) {
			
			JOptionPane.showMessageDialog(null, "Registrar funciona");
			try {
				ctrl.InsertarRegistro(codigo, Nombre, Marca, Precio, Cantidad);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (accion.equals("Atras")) {
			
			interfaz inte= new interfaz(ctrl);
			inte.toFront();
			dispose();
		}
		
		
	}
	
}

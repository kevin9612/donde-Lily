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

public class Factura extends JFrame implements ActionListener, ListSelectionListener{

	private Controlador ctrl;
	private JTextField Cedula, nombre, productos, total;
	private JLabel cedulaitulo, nombretitulo, productotitulos, totaltitulo;
	private JList<String> list;
	private JScrollPane listaopc;
	private String [] lista={"Aceite", "Dulces", "Licor", "Bebidas energeticas", "Arroz", "Lentejas", "Gaseosa", "Lacteos", "Papas"};
	private JButton registrar, devolver;
	private ImageIcon devolverimagen;
	
	public Factura(Controlador ctrl) {
		

		setTitle("REGISTRO");
		setSize(750, 500);
		setResizable(false);
		setLayout(null);
		this.ctrl=ctrl;
		
		Cedula= new JTextField();
		Cedula.setBounds(50, 100, 300, 20);
		
		cedulaitulo= new JLabel("Cedula:");	
		cedulaitulo.setBounds(50, 70, 100, 20);	
		
		nombre= new JTextField();
		nombre.setBounds(50, 160, 300, 20);
		
		nombretitulo= new JLabel("Nombre:");
		nombretitulo.setBounds(50, 130, 100, 20);
		
		productos= new JTextField();
		productos.setBounds(50, 220, 300, 140);
		
		productotitulos= new JLabel("Articulos:");
		productotitulos.setBounds(50,190, 100,20);
		
		total= new JTextField();		
		total.setBounds(50, 390, 300, 20);
		
		totaltitulo= new JLabel("Total: ");
		totaltitulo.setBounds(50, 370, 300, 20);
		
		list= new JList<>(lista);
		list.setVisibleRowCount(9);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		listaopc= new JScrollPane(list);
		listaopc.setBounds(550, 100, 100, 190);
		getContentPane().add(listaopc);
		
		registrar= new JButton("Facturar");
		registrar.setBounds(550, 400, 100, 20);
		registrar.addActionListener(this);
		devolverimagen= new ImageIcon("src/Imagen/devolver.jpg");
		
		devolver= new JButton("Atras");
		devolver.setIcon(devolverimagen);
		devolver.setBounds(10, 10, 110, 50);
		devolver.setOpaque(false);
	    devolver.setBorderPainted(false);
	    devolver.setContentAreaFilled(false);
		devolver.addActionListener(this);
		
		getContentPane().setBackground(new Color(60, 120, 200));
		getContentPane().add(Cedula);
		getContentPane().add(cedulaitulo);		
		getContentPane().add(nombre);
		getContentPane().add(nombretitulo);
		getContentPane().add(productos);
		getContentPane().add(productotitulos);
		getContentPane().add(total);
		getContentPane().add(registrar);
		getContentPane().add(totaltitulo);
		getContentPane().add(devolver);
		
		setVisible(true);
				
	}
	
	public void setProductos(String mensaje, String total){
		
		productos.setText(mensaje);
		this.total.setText(total);
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		JList<String> source= (JList<String>)e.getSource();
		String select= source.getSelectedValue().toString();
		
		
		switch (select) {
		case "Aceite":
			
			try {
				ctrl.estadoFactura("Aceite");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Aceite funciona");
			break;
			
		case "Dulces":
			try {
				ctrl.estadoFactura("Dulces");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Dulces funciona");
			break;
			
		case "Licor":
			try {
				ctrl.estadoFactura("Licor");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Licor funciona");
			break;
			
		case "Bebidas energeticas":
			
			try {
				ctrl.estadoFactura("Bebidas energeticas");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "Arroz":
			
			try {
				ctrl.estadoFactura("Arroz");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Lentejas":
			
			try {
				ctrl.estadoFactura("Lentejas");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Gaseosa":
			
			try {
				ctrl.estadoFactura("Gaseosa");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Lacteos":
			
			try {
				ctrl.estadoFactura("Lacteos");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "Papas":
			
			try {
				ctrl.estadoFactura("Papas");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;


		default:
			break;
		}
	}
			
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		String accion=e.getActionCommand();
		
		if (accion.equals("Facturar")) {
			try {
				ctrl.obtenerfactura(Cedula.getText(), nombre.getText(), productos.getText(), total.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} if (accion.equals("Atras")) {
			
			interfaz inte= new interfaz(ctrl);
			inte.toFront();
		}
				
	}
	
}

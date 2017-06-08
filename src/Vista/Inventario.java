package Vista;

import java.awt.Color;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;

public class Inventario extends JFrame implements ActionListener, MouseListener{

	private String [] items={"Producto...", "Aceite", "Dulces", "Licor", "Bebidas energeticas", "Arroz", "Lentejas", "Gaseosa", "Lacteos", "Papas"};
	private String [] titulos={"Aceite", "Dulces", "Licor", "Bebidas energeticas", "Arroz"};
	private String [][] matriz= new String[5][2];
	private DefaultTableModel modelo;
	private JTable datos;
	private JComboBox<String> chooser;
	private JTextField Codigo, nombre, marca, precio, cantidad;
	private JLabel codititulo, nombretitulo, marcatitulo, preciotitulo, cantidadtitulo;
	private Controlador ctrl;
	private ImageIcon devolverimagen;
	private JButton devolver, actualizar;
	
	
	public Inventario(Controlador ctrl) {
	
		setTitle("INVENTARIO");
		setSize(750, 500);
		setResizable(false);
		setLayout(null);
		this.ctrl=ctrl;		
		
		
		chooser= new JComboBox<>(items);
		chooser.setBounds(280, 50, 150, 20);
		chooser.setSelectedIndex(0);
		chooser.addActionListener(this);			
		
		
		modelo=new DefaultTableModel();
		datos= new JTable(modelo);
		
		datos.setBounds(400, 100, 300, 200);
		modelo.addColumn("ID");
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		datos.addMouseListener(this);	
		
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
		
		actualizar= new JButton("Actualizar");
		actualizar.setBounds(550, 400, 100, 20);
		actualizar.addActionListener(this);
		
		devolverimagen= new ImageIcon("src/Imagen/devolver.jpg");				
		devolver= new JButton("Atras");
		devolver.setIcon(devolverimagen);
		devolver.setBounds(10, 10, 110, 50);
		devolver.setOpaque(false);
	    devolver.setBorderPainted(false);
	    devolver.setContentAreaFilled(false);
		devolver.addActionListener(this);
		
		getContentPane().setBackground(new Color(79, 75, 140));
		getContentPane().add(chooser);
		getContentPane().add(Codigo);	
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
		getContentPane().add(datos);
		getContentPane().add(actualizar);
		
	}	
	
	public void actionPerformed(ActionEvent e) {
		
		String accion=e.getActionCommand();
		int row=datos.getRowCount();
		System.out.println(row);
		if (accion.equals("Actualizar")) {
			
			String code=Codigo.getText();
			String name=nombre.getText();
			String marc=marca.getText();
			String price=precio.getText();
			String canti=cantidad.getText();	
			
			
			try {
				ctrl.actualizar(code, name, marc,price, canti);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		for (int i = (row-1); i > 0; i--) {
			
			modelo.removeRow(i);
		}
		
		modelo.removeRow(0);
			
		}
		
		if (e.getSource()==chooser) {
						
			JComboBox<String> cb= (JComboBox<String>)e.getSource();
			String msg= (String)cb.getSelectedItem();
			
			switch (msg) {
			case "Aceite":			
				
				try {
					ctrl.ObtenerInventario("Aceite","'34ZUB'");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;
				
			case "Dulces":			
				
				try {
					ctrl.ObtenerInventario("Dulces","'25A3B'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
								
				break;
				
			case "Licor":
				
				try {
					ctrl.ObtenerInventario("Licor","'5EH91'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
				
			case "Arroz":			
				
				try {
					ctrl.ObtenerInventario("Arroz","'327R1'");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;
				
			case "Lacteos":			
				
				try {
					ctrl.ObtenerInventario("Lacteos","'45YU1'");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;	
				
			case "Bebidas energeticas":
				
				try {
					ctrl.ObtenerInventario("Bebidas energeticas","'32T41'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;	
				
			case "Lentejas":
				
				try {
					ctrl.ObtenerInventario("Lentejas","'72A41'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;	
				
			case "Gaseosa":
				
				try {
					ctrl.ObtenerInventario("Gaseosa","'45YU1'");
					System.out.println("saltamos a inventario");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
				
			
				
			case "Papas":
				
				try {
					ctrl.ObtenerInventario("Papas","'13er6'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				break;
	
					
				
			default:
				break;
			}			
			
		}
		
		if (accion.equals("Atras")) {
			
			interfaz inte= new interfaz(ctrl);
			inte.toFront();
			dispose();
		}
		
	}
	
	public void setresultado(String [] arrayList){
	
		modelo.addRow(arrayList);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row=datos.rowAtPoint(e.getPoint());
		System.out.println(row);
		Codigo.setText((String) datos.getValueAt(row, 1));
		nombre.setText((String) datos.getValueAt(row, 2));
		marca.setText((String) datos.getValueAt(row, 3));
		precio.setText((String) datos.getValueAt(row, 4));
		cantidad.setText((String) datos.getValueAt(row, 5));
		
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


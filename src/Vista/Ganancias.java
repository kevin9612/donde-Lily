package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.Controlador;

public class Ganancias extends JFrame implements ActionListener{
	
	private Controlador ctrl;
	private ImageIcon logoganancia, titulo, devolverimagen; 
	private JTextField ganancia;
	private JLabel logo, tituloo;
	private JButton devolver;
	
	public Ganancias(Controlador ctrl){
		
		setTitle("GANANCIAS");
		setSize(750, 500);
		setResizable(false);
		setLayout(null);
		this.ctrl=ctrl;
		
		logoganancia= new ImageIcon("src/Imagen/ganancia.png");
		logo= new JLabel(logoganancia);
		logo.setBounds(200, 80, 300, 300);
		
		ganancia= new JTextField();
		ganancia.setBounds(200, 350, 300, 20);
		ganancia.setEnabled(false);
		
		devolverimagen= new ImageIcon("src/Imagen/devolver.jpg");
		
		devolver= new JButton("Atras");
		devolver.setIcon(devolverimagen);
		devolver.setBounds(10, 10, 110, 50);
		devolver.setOpaque(false);
	    devolver.setBorderPainted(false);
	    devolver.setContentAreaFilled(false);
		devolver.addActionListener(this);
	    
		getContentPane().add(devolver);
		getContentPane().setBackground(new Color(234, 30, 100));
		getContentPane().add(logo);
		getContentPane().add(ganancia);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String accion= e.getActionCommand();
		
		if (accion.equals("Atras")) {
			
			interfaz inte= new interfaz(ctrl);
			inte.toFront();
			
		}
		
	}

	
	public void setTotal(String mensaje){
		
		ganancia.setText(mensaje);
	}
}

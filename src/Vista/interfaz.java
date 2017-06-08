package Vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Controlador;

public class interfaz extends JFrame{
	
	private Controlador ctrl;	
	private Panellogo logo;
	private Panelopciones opciones;
	
	public interfaz(Controlador ctrl) {

		setTitle("Donde Lily");
		setSize(750,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ctrl=ctrl;		
				
		opciones= new Panelopciones();
		opciones.setBackground(new Color(74, 86, 56));
		opciones.setBounds(0, 0, 300, 470);
		
		logo= new Panellogo();
		logo.setBackground(new Color(165, 42, 42));
		logo.setBounds(300, 0, 445, 470);
		
		getContentPane().setLayout(null);
		getContentPane().add(logo);
		getContentPane().add(opciones);
		toBack();
		setVisible(true);
		
		ctrl.conectar1(logo, opciones);

		
	}

	public static void main(String[] args) {

		interfaz inter= new interfaz(new Controlador());
		
	}

	
}

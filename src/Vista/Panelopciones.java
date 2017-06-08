package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controlador.Controlador;

public class Panelopciones extends JPanel implements ActionListener{
	
	private JButton inventario, registrar, factura, ganancia, consulta;
	private ImageIcon inevnimagen, regisimagen, factuimagen, gananimagen, consuimagen; 
	private Controlador ctrl;
	
	public Panelopciones() {		

		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder("OPCIONES") ) );
	    setLayout(new GridLayout(5, 1));
	    
	    ctrl=new Controlador();
	    inventario= new JButton("Inventario");
	    inevnimagen= new ImageIcon("src/Imagen/inventario-transparente.png");
	    inventario.setIcon(inevnimagen);
	    add(inventario);
	    inventario.setOpaque(false);
	    inventario.setBorderPainted(false);
	    inventario.setContentAreaFilled(false);
	    inventario.addActionListener(this);
	    
	    ganancia= new JButton("Ganancia");
	    gananimagen= new ImageIcon("src/Imagen/ganancia-transparente.png");
	    ganancia.setIcon(gananimagen);
	    add(ganancia);
	    ganancia.setOpaque(false);
	    ganancia.setBorderPainted(false);
	    ganancia.setContentAreaFilled(false);
	    ganancia.addActionListener(this);
	    
	    factura= new JButton("Factura");
	    factuimagen= new ImageIcon("src/Imagen/factura-transparente.png");
	    factura.setIcon(factuimagen);
	    add(factura);
	    factura.setOpaque(false);
	    factura.setBorderPainted(false);
	    factura.setContentAreaFilled(false);
	    factura.addActionListener(this);
	    
	    registrar= new JButton("Registrar");
	    regisimagen= new ImageIcon("src/Imagen/registrar-transparente.png");
	    registrar.setIcon(regisimagen);
	    add(registrar);
	    registrar.setOpaque(false);
	    registrar.setBorderPainted(false);
	    registrar.setContentAreaFilled(false);
	    registrar.addActionListener(this);
	    
	    consulta=new JButton("Consultar");
	    consuimagen= new ImageIcon("src/Imagen/consulta-transparente.png");
	    consulta.setIcon(consuimagen);
	    add(consulta);
	    consulta.setOpaque(false);
	    consulta.setBorderPainted(false);
	    consulta.setContentAreaFilled(false);
	    consulta.addActionListener(this);    
	 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String accion= e.getActionCommand();
		
		if (accion.equals("Consultar")) {
			
		
		}
		
		if (accion.equals("Registrar")) {
			
			Registro registro= new Registro(ctrl);
			ctrl.inicializarRegistro(registro);
			registro.setVisible(true);
			ctrl.ConectarBasedeDatos();
		}
		
		if (accion.equals("Factura")) {
			
			Factura fac= new Factura(ctrl);
			ctrl.inicializarFactura(fac);
			fac.setVisible(true);
			ctrl.ConectarBasedeDatos();
		}
		
		if (accion.equals("Ganancia")) {
			
			ctrl.ConectarBasedeDatos();	
			Ganancias gan = new Ganancias(ctrl);;
			ctrl.inicializarGanancia(gan);
			gan.setVisible(true);
			try {
				ctrl.ObtenerGanancia();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			
		}
		
		if (accion.equals("Inventario")) {
			
			Inventario inven= new Inventario(ctrl);
			ctrl.inicializarInventario(inven);
			inven.setVisible(true);
			ctrl.ConectarBasedeDatos();	
		}
		
		
		
		
		
		
	}

}

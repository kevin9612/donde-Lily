package Vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Panellogo extends JPanel{

	JLabel taparoja1, taparoja2, tapaazul1, tapaazul2, logo;
	ImageIcon taparo1, tapazul1, log;
	
	public Panellogo() {
		

		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder("BIENVENIDOS") ) );
	    setLayout(null);
	    
	    taparo1= new ImageIcon("src/Imagen/tapa-roja.png");
	    taparoja1= new JLabel();
	    taparoja1.setIcon(taparo1);
	    taparoja1.setBounds(10, 1, 80, 80);
	    add(taparoja1);
	    
	    taparo1= new ImageIcon("src/Imagen/tapa-roja.png");
	    taparoja2= new JLabel();
	    taparoja2.setIcon(taparo1);
	    taparoja2.setBounds(380, 390, 80, 80);
	    add(taparoja2);
	    
	    tapazul1= new ImageIcon("src/Imagen/tapa-azul.png");
	    tapaazul1= new JLabel();
	    tapaazul1.setIcon(tapazul1);
	    tapaazul1.setBounds(10, 390, 80, 80);
	    add(tapaazul1);
	    
	    tapazul1= new ImageIcon("src/Imagen/tapa-azul.png");
	    tapaazul2= new JLabel();
	    tapaazul2.setIcon(tapazul1);
	    tapaazul2.setBounds(380, 1, 80, 80);
	    add(tapaazul2);
	    
	    log= new ImageIcon("src/Imagen/logo.jpg");
	    logo= new JLabel();
	    logo.setIcon(log);
	    logo.setBounds(70, 90, 300, 300);
	    add(logo);
		
	}
	
}

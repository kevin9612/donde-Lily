package Vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import Controlador.Controlador;


public class Appvista extends JDialog
{
	 ImageIcon estegoIcon;
	    JPanel panel;
	    JProgressBar progressBar;

	    public Appvista() {
	    	
	        initGui();
	        getContentPane().add(panel);
	        setUndecorated(true);
	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	        new Thread() {
	            public void run() 
	            {
	                try {
	                    int i = 1;
	                    while(i <= 100){
	                        progressBar.setValue(i);
	                        Thread.sleep(50);
	                        i++;
	                    }
	                  new interfaz(new Controlador());
	                    dispose();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        .start();
	        setVisible(true);
	    }

	    private void initGui() {
	        panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        progressBar = new JProgressBar();
	        progressBar.setBackground(Color.WHITE);
	        progressBar.setForeground(Color.BLACK);
	        progressBar.setStringPainted(true);	        
	        estegoIcon = new ImageIcon("src/Imagen/progressbar.jpg");
	        JLabel a = new JLabel(estegoIcon);
	        panel.add(a, BorderLayout.CENTER);
	        panel.add(progressBar, BorderLayout.PAGE_END);
	    }
}

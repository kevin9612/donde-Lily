package Modelo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.JOptionPane;

import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.PingTarget;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.Statement;

import Controlador.Controlador;

public class Inventariomundo {

	
	
	private ResultSet result;
	private Controlador ctrl;
	private String[] inventario={"", "", "", "", "", ""};
	
	
	public Inventariomundo(Controlador ctrl) {
		
		this.ctrl=ctrl;
			}

	public void obtenerInventarios(String codigo, Connection conection) throws SQLException{			
		
		java.sql.Statement sta= conection.createStatement();
		String consulta="SELECT * FROM PRODUCTO WHERE CODIGO ="+codigo;		
		result=sta.executeQuery(consulta);
		
		while (result.next()) {
			
			inventario[0]=result.getString(1);
			inventario[1]=result.getString(2);
			inventario[2]=result.getString(3);
			inventario[3]=result.getString(4);
			inventario[4]=Integer.toString(result.getInt(5));
			inventario[5]=Integer.toString(result.getInt(6));
			
			ctrl.poblarTabla(inventario);
		}
		
		
		JOptionPane.showMessageDialog(null, "inventariado correctamente");
	}
	
	public void actualizar(Connection conection, String code, String name, String marc, String price, String canti) throws SQLException{
		
		PreparedStatement pnActualizar=conection.prepareStatement("UPDATE PRODUCTO SET CODIGO = '"+code+"', NOMBRE ='"+name+"', MARCA= '"+marc+"', PRECIO ='"+price+"', CANTIDAD ='"+canti+"' WHERE NOMBRE= '"+name+"'");
		pnActualizar.executeUpdate();
		System.out.println("inventario actualizado");
		
	}

	
	
}

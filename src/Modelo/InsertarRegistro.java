package Modelo;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class InsertarRegistro {

	private int pre, can;
	private java.sql.PreparedStatement preInsertar;
	
	public InsertarRegistro() {
		// TODO Auto-generated constructor stub
	}
	
	public void Insertar(String Codigo, String nombre, String marca, String precio, String Cantidad, Connection conection) throws SQLException{
		
		pre=Integer.parseInt(precio);
		can=Integer.parseInt(Cantidad);
		
		preInsertar=conection.prepareStatement("INSERT INTO PRODUCTO (CODIGO, NOMBRE, MARCA, PRECIO, CANTIDAD)"+"VALUES(?,?,?,?,?)");
		preInsertar.setString(1, Codigo);
		preInsertar.setString(2, nombre);
		preInsertar.setString(3, marca);
		preInsertar.setInt(4, pre);
		preInsertar.setInt(5,can);
		
		preInsertar.executeUpdate();
		
		System.out.println("insertado correctamente");
	}
}

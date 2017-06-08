package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarSQL {

	Connection conection;
	
	public ConectarSQL() {
		
	}
	
	
	public void Conectar(){
		

		try {
			
			System.out.println("Enlazando a la base de datos.....");
			Class.forName("com.mysql.jdbc.Driver");
			
			conection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/base de datos tienda","root","");
			System.out.println("Conexion exitosa");
		} catch (SQLException e) {

			System.out.println("Error al conectar");
			
		}
		
		catch (Exception e) {
			System.out.println("se ha encontrado un error el cual es "+e.getMessage());
		}
		
	}


	public Connection getConection() {
		return conection;
	}


	public void setConection(Connection conection) {
		this.conection = conection;
	}
		
	
}

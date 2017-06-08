package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Ganancia {

	private Statement sta;
	private int total;
	private String tota;
	
	public Ganancia() {
	
	}
	
	public void obtenerGanancias(Connection connection) throws SQLException{
		
		java.sql.Statement sta= connection.createStatement();
		String consulta="SELECT TOTAL FROM FACTURA";		
		ResultSet result = sta.executeQuery(consulta);
		
		while (result.next()) {
			
			total+=result.getInt(1);
			
		}
		
		tota=Integer.toString(total);
	}

	public String getTota() {
		return tota;
	}

	public void setTota(String tota) {
		this.tota = tota;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}

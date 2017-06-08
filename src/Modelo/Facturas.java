package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Facturas {

	private PreparedStatement almacenar, modificar;
	
	private ArrayList<String> nombres= new ArrayList<String>();
	private ArrayList<Integer> precio= new ArrayList<Integer>();
	private ArrayList<Integer> can= new ArrayList<Integer>();
	private ResultSet result;
	private String resultado, envio="", total;
	private boolean permiso;
	private int pre, cantidad, tota=0, preciouni, canuni;
	private java.sql.PreparedStatement preInsertar, pnActualizar;
	public Facturas() {	
		
		
	}
	
	public void inicializar(){
		
	envio="";
	tota=0;
	nombres.clear();
	precio.clear();
	can.clear();
	total="";
	}
	
	public void ConsultarProducto(Connection conection, String codigo) throws SQLException{
		
		permiso=false;
		resultado=JOptionPane.showInputDialog(null,"Digite el nombre de los productos");
		String [] info={"","","","","",""};
		java.sql.Statement sta= conection.createStatement();		
		result=sta.executeQuery("SELECT NOMBRE,PRECIO,CANTIDAD FROM PRODUCTO WHERE CODIGO ="+codigo);
		
		while (result.next()) {
			
			nombres.add(result.getString(1));
			precio.add(result.getInt(2));
			can.add(result.getInt(3));
			
		}
		
		for (int i = 0; i < nombres.size(); i++) {		
			
			
			System.out.println(resultado+" "+nombres.get(i));
			
			
			
			if (resultado.equals(nombres.get(i))) {
				
				envio+=" "+nombres.get(i)+" ";
				preciouni=precio.get(i);				
				canuni=can.get(i);
				permiso=true;
			}
			
			else {			
							}		
		}
		
		
		if (permiso) {
			
			cantidad=Integer.parseInt(JOptionPane.showInputDialog(null,"PRODUCTO ENCONTRADO!! \nDigite la cantidad de productos que desea comprar"));
			
						
				JOptionPane.showMessageDialog(null, "No tenemos esa catidad de producto");
				tota+=preciouni*cantidad;			
	
		}
		
		if (cantidad>canuni) {
			
			total="!!!!!!";
		}else {
			
			
			total=Integer.toString(tota);
			
		}
		
		
	}
	


	public void AlmacenarFactura(String cedula, String nombre, String articulos, String total, Connection conection) throws SQLException{
		
		if (cantidad>canuni) {
			
			JOptionPane.showMessageDialog(null, "No se puede realizar factura!!!!!!!!!!\nla cantidad deseada sobrepasa la cantidad en inventario");
		}else {
			
			
			pre=Integer.parseInt(total);		
			
			preInsertar=conection.prepareStatement("INSERT INTO FACTURA (CODIGO, NOMBRE, ARTICULO, TOTAL)"+"VALUES(?,?,?,?)");
			preInsertar.setString(1, cedula);
			preInsertar.setString(2, nombre);
			preInsertar.setString(3, articulos);
			preInsertar.setInt(4, pre);
			
			
			preInsertar.executeUpdate();
			
			System.out.println("insertado correctamente");
			
		}	
		
	}
	
	public void ActualizarBase(Connection connection) throws SQLException{
		
		if (cantidad>canuni) {
			
			JOptionPane.showMessageDialog(null, "Base de datos no actualizada");
			
		}else {
			
			
			pnActualizar= connection.prepareStatement("UPDATE PRODUCTO SET CANTIDAD = '"+(canuni-cantidad)+"' WHERE NOMBRE= '"+resultado+"'");
			pnActualizar.executeUpdate();
			
			System.out.println("actualizada con exito");
		}
		
		
	}
	
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getTota() {
		return tota;
	}

	public void setTota(int tota) {
		this.tota = tota;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	}
	


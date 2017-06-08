package Controlador;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.ConectarSQL;
import Modelo.Facturas;
import Modelo.Ganancia;
import Modelo.Inventariomundo;
import Vista.Factura;
import Vista.Ganancias;
import Vista.Inventario;
import Vista.Panellogo;
import Vista.Panelopciones;
import Vista.Registro;

public class Controlador {

	private String mensaje, can;
	private int cantidad;
	private Inventario inventario;
	private Panelopciones pnopciones;
	private Panellogo pnlogo;
	private Ganancias ganancias;
	private Factura factura;
	private Registro registro;
	private ConectarSQL sql;
	private Modelo.InsertarRegistro insertar;
	private Inventariomundo invent;
	private Facturas fac = new Facturas();
	private Ganancia ganan= new Ganancia();

	public Controlador() {
		
		sql= new ConectarSQL();
		insertar= new Modelo.InsertarRegistro();
		invent= new Inventariomundo(this);
		
	}
	
	public void conectar1(Panellogo logo, Panelopciones opciones) {
		
		this.pnopciones=opciones;
		this.pnlogo=logo;
		
	}
	
	public void inicializarInventario(Inventario inven) {
		
		this.inventario=inven;
		
	}
	
	public void inicializarFactura(Factura fac){
		
		this.factura=fac;
		
	}
	
	public void inicializarRegistro(Registro registro){
		
		this.registro=registro;
	}
	
	public void inicializarGanancia(Ganancias ganancias){
		
		this.ganancias=ganancias;
	}	
	
	public void poblarTabla(String[] vector){
		
		inventario.setresultado(vector);
	}
	
	public void ObtenerInventario(String estado, String codigo) throws SQLException {
		
		switch(estado){
	case "Aceite":
			
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Dulces":	
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;

		case "Licor":
			
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Bebidas energeticas":	
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Arroz":	
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Lentejas":
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Gaseosa":
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		case "Papas":
			invent.obtenerInventarios(codigo, sql.getConection());
			//inventario.setresultado(invent.getInfo());
			break;
			
		default:
			break;
		
		}
		
		
	}
	
	public void Registrar(String estado){
		
		
		switch(estado){
		case "Aceite":
			registro.setCodigo("34ZUB");
				
				break;
				
			case "Dulces":	
				registro.setCodigo("25A3B");
				break;

			case "Licor":
				
				registro.setCodigo("5EH91");
				break;
				
			case "Bebidas energeticas":	
				
				registro.setCodigo("32T41");
				break;
				
			case "Arroz":	
				
				registro.setCodigo("327R1");
				break;
				
			case "Lentejas":
				registro.setCodigo("72A41");
				break;
				
			case "Gaseosa":
				
				
				registro.setCodigo("45YU1");
				break;
				
			case "Papas":
				
				registro.setCodigo("13er6");
				break;
				
			default:
				break;
			
			}
		
		
	}
	
	public void estadoFactura(String estado) throws SQLException{
		
		
		switch(estado){
		case "Aceite":
			
			
			fac.ConsultarProducto(sql.getConection(),"'34ZUB'");
			
			factura.setProductos(fac.getEnvio(),fac.getTotal());
		
			
				break;
				
				
			case "Dulces":	
			
				fac.ConsultarProducto(sql.getConection(),"'25A3B'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());					
				
				break;

			case "Licor":
				
			
				fac.ConsultarProducto(sql.getConection(),"'5EH91'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
								
				break;
				
			case "Bebidas energeticas":					
				
				fac.ConsultarProducto(sql.getConection(),"'32T41'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
								
				break;
				
			case "Arroz":	
				
				fac.ConsultarProducto(sql.getConection(),"'327R1'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
							
				break;
				
			case "Lentejas":
				fac.ConsultarProducto(sql.getConection(),"'72A41'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
				
				break;
				
			case "Gaseosa":
				
				fac.ConsultarProducto(sql.getConection(),"'45YU1'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
				
				break;
				
			case "Papas":
				
				fac.ConsultarProducto(sql.getConection(),"'13er6'");
				factura.setProductos(fac.getEnvio(),fac.getTotal());
				
				break;
				
			default:
				break;
			
			}
		
		
	}
	
	
	public void ConectarBasedeDatos(){
		
		sql.Conectar();
		System.out.println(sql.getConection());
		
	}	
	
	public void InsertarRegistro(String Codigo, String nombre, String marca, String precio, String Cantidad) throws SQLException{
		
		
		insertar.Insertar(Codigo, nombre, marca, precio, Cantidad, sql.getConection());
		
	}

	public void obtenerfactura(String cedula, String nombre, String productos, String total) throws SQLException {
		
		fac.AlmacenarFactura(cedula, nombre, productos, total, sql.getConection());
		fac.ActualizarBase(sql.getConection());
		fac.inicializar();
	}
	
	public void ObtenerGanancia() throws SQLException{
		
		ganan.obtenerGanancias(sql.getConection());
		
		setTotal();
	}
	
	public void setTotal(){
		
		ganancias.setTotal(ganan.getTota());
	}

	public void actualizar(String code, String name, String marc, String price, String canti) throws SQLException {
		
		invent.actualizar(sql.getConection(), code, name, marc, price, canti);
	}
	
}

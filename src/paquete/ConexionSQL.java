package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionSQL {

	public ConexionSQL() {
	}
	
	private Connection abrirConexion(String user, String password, String baseDeDatos) {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String urlCon = "jdbc:mysql://localhost:3306/"+baseDeDatos;
			conexion = DriverManager.getConnection(urlCon, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	
	public ArrayList<ArrayList<String>> ejecutarSentencia(String sentencia) {
		
		comprobarBBDD();
		
		Connection conexion = abrirConexion("root", "admin", "baseComics");
		ResultSet resultado = null;
		
		ArrayList<ArrayList<String>> listaTuplas = new ArrayList<>();
		
		try {
			Statement stmt = conexion.createStatement();
			if (sentencia.toUpperCase().startsWith("SELECT")) {
				resultado = stmt.executeQuery(sentencia);
				ResultSetMetaData resultadoMetadata = resultado.getMetaData();
				int numeroColumnas = resultadoMetadata.getColumnCount();
				
				while (resultado.next()) {
				    ArrayList<String> tuplaActual = new ArrayList<>();
					
				    for (int i = 1; i <= numeroColumnas; i++) {
				    	tuplaActual.add(resultado.getString(i)+" ");
				    }
				    listaTuplas.add(tuplaActual);
				}
				stmt.close();
			} else {
				stmt.executeUpdate(sentencia);
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrarConexion(conexion);
		return listaTuplas;
	}
	
	private void comprobarBBDD() {
		
		Connection conexion = abrirConexion("root", "admin", "");
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet resultSet = stmt.executeQuery("SHOW DATABASES LIKE 'baseComics'");
			if (resultSet.next()) {
				System.out.println("La base de datos existe");
			} else {
				stmt.executeUpdate("CREATE DATABASE baseComics");
				stmt.execute("USE baseComics");
				stmt.executeUpdate("CREATE TABLE comicsVenom (id VARCHAR(20), titulo VARCHAR(100), descripcion TEXT, numeroDePaginas VARCHAR(10), numeroPublicacion VARCHAR(10), serie VARCHAR(50), formato VARCHAR(50), imagen TEXT)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrarConexion(conexion);
	}
	
	private void cerrarConexion(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

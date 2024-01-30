package paquete;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ManejadorComics {

	public ManejadorComics() {
		
	}
	
	public void insertarSQL(ArrayList<Comic> listaComics) {
		ConexionSQL conexionSQL = new ConexionSQL();
		
		conexionSQL.ejecutarSentencia(obtenerInsertSQL(listaComics));
			
	}
	
	public ArrayList<Comic> leerSQL() {
		
		ConexionSQL manejadorSQL = new ConexionSQL();
		
		ArrayList<Comic> listaComics = new ArrayList<>();
		
		ArrayList<ArrayList<String>> listaTuplas = manejadorSQL.ejecutarSentencia("SELECT * FROM comicsVenom");
		
		for (ArrayList<String> tupla: listaTuplas) {
			listaComics.add(new Comic(tupla.get(0).trim(),tupla.get(1).trim(),tupla.get(2).trim(),tupla.get(3).trim(),tupla.get(4).trim(),tupla.get(5).trim(),tupla.get(6).trim(),tupla.get(7).trim()));
		}
		return listaComics;
	}
	
	private String obtenerInsertSQL(ArrayList<Comic> listaComics) {
		String inicioQuery = "INSERT INTO comicsVenom (id, titulo, descripcion, numeroDePaginas, numeroPublicacion, serie, formato, imagen) VALUES ";
	    StringJoiner valuesJoiner = new StringJoiner(", ");

	    for (Comic comic : listaComics) {
	        String tupla = String.format("(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", comic.getId(), comic.getTitulo(), comic.getDescripcion(), comic.getNumeroDePaginas(), comic.getNumeroPublicacion(), comic.getSerie(), comic.getFormato(), comic.getImagen());
	        valuesJoiner.add(tupla);
	    }

	    return inicioQuery + valuesJoiner.toString();
	}
}

package paquete;

import java.util.ArrayList;

public class ManejadorUniversal {
	
	ArrayList<Comic> listaComics = new ArrayList<>();

	public ManejadorUniversal() {
	
	}
	
	public ArrayList<Comic> leerComicsSQL() {
		ArrayList<Comic> listaComics = new ArrayList<>();
		
		ConexionSQL conexion = new ConexionSQL();
		ArrayList<ArrayList<String>> listaContenidoComics = conexion.ejecutarSentencia("SELECT * FROM comicsVenom");
		
		for (ArrayList<String> contenidoComic : listaContenidoComics) {
			Comic comicLeido = new Comic(contenidoComic.get(0),contenidoComic.get(1),contenidoComic.get(2),contenidoComic.get(3),contenidoComic.get(4)
					,contenidoComic.get(5),contenidoComic.get(6),contenidoComic.get(7));
			
			listaComics.add(comicLeido);
		}
		
		return listaComics;
		
	}
	

}

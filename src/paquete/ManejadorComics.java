package paquete;

import java.io.File;
import java.util.ArrayList;
import java.util.StringJoiner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	
	public ArrayList<Comic> leerXML(String rutaArchivo) {
		ArrayList<Comic> listaComics = new ArrayList<>();
		
		Document doc = obtenerDocument(rutaArchivo);

		NodeList listaNodosComic = doc.getElementsByTagName("comic");
		
		for (int i = 0; i < listaNodosComic.getLength(); i++) {
			
			Node nodoComic = listaNodosComic.item(i);
			
			if(nodoComic.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoComic = (Element) nodoComic;
				listaComics.add(obtenerComic(elementoComic));
			}
		}
		
		return listaComics;
	}
	
	private Comic obtenerComic(Element elementoComic) {
		
		Comic comicObtenido = new Comic(comprobarContenido("id", elementoComic), comprobarContenido("titulo", elementoComic), comprobarContenido("descripcion", elementoComic), 
				comprobarContenido("numeroDePaginas", elementoComic), comprobarContenido("numeroPublicacion", elementoComic), comprobarContenido("serie", elementoComic), 
				comprobarContenido("formato", elementoComic), comprobarContenido("imagen", elementoComic));
		
		return comicObtenido;
	}
	
	private String comprobarContenido(String tagName, Element comicActual) {
		String contenido = "";
		
		if (comicActual.getElementsByTagName(tagName).getLength() > 0) {
			contenido = comicActual.getElementsByTagName(tagName).item(0).getTextContent();
		}
		return contenido;
	}
	
	public void escribirXML(ArrayList<Comic> listaComics, String ruta) {
		Document doc = obtenerDocument();
		escribirDocument(doc, listaComics);
		escribirArchivo(doc, ruta);
	}
	
	private Document obtenerDocument() {
		
		Document doc = null;
		
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  doc = dBuilder.newDocument();
			  
		} catch(Exception e) {
			  System.out.println(e.getMessage());
		
		} 
		
		return doc;
	}
	
	public Document obtenerDocument(String rutaFichero) {
		
		Document doc = null;
		
		try {
			  File file = new File(rutaFichero);
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  doc = dBuilder.parse(file);
			  
		} catch(Exception e) {
			  System.out.println(e.getMessage());
		
		} 
		
		return doc;
	}
	
	private void escribirDocument(Document doc, ArrayList<Comic> listaComics) {
		
		Element elementoRaiz = doc.createElement("comics");
		doc.appendChild(elementoRaiz);
		
		for (Comic comicActual: listaComics) {
			escribirComicXML(doc, comicActual, elementoRaiz);
		}
	}
	
	private void escribirComicXML(Document doc, Comic comicActual, Element elementoRaiz) {
		
		Element elementoComic = doc.createElement("comic");
		elementoRaiz.appendChild(elementoComic);
		
		Element elementoId = doc.createElement("id");
		elementoId.appendChild(doc.createTextNode(comicActual.getId()));
		elementoComic.appendChild(elementoId);
		
		Element elementoTitulo = doc.createElement("titulo");
		elementoTitulo.appendChild(doc.createTextNode(comicActual.getTitulo()));
		elementoComic.appendChild(elementoTitulo);
		
		Element elementoDescripcion = doc.createElement("descripcion");
		elementoDescripcion.appendChild(doc.createTextNode(comicActual.getDescripcion()));
		elementoComic.appendChild(elementoDescripcion);
		
		Element elementoNumeroDePaginas = doc.createElement("numeroDePaginas");
		elementoNumeroDePaginas.appendChild(doc.createTextNode(comicActual.getNumeroDePaginas()));
		elementoComic.appendChild(elementoNumeroDePaginas);
		
		Element elementoNumeroPublicacion = doc.createElement("numeroPublicacion");
		elementoNumeroPublicacion.appendChild(doc.createTextNode(comicActual.getNumeroPublicacion()));
		elementoComic.appendChild(elementoNumeroPublicacion);
		
		Element elementoSerie = doc.createElement("serie");
		elementoSerie.appendChild(doc.createTextNode(comicActual.getSerie()));
		elementoComic.appendChild(elementoSerie);
		
		Element elementoFormato = doc.createElement("formato");
		elementoFormato.appendChild(doc.createTextNode(comicActual.getFormato()));
		elementoComic.appendChild(elementoFormato);
		
		Element elementoImagen = doc.createElement("imagen");
		elementoImagen.appendChild(doc.createTextNode(comicActual.getImagen()));
		elementoComic.appendChild(elementoImagen);
	}
	
	private void escribirArchivo(Document doc, String rutaArchivo) {
		
		try {
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivo));

			transformer.transform(source, result);
			
			
		} catch(Exception e) {
			e.printStackTrace();
				
		}
	}
	
}

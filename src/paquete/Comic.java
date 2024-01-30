package paquete;

public class Comic {
	private String id;
	private String titulo;
	private String descripcion;
	private String numeroDePaginas;
	private String numeroPublicacion;
	private String serie;
	private String formato;
	private String imagen;
	
	public Comic(String id, String titulo, String descripcion, String numeroDePaginas, String numeroPublicacion,
			String serie, String formato, String imagen) {
		this.id = id;
		this.titulo = titulo; 
		this.descripcion = descripcion;
		this.numeroDePaginas = numeroDePaginas;
		this.numeroPublicacion = numeroPublicacion;
		this.serie = serie;
		this.formato = formato;
		this.imagen = imagen;
		
		System.out.println("Se ha creado el comic: "+titulo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(String numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getNumeroPublicacion() {
		return numeroPublicacion;
	}

	public void setNumeroPublicacion(String numeroPublicacion) {
		this.numeroPublicacion = numeroPublicacion;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}

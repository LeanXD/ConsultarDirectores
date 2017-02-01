package Beans;

public class BeansFotogramas {
	public int idFotogramas;
	public String archivo;
	public String titPelicula;
	public String anyEstreno;
	public String director;
	public String genero;
	
	public BeansFotogramas() {
	}
	
	public BeansFotogramas(int idFotogramas, String archivo, String titPelicula, String anyEstreno, String director,
			String genero) {
		this.idFotogramas = idFotogramas;
		this.archivo = archivo;
		this.titPelicula = titPelicula;
		this.anyEstreno = anyEstreno;
		this.director = director;
		this.genero = genero;
	}
	public int getIdFotogramas() {
		return idFotogramas;
	}
	public void setIdFotogramas(int idFotogramas) {
		this.idFotogramas = idFotogramas;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getTitPelicula() {
		return titPelicula;
	}
	public void setTitPelicula(String titPelicula) {
		this.titPelicula = titPelicula;
	}
	public String getAnyEstreno() {
		return anyEstreno;
	}
	public void setAnyEstreno(String anyEstreno) {
		this.anyEstreno = anyEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}

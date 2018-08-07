package Modelos;


public class Discos {
	int id;
 String urlImagen;
 String nombre;
 String artista;
 String FechaLanzamiento;
 String PaisOrigen;
 
 
 
public Discos(int id, String urlImagen, String nombre, String artista, String fechaLanzamiento, String paisOrigen) {
	super();
	this.id = id;
	this.urlImagen = urlImagen;
	this.nombre = nombre;
	this.artista = artista;
	FechaLanzamiento = fechaLanzamiento;
	PaisOrigen = paisOrigen;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUrlImagen() {
	return urlImagen;
}
public void setUrlImagen(String urlImagen) {
	this.urlImagen = urlImagen;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getArtista() {
	return artista;
}
public void setArtista(String artista) {
	this.artista = artista;
}
public String getFechaLanzamiento() {
	return FechaLanzamiento;
}
public void setFechaLanzamiento(String fechaLanzamiento) {
	FechaLanzamiento = fechaLanzamiento;
}
public String getPaisOrigen() {
	return PaisOrigen;
}
public void setPaisOrigen(String paisOrigen) {
	PaisOrigen = paisOrigen;
}
 
 
 

}



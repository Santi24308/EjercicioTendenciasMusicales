package Cancion;

import Popularidad.Popularidad;
import lombok.Getter;
import java.time.Duration;
import java.time.LocalDateTime;
import Popularidad.Normal;


@Getter
public class Cancion {
  private Popularidad popularidad;
  private String detalle;
  private int reproducciones;
  private Album album;
  private Artista artista;
  private String titulo;
  private int likes;
  private int dislikes;
  private LocalDateTime ultimaReproduccion;
  private LocalDateTime anio;

  public Cancion(String titulo, String detalle, Album album, Artista artista , LocalDateTime anio){
    this.popularidad = Normal.POPULARIDAD_NORMAL;
    this.likes =0 ;
    this.dislikes = 0;
    this.reproducciones = 0;
    this.ultimaReproduccion = null;

    this.album = album;
    this.artista = artista;
    this.titulo = titulo;
    this.anio = anio;
    this.detalle = popularidad.leyenda(this);
  }

  private void resetearAtributos(){
    this.reproducciones = 0;
    this.likes = 0;
    this.dislikes = 0;
    this.ultimaReproduccion = LocalDateTime.now();
  }

  public void cambiarPopularidad(Popularidad popularidad){
      this.popularidad = popularidad;
      //this.resetearAtributos();

    }

  private void chequearPopularidad(){

    this.popularidad.popularidadNormal(this);

    if(this.popularidad.proximaPopularidad().cumpleCondicionDePopularidad(this)) {
      this.cambiarPopularidad(this.popularidad.proximaPopularidad());
      System.out.println("La cancion " + this.titulo + " cambio a popularidad: " + this.popularidad.getNombre());
    }



  }

  public String popularidad(){
    return this.popularidad.getNombre();
  }

  public void reproducir(){
    this.reproducciones += 1;
    this.ultimaReproduccion = LocalDateTime.now();
    this.chequearPopularidad();

  }

  public void likear(){
    this.likes += 1 ;
    this.chequearPopularidad();

  }

  public void dislikear(){
    this.dislikes += 1 ;
    this.chequearPopularidad();
  }

  public String nombreArtista(){
    return this.artista.getNombre();
  }
  public String nombreAlbum(){
    return this.album.getTitulo();
  }

  public String lanzamientoAlbum(){
    return this.album.getFechaDeLanzamiento().toString();
  }

  public String titulo(){
    return this.titulo;
  }

  public Boolean reproducidaRecientemente(){
    LocalDateTime ahora = LocalDateTime.now();
    Duration duracion = Duration.between(this.ultimaReproduccion, ahora);
    return duracion.toHours() <= 24;
  }

  public String detalleCompleto() {
    return this.popularidad.leyenda(this);
  }


}

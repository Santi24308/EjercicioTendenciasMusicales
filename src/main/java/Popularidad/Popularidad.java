package Popularidad;


import Cancion.Cancion;
import Icono.Icono;
import lombok.Getter;

@Getter
public abstract class Popularidad {
  protected Icono icono ;
  public String nombre;

  protected String formatoLeyenda(Cancion cancion) {
    return cancion.nombreArtista() ;
  }

  public Boolean cumpleCondicionDePopularidad(Cancion cancion){
    return true;
  }

  public Popularidad proximaPopularidad() {
    return this;
  }

  public String leyenda(Cancion cancion) {
    return this.icono.texto() + formatoLeyenda(cancion);
  }

  public void popularidadNormal(Cancion cancion){}
}

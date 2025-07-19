package Popularidad;

import static Popularidad.EnAuge.POPULARIDAD_EN_AUGE;

import Cancion.Cancion;
import Icono.Icono;
import lombok.Getter;

@Getter
public class Normal extends Popularidad{

  public static final Normal POPULARIDAD_NORMAL = new Normal();

  public Normal(){
    this.icono = Icono.MUSICAL_NOTE;
    this.nombre = "Normal";
  }

  @Override
  public String formatoLeyenda(Cancion cancion) {
    return super.formatoLeyenda(cancion) +
        " - " + cancion.nombreAlbum() +
        " - " + cancion.titulo();
  }

  @Override
  public Popularidad proximaPopularidad() {
    return POPULARIDAD_EN_AUGE;
  }
}

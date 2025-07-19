package Popularidad;

import Cancion.Cancion;
import Icono.Icono;

public class EnTendencia extends Popularidad {
  private Integer cantidadMinimaLikes = 4;
  private  Integer cantidadMinimaReproducciones = 7;

  public static final EnTendencia POPULARIDAD_EN_TENDENCIA = new EnTendencia();

  public EnTendencia() {
    this.icono = Icono.FIRE;
    this.nombre = "Tendencia";
  }

  @Override
  public String formatoLeyenda(Cancion cancion) {
    return cancion.titulo() + " - " + cancion.nombreArtista() +
           " ( " + cancion.nombreAlbum() +
           " " + cancion.lanzamientoAlbum() + ")";
  }

  @Override
  public Boolean cumpleCondicionDePopularidad(Cancion cancion) {
    return cancion.getLikes() >= cantidadMinimaLikes && cancion.getReproducciones() >= cantidadMinimaReproducciones;
  }

  @Override
  public void popularidadNormal(Cancion cancion) {
    if (!cancion.reproducidaRecientemente()) {
      cancion.cambiarPopularidad(new Normal());
    }
  }


}

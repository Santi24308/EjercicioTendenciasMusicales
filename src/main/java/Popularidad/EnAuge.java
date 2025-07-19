package Popularidad;

import static Popularidad.EnTendencia.POPULARIDAD_EN_TENDENCIA;

import Cancion.Cancion;
import Icono.Icono;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnAuge extends Popularidad {
  private Integer cantidadReproduccionesMinimas = 3;
  private Integer cantMaxDislikesSoportados = 6;

  public static final EnAuge POPULARIDAD_EN_AUGE = new EnAuge();

  public EnAuge() {
    this.icono = Icono.ROCKET;
    this.nombre = "Auge";
  }

  @Override
  public String formatoLeyenda(Cancion cancion) {
    return super.formatoLeyenda(cancion) +
        " - " + cancion.titulo() +
        " ( " + cancion.nombreAlbum() + " " + cancion.lanzamientoAlbum() +
        " )";
  }

  @Override
  public Boolean cumpleCondicionDePopularidad(Cancion cancion) {
    return cancion.getReproducciones() >= cantidadReproduccionesMinimas;
  }

  @Override
  public void popularidadNormal(Cancion cancion) {
    if(cancion.getDislikes() >= cantMaxDislikesSoportados) cancion.cambiarPopularidad(Normal.POPULARIDAD_NORMAL);
  }

  @Override
  public Popularidad proximaPopularidad() {
    return  POPULARIDAD_EN_TENDENCIA;
  }

  }

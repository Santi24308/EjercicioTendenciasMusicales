package Cancion;

import lombok.Getter;

@Getter
public class Artista {
  private String nombre;

  public Artista(String nombre) {
    this.nombre = nombre;
  }
}

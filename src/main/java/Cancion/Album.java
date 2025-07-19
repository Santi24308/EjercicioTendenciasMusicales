package Cancion;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Album {
  private String titulo;
  private LocalDateTime fechaDeLanzamiento;

  public Album(String titulo, LocalDateTime fechaDeLanzamiento) {
    this.titulo = titulo;
    this.fechaDeLanzamiento = fechaDeLanzamiento;
  }

}



import static Popularidad.EnAuge.POPULARIDAD_EN_AUGE;
import static Popularidad.EnTendencia.POPULARIDAD_EN_TENDENCIA;
import static Popularidad.Normal.POPULARIDAD_NORMAL;

import Cancion.Artista;
import Cancion.Cancion;
import Cancion.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TendenciasTests {

  private Cancion cancion;
  private Artista artista;
  private Album album;

  @BeforeEach
  public void init() {
    this.artista = new Artista("Codplay");

    this.album= new Album("A Rush of Blood to the head" , LocalDateTime.of(2002, 1, 1, 0, 0));


    this.cancion = new Cancion("The Scientist", "un datalle que puse al pedo " , album ,artista, LocalDateTime.of(2002, 1, 1, 0, 0));


  }

  @Test
  @DisplayName("(Normal) The Scientist recién se lanza (tiene popularidad normal)")
  public void cancionMuestraDetalleDeTendenciaNormal() {
    cancion.reproducir();
    String detalle = cancion.detalleCompleto();

    Assertions.assertTrue(detalle.contains(POPULARIDAD_NORMAL.formatoLeyenda(this.cancion)));
    Assertions.assertEquals(1, this.cancion.getReproducciones());
  }

  @Test
  @DisplayName("(Normal -> Auge) The Scientist está en auge por superar el mínimo de reproducciones esperadas")
  public void cancionMuestraDetalleEnAugeTest() {
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    Assertions.assertTrue(cancion.detalleCompleto().contains(POPULARIDAD_EN_AUGE.formatoLeyenda(this.cancion)));
    Assertions.assertEquals(3, this.cancion.getReproducciones());
  }

  @Test
  @DisplayName("(Auge -> Normal) The Scientist está en auge pero vuelve a ser Normal por muchos dislikes")
  public void cancionVuelveANormalPorDislikes() {
    POPULARIDAD_EN_AUGE.setCantMaxDislikesSoportados(5);

    /** A LA TERCER REPRODUCCIÓN DEBERÍA PASAR A ESTAR EN AUGE */
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    Assertions.assertTrue(cancion.detalleCompleto().contains(POPULARIDAD_EN_AUGE.formatoLeyenda(this.cancion)));

    /** LUEGO DE RECIBIR 6 DISLIKES, VUELVE A SER NORMAL */
    cancion.dislikear();
    cancion.dislikear();
    cancion.dislikear();
    cancion.dislikear();
    cancion.dislikear();
    cancion.dislikear();

    cancion.reproducir();

    Assertions.assertTrue(cancion.detalleCompleto().contains(POPULARIDAD_NORMAL.formatoLeyenda(this.cancion)));
  }

  @Test
  @DisplayName("(Auge -> Tendencia) The Scientist es tendencia por record de reproducciones y likes")
  public void cancionMuestraDetalleEnTendenciaTest() {
    /** A LA TERCER REPRODUCCIÓN DEBERÍA PASAR A ESTAR EN AUGE */
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();

    Assertions.assertTrue(cancion.detalleCompleto().contains(POPULARIDAD_EN_AUGE.getNombre()));

    /** A LA SEPTIMA REPRODUCCIÓN (TOTAL) + 4 Likes DEBERÍA PASAR A ESTAR EN TENDENCIA */
    cancion.likear();
    cancion.likear();
    cancion.likear();
    cancion.likear();

    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();
    cancion.reproducir();


    Assertions.assertTrue(cancion.detalleCompleto().contains(POPULARIDAD_EN_TENDENCIA.formatoLeyenda(this.cancion)));
    //cancion.reproducir();

    //Assertions.assertEquals(8, this.cancion.getReproducciones());
  }

}

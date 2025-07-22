# EjercicioTendenciasMusicales
Se plantea un ejercicio programado en Java como parte de la asignatura de Diseño de Sistemas correspondiente a la carrera Ing. En Sistemas de Informacion en la UTN FRBA.


EJERCICIO: 


Tendencias musicales

En esta oportunidad la reconocida empresa de Youtube nos ha encargado la reingeniería del componente de Tendencias Musicales,
fundamental para sus dos plataformas: Youtube y Youtube Music.
En particular, nos han pedido que una canción pueda mostrar una leyenda e ícono distinto, cada vez que sea reproducida, dependiendo
de su popularidad. Sin importar cual sea la popularidad de la canción, siempre se debe mostrar un detalle que respete el siguiente
formato: icono – leyenda; donde cada ícono y leyenda será distinto para cada nivel de popularidad. Las popularidades pueden ser:
• Normal:
o Debe mostrar el ícono llamado “MUSICAL NOTE” ( )
o La leyenda que se debe mostrar debe respetar el siguiente formato: “Nombre del artista – Nombre del álbum – Título de
la canción”
o Cuando una canción supera las 1000 reproducciones en esa popularidad, pasa a considerarse que está “En auge”.
• En auge:
o Debe mostrar el ícono llamado “ROCKET” ( )
o La leyenda que se debe mostrar debe respetar el siguiente formato: “Nombre del artista – Título de la canción (Nombre
del Álbum – Año del Álbum)”
o Si la canción supera las 50 mil reproducciones en esa popularidad y tiene más de 20 mil likes será considerada que es
Tendencia.
o Si la canción tiene 5 mil dislikes, mientras esté en esta popularidad, volverá a estar en popularidad “Normal”.
• En tendencia:
o Debe mostrar el ícono llamado “FIRE” ( )
o La leyenda que se debe mostrar debe respetar el siguiente formato: “Título de la canción – Nombre del artista
(Nombre del Álbum – Año del álbum)”
o Si la canción no fue reproducida durante las últimas 24 horas, entonces volverá a ser una canción “Normal”.

Consideraciones:
• Para encontrar los sustitutos (surrogates) y/o códigos hexadecimales de los íconos, se debe utilizar la siguiente web:
https://apps.timwhitlock.info/emoji/tables/unicode
• Se puede considerar la utilización de la siguiente clase:
public class Icono {
public static Icono MUSICAL_NOTE = new Icono(new int[]{0xD83C, 0xDFB5});
public static Icono ROCKET = new Icono(new int[]{0xD83D, 0xDE80});
public static Icono FIRE = new Icono(new int[]{0xD83D, 0xDD25});
private int[] internalEncoding;
Icono(int[] internalEncoding){
this.internalEncoding = internalEncoding;
}
public String texto() {
return new String(internalEncoding, 0, internalEncoding.length);
}
}

Los casos de prueba que se deben satisfacer, mínimamente, son:
1. “The Scientist” recién se lanza (tiene popularidad normal).
2. “The Scientist” está en auge por superar el mínimo de reproducciones esperadas.
3. “The Scientist” baja del auge por tener muchos dislikes.
4. “The Scientist” es tendencia por récord de reproducciones y cantidad de personas que le gusta el tema.
5. “The Scientist” era tendencia pero vuelve a ser normal por no ser escuchada en las últimas horas.
Para todos los casos de prueba, se deben tener en cuenta los siguientes datos de prueba: “The Scientist” (canción), “Coldplay” (artista),
"A Rush of Blood to the head" (Álbum), 2002 (año del álbum y de la canción).

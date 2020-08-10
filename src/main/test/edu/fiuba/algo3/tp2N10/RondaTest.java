package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void Test01RondaAsignaCorrectamentePuntajesALosJugadores() {
        Jugador jugadorUno = new Jugador("Carmelo");
        Jugador jugadorDos = new Jugador("Gertrudis");

        List<Jugador> jugadores = Arrays.asList(jugadorUno, jugadorDos);

        Ronda ronda = new Ronda(jugadores);

        List<Integer> puntajes = Arrays.asList(1, 2);

        ronda.asignarPuntajes(puntajes);

        assertEquals(1, jugadorUno.puntaje());
        assertEquals(2, jugadorDos.puntaje());
    }

}


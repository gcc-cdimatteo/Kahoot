package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.*;

import java.util.Arrays;
import java.util.List;

public class Jugador {

    private final String nombre;
    private int totalPuntos = 0;
    private int usosDisponiblesExclusividad = 2;
    private final List<Multiplicador> multiplicadores = Arrays.asList(Multiplicador.Nulo(), Multiplicador.PorDos(), Multiplicador.PorTres());
    private Multiplicador multiplicadorActual = multiplicadores.get(0);
    private Jugador siguienteJugador;
    private boolean vaPrimero;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return nombre;
    }

    public int puntaje() {
        return totalPuntos;
    }

    public void ordenarCon(Jugador otroJugador) {
        this.siguienteJugador = otroJugador;
        vaPrimero = true;
        otroJugador.asignarSiguiente(this);
    }

    private void asignarSiguiente(Jugador otroJugador) {
        this.siguienteJugador = otroJugador;
        vaPrimero = false;
    }

    public boolean vaPrimero() {
        return vaPrimero;
    }

    public Jugador siguienteJugador() {
        return this.siguienteJugador;
    }

    public void puntuar(int puntos) {
        totalPuntos += multiplicadorActual.multiplicar(puntos);
        multiplicadorActual = multiplicadores.get(0);
    }

    public void usarMultiplicador(int valor) {
        multiplicadorActual = multiplicadores.get(valor - 1);
    }

    public void usarExclusividad() {
        usosDisponiblesExclusividad -= 1;
    }

    public boolean exclusividadDisponible() {
        return usosDisponiblesExclusividad > 0;
    }

    public boolean multiplicadorDisponible(int valor) {
        return multiplicadores.get(valor - 1).estaDisponible();
    }
}

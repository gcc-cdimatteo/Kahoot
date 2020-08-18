package edu.fiuba.algo3.tp2N10.Modelo.Puntaje;

public class PuntajePenalidad implements Puntaje {

    @Override
    public Integer puntuar(Integer aciertos, Integer errores) {
        return aciertos - errores;
    }

    @Override
    public Boolean penalidad(){
        return true;
    }
}

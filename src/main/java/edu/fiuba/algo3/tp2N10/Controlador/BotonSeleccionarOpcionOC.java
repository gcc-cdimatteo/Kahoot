package edu.fiuba.algo3.tp2N10.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class BotonSeleccionarOpcionOC implements EventHandler<ActionEvent>{
    //Label respuestaOrdenada;
    Button boton;
    Integer numeroOpcion;
    List<Integer> respuestaUsuario;

    public BotonSeleccionarOpcionOC(Button boton, Integer numeroOpcion, List<Integer> respuestaUsuario ){
        this.boton = boton;
       // this.respuestaOrdenada = respuestaOrdenada;
        this.numeroOpcion = numeroOpcion;
        this.respuestaUsuario = respuestaUsuario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //String opcion = this.boton.getText();
        this.boton.setVisible(false);
        //this.respuestaOrdenada.setText(this.respuestaOrdenada.getText() + opcion);
        this.respuestaUsuario.add(this.numeroOpcion);
    }
}
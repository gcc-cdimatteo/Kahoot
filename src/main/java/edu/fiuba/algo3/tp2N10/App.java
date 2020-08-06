package edu.fiuba.algo3.tp2N10.Vista;


import edu.fiuba.algo3.tp2N10.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class App extends Application {

    private Stage escenario;
    private Mostrable pregunta;

    public void start(Stage stage) throws Exception {
        this.escenario = stage;
        this.setup();
        this.escenario.setScene(this.escenaPregunta());
        this.escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setup(){
        this.escenario.setTitle("AlgoKahoot");
        BolsaDePreguntas bolsa = null;
        try {
            bolsa = new BolsaDePreguntas("preguntas.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Mostrable> preguntas = bolsa.getLista();
        this.pregunta = preguntas.get(0);
    }

    //Escenas
    public Scene escenaPregunta(){

        String opcionesConcatenadas = new String(); // ToDo: solo para ver que sale.
        for (String op: this.pregunta.getOpcionesPregunta()) {
            opcionesConcatenadas  += '|' + op;
        }

        Label label = new Label(this.pregunta.getEnunciadoPregunta() + "\n" + opcionesConcatenadas);
        Scene escenario = new Scene(new StackPane(label), 640, 480);
        return escenario;
    }


}
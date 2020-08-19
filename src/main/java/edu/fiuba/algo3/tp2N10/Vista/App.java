package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.FactoryPreguntas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    Stage escenario;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        this.escenario = stage;

        this.escenario.setTitle("AlgoKahoot");

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(this);
        Scene escenaJugadores = new Scene(contenedorJugadores, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this.escenario, escenaJugadores);
        Scene escenaBienvenida = new Scene(contenedorBienvenidos, 640, 480);

        this.escenario.setScene(escenaBienvenida);
        this.escenario.show();
    }

    public void jugar(String nombreUno, String nombreDos) throws IOException {
        AlgoKahoot algoKahoot = new AlgoKahoot(new FactoryPreguntas("preguntas_test.json").preguntas(), nombreUno, nombreDos);
        AlgoKahootView algoKahootView = new AlgoKahootView(algoKahoot, escenario);
        algoKahootView.mostrar();
    }
}
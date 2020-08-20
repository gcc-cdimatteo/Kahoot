package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import edu.fiuba.algo3.tp2N10.Modelo.Observer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AlgoKahootView implements Observer {
    private final Stage escenario;
    private final AlgoKahoot algoKahoot;
    private int numeroTurno = 0;

    public AlgoKahootView(AlgoKahoot algoKahoot, Stage stage) {
        this.algoKahoot = algoKahoot;
        this.escenario = stage;
        algoKahoot.addObserver(this);
    }

    public void mostrar() {
        BorderPane contenedor;

        this.numeroTurno++;
        if (algoKahoot.finalizado()) {
            contenedor = new ContenedorPodio(this.algoKahoot);
        } else if (numeroTurno % 5 == 0) {
            contenedor = new ContenedorEntreRondas(this.algoKahoot);
        } else if (numeroTurno % 2 == 0) {
            contenedor = new ContenedorPrincipal(this.algoKahoot);
        } else{
            contenedor = new ContenedorPregunta(this.algoKahoot);
        }

        this.escenario.setScene(new Scene(contenedor, 640, 480));
    }

    @Override
    public void change() {
        this.mostrar();
    }
}

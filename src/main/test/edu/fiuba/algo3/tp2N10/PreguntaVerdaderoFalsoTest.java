package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.tp2N10.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoTest {

    private String enunciado;
    private boolean respuestaCorrecta;
    private PreguntaVerdaderoFalso preguntaVF;

    public PreguntaVerdaderoFalsoTest() {
        this.enunciado = "La manzana es azul";
        this.respuestaCorrecta = false;
    }

    private void crearVerdaderoFalsoClasico() {
        this.preguntaVF = PreguntaVerdaderoFalso.Clasico(this.enunciado, this.respuestaCorrecta);
    }

    private void crearVerdaderoFalsoPenalidad() {
        this.preguntaVF = PreguntaVerdaderoFalso.Penalidad(this.enunciado, this.respuestaCorrecta);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void verdaderoFalsoClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){
        crearVerdaderoFalsoClasico();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(false);
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void verdaderoFalsoClasicoDevuelvePuntajeCorrecto() {
        crearVerdaderoFalsoClasico();
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);
        assertEquals(Arrays.asList(1, 0), this.preguntaVF.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void VerdaderoFalsoConPenalidadDevuelvePuntajeCorrecto(){
        crearVerdaderoFalsoPenalidad();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(false);
        assertEquals(Collections.singletonList(1), this.preguntaVF.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void VerdaderoFalsoPenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearVerdaderoFalsoPenalidad();
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);
        assertEquals(Arrays.asList(-1, 1), this.preguntaVF.responder(Arrays.asList(respuestaIncorrecta, respuestaCorrecta)));
    }

}
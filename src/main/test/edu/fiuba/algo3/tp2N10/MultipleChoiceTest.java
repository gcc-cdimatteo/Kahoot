package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    private MultipleChoice preguntaMCClasico;
    private MultipleChoice preguntaMCParcial;
    private MultipleChoice preguntaMCPenalidad;
    private RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
    private RespuestaMultipleChoice respuestasCorrectasTres = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasDos = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasDosRespuestasIncorrectasUno = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasTresRespuestasIncorrectasUno = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne")));
    private RespuestaMultipleChoice respuestasIncorrectasDos = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Un Citrico", "Es Carne")));

    private void crearMultipleChoiceClasico() {
        this.preguntaMCClasico = new MultipleChoice("La manzana es...", this.respuestasCorrectasTres);
    }

    private void crearMultipleChoiceParcial() {
        this.preguntaMCParcial = MultipleChoice.MultipleChoiceParcial("La manzana es...", this.respuestasCorrectasTres);
    }

    private void crearMultipleChoicePenalidad() {
        this.preguntaMCPenalidad = MultipleChoice.MultipleChoicePenalidad("La manzana es...", this.respuestasCorrectasTres);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(1), this.preguntaMCClasico.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceClasico();
        assertEquals(Arrays.asList(1, 0), this.preguntaMCClasico.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiSeRespondeIncorrectamente(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMCClasico.responder(Collections.singletonList(this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoSeEnviaLaTotalidadDeRespuestasCorrectas(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMCClasico.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMCClasico.responder(Collections.singletonList(this.respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Parcial
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceParcialPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(3), this.preguntaMCParcial.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceParcial();
        assertEquals(Arrays.asList(3, 0), this.preguntaMCParcial.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(2), this.preguntaMCParcial.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(0), this.preguntaMCParcial.responder(Collections.singletonList(this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(0), this.preguntaMCParcial.responder(Collections.singletonList(this.respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoicePenalidadPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(3), this.preguntaMCPenalidad.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoicePenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoicePenalidad();
        assertEquals(Arrays.asList(3, 2), this.preguntaMCPenalidad.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }


    @Test
    public void MultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(2), this.preguntaMCPenalidad.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(2), this.preguntaMCPenalidad.responder(Collections.singletonList(this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve0SiNoEnvioNada(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(0), this.preguntaMCPenalidad.responder(Collections.singletonList(this.respuestaVacia)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelveMenos2SiEnvioDosIncorrectas(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(-2), this.preguntaMCPenalidad.responder(Collections.singletonList(this.respuestasIncorrectasDos)));
    }

}
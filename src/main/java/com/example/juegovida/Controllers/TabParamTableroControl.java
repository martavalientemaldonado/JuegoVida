package com.example.juegovida.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class TabParamTableroControl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider SProbReproducción;

    @FXML
    private Label ProbabReproduccion;

    @FXML
    private Slider SProbClonación;

    @FXML
    private Label ProbMuerte;

    @FXML
    private Label ProbNuevoRE;

    @FXML
    private Slider SProbNuevoRE;

    @FXML
    private Slider SProbAparTesoro;

    @FXML
    private Label ProbAparTesoro;

    @FXML
    private Label ProbAparPozo;

    @FXML
    private Slider SProbAparPozo;

    @FXML
    private Slider SProbAparAgua;

    @FXML
    private Label ProbAparAgua;

    @FXML
    private Slider SProbAparMontaña;

    @FXML
    private Label ProbAparMontaña;

    @FXML
    private Slider SProbAparComida;

    @FXML
    private Label ProbAparComida;

    @FXML
    private Label ProbAparBiblioteca;

    @FXML
    private Slider SProbAparBiblioteca;

    @FXML
    private Slider STurnosPropAgua;

    @FXML
    private Slider STurnosPropComida;

    @FXML
    private Slider STurnosRestaMontaña;

    @FXML
    private Slider SPorcetajeReproTesoro;

    @FXML
    private Slider SPorcetajeClonaBiblio;

    @FXML
    private Label TurnosPropAgua;

    @FXML
    private Label TurnosPropComida;

    @FXML
    private Label TurnosRestaMontaña;

    @FXML
    private Label PorcetajeReproTesoro;

    @FXML
    private Label PorcetajeClonaBiblio;

    @FXML
    private Slider SNumColumnas;

    @FXML
    private Slider SNumFilas;

    @FXML
    private Slider STurnosVidaInd;

    @FXML
    private Slider STurnosVidaRe;

    @FXML
    private Label PorcetajeClonaBiblio1;

    @FXML
    private Label NumColumnas;

    @FXML
    private Label NumFilas;

    @FXML
    private Label TurnosVidaInd;

    @FXML
    private Label TurnosVidaRe;

    @FXML
    private Button Aceptar;
    private DatosCompartidos d;
    private Stage scene;
    private Tesoro t = new Tesoro();
    private Pozo po = new Pozo();
    private Biblioteca b = new Biblioteca();
    private Agua a = new Agua();
    private Comida c = new Comida();
    private Montaña m =  new Montaña();
    private Individuo in = new Individuo();
    private Tablero tab  = new Tablero(0,0);
    private Recurso re = new Recurso();

    @FXML
    void clickAceptar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SProbReproducción != null : "fx:id=\"SProbReproducción\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbabReproduccion != null : "fx:id=\"ProbabReproduccion\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbClonación != null : "fx:id=\"SProbClonación\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbMuerte != null : "fx:id=\"ProbMuerte\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbNuevoRE != null : "fx:id=\"ProbNuevoRE\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbNuevoRE != null : "fx:id=\"SProbNuevoRE\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparTesoro != null : "fx:id=\"SProbAparTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparTesoro != null : "fx:id=\"ProbAparTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparPozo != null : "fx:id=\"ProbAparPozo\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparPozo != null : "fx:id=\"SProbAparPozo\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparAgua != null : "fx:id=\"SProbAparAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparAgua != null : "fx:id=\"ProbAparAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparMontaña != null : "fx:id=\"SProbAparMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparMontaña != null : "fx:id=\"ProbAparMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparComida != null : "fx:id=\"SProbAparComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparComida != null : "fx:id=\"ProbAparComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparBiblioteca != null : "fx:id=\"ProbAparBiblioteca\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparBiblioteca != null : "fx:id=\"SProbAparBiblioteca\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropAgua != null : "fx:id=\"STurnosPropAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropComida != null : "fx:id=\"STurnosPropComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosRestaMontaña != null : "fx:id=\"STurnosRestaMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeReproTesoro != null : "fx:id=\"SPorcetajeReproTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeClonaBiblio != null : "fx:id=\"SPorcetajeClonaBiblio\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosPropAgua != null : "fx:id=\"TurnosPropAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosPropComida != null : "fx:id=\"TurnosPropComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosRestaMontaña != null : "fx:id=\"TurnosRestaMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert PorcetajeReproTesoro != null : "fx:id=\"PorcetajeReproTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert PorcetajeClonaBiblio != null : "fx:id=\"PorcetajeClonaBiblio\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumColumnas != null : "fx:id=\"SNumColumnas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumFilas != null : "fx:id=\"SNumFilas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaInd != null : "fx:id=\"STurnosVidaInd\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaRe != null : "fx:id=\"STurnosVidaRe\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert PorcetajeClonaBiblio1 != null : "fx:id=\"PorcetajeClonaBiblio1\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert NumColumnas != null : "fx:id=\"NumColumnas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert NumFilas != null : "fx:id=\"NumFilas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosVidaInd != null : "fx:id=\"TurnosVidaInd\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosVidaRe != null : "fx:id=\"TurnosVidaRe\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert Aceptar != null : "fx:id=\"Aceptar\" was not injected: check your FXML file 'TabDeTablero.fxml'.";

    }
    protected void updateGUIwithModelPramRE() {
        SProbNuevoRE.valueProperty().bindBidirectional(d.ProbNuevoRecursoProperty());
        SProbAparAgua.valueProperty().bindBidirectional(d.ProbAparicionAguaProperty());
        SProbAparAgua.valueProperty().bindBidirectional(d.ProbAparicionMontañaProperty());
        SProbAparMontaña.valueProperty().bindBidirectional(d.ProbAparicionPozoProperty());
        SProbAparTesoro.valueProperty().bindBidirectional(d.ProbAparicionTesoroProperty());
        SProbAparBiblioteca.valueProperty().bindBidirectional(d.ProbAparicionBibliotecaProperty());
        SProbAparComida.valueProperty().bindBidirectional(d.ProbAparicionComidaProperty());
        SProbClonación.valueProperty().bindBidirectional(d.ProbClonacionIndivProperty());
        SProbReproducción.valueProperty().bindBidirectional(d.ProbReproduccionIndivProperty());
        STurnosPropAgua.valueProperty().bindBidirectional(d.TurnosPropAguaProperty());
        STurnosRestaMontaña.valueProperty().bindBidirectional(d.TurnosPropMontProperty());
        SPorcetajeClonaBiblio.valueProperty().bindBidirectional(d.ProbClonacPropBibliProperty());
        SPorcetajeReproTesoro.valueProperty().bindBidirectional(d.ProbReproPropTesoroProperty());
        STurnosPropComida.valueProperty().bindBidirectional(d.TurnosPropComProperty());
        SNumColumnas.valueProperty().bindBidirectional(d.NumColumnasProperty());
        SNumFilas.valueProperty().bindBidirectional(d.NumFilasProperty());
        STurnosVidaInd.valueProperty().bindBidirectional(d.TrunosVidaIndivProperty());
        STurnosVidaRe.valueProperty().bindBidirectional(d.TurnosVidaRecursosProperty());
    }
    public void loadUserDataPramRE(DatosCompartidos parametrosData) {
        this.d = parametrosData;
        this.updateGUIwithModelPramRE();
    }

    public void setStage(Stage s){
        this.scene = s;
    }
}

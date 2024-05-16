package com.example.juegovida.Controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
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
    private Slider SProbClonación;

    @FXML
    private Slider SProbNuevoRE;

    @FXML
    private Slider SProbAparTesoro;

    @FXML
    private Slider SProbAparPozo;

    @FXML
    private Slider SProbAparAgua;

    @FXML
    private Slider SProbAparMontaña;

    @FXML
    private Slider SProbAparComida;

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
    private Slider SNumColumnas;

    @FXML
    private Slider SNumFilas;

    @FXML
    private Slider STurnosVidaInd;

    @FXML
    private Slider STurnosVidaRe;

    @FXML
    private Button Aceptar;

    @FXML
    private Button Restablecer;
    @FXML
    private Button Cerrar;

    protected IntegerProperty ProbReproducción = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbClonación = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbNuevoRE = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparPozo = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparComida = new SimpleIntegerProperty(0);
    protected IntegerProperty ProbAparBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty TurnosPropAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty TurnosPropComida = new SimpleIntegerProperty(0);
    protected IntegerProperty TurnosRestaMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty PorcetajeReproTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty PorcetajeClonaBiblio = new SimpleIntegerProperty(0);
    protected IntegerProperty NumColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty NumFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty TurnosVidaInd = new SimpleIntegerProperty(0);
    protected IntegerProperty TurnosVidaRe = new SimpleIntegerProperty(0);

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
    void ClickCerrar(ActionEvent event) {
        scene.close();
    }
    @FXML
    void clickRestablecer(ActionEvent event) {
        d.rollbackTabParamCasilla();
    }
    @FXML
    void clickAceptar(ActionEvent event) throws IOException {
        d.commitTabParamCasilla();
        //Cerrar pantalla
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        if (d != null) {
            this.updateGUIwithModelTabTablero();
        }
        SProbReproducción.valueProperty().bindBidirectional(ProbReproducción);
        SProbClonación.valueProperty().bindBidirectional(ProbClonación);
        SProbNuevoRE.valueProperty().bindBidirectional(ProbNuevoRE);
        SProbAparTesoro.valueProperty().bindBidirectional(ProbAparTesoro);
        SProbAparPozo.valueProperty().bindBidirectional(ProbAparPozo);
        SProbAparAgua.valueProperty().bindBidirectional(ProbAparAgua);
        SProbAparMontaña.valueProperty().bindBidirectional(ProbAparMontaña);
        SProbAparComida.valueProperty().bindBidirectional(ProbAparComida);
        SProbAparBiblioteca.valueProperty().bindBidirectional(ProbAparBiblioteca);
        STurnosPropAgua.valueProperty().bindBidirectional(TurnosPropAgua);
        STurnosPropComida.valueProperty().bindBidirectional(TurnosPropComida);
        STurnosRestaMontaña.valueProperty().bindBidirectional(TurnosRestaMontaña);
        SPorcetajeReproTesoro.valueProperty().bindBidirectional(PorcetajeReproTesoro);
        SPorcetajeClonaBiblio.valueProperty().bindBidirectional(PorcetajeClonaBiblio);
        SNumColumnas.valueProperty().bindBidirectional(NumColumnas);
        SNumFilas.valueProperty().bindBidirectional(NumFilas);
        STurnosVidaInd.valueProperty().bindBidirectional(TurnosVidaInd);
        STurnosVidaRe.valueProperty().bindBidirectional(TurnosVidaRe);
        assert SProbReproducción != null : "fx:id=\"SProbReproducción\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbClonación != null : "fx:id=\"SProbClonación\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbNuevoRE != null : "fx:id=\"SProbNuevoRE\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparTesoro != null : "fx:id=\"SProbAparTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparPozo != null : "fx:id=\"SProbAparPozo\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparAgua != null : "fx:id=\"SProbAparAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparMontaña != null : "fx:id=\"SProbAparMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparComida != null : "fx:id=\"SProbAparComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparBiblioteca != null : "fx:id=\"SProbAparBiblioteca\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropAgua != null : "fx:id=\"STurnosPropAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropComida != null : "fx:id=\"STurnosPropComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosRestaMontaña != null : "fx:id=\"STurnosRestaMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeReproTesoro != null : "fx:id=\"SPorcetajeReproTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeClonaBiblio != null : "fx:id=\"SPorcetajeClonaBiblio\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumColumnas != null : "fx:id=\"SNumColumnas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumFilas != null : "fx:id=\"SNumFilas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaInd != null : "fx:id=\"STurnosVidaInd\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaRe != null : "fx:id=\"STurnosVidaRe\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert Aceptar != null : "fx:id=\"Aceptar\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert Restablecer != null : "fx:id=\"Restablecer\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert Cerrar != null : "fx:id=\"Cerrar\" was not injected: check your FXML file 'TabDeTablero.fxml'.";

    }
    protected void updateGUIwithModelTabTablero() {
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
    public void loadUserDataTabTablero(DatosCompartidos parametrosData) {
        this.d = parametrosData;
        this.updateGUIwithModelTabTablero();
    }

    public void setStage(Stage s){
        this.scene = s;
    }



}

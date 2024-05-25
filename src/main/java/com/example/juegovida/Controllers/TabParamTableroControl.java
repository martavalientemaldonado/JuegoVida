package com.example.juegovida.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.App.BucledeControl.BucleControl;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    private Label ProbReproducción;

    @FXML
    private Label ProbClonación;

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
    private Label ProbNuevoRE;

    @FXML
    private Label ProbAparPozo;

    @FXML
    private Label ProbAparMontaña;

    @FXML
    private Label ProbAparBiblioteca;

    @FXML
    private Label ProbAparTesoro;

    @FXML
    private Label ProbAparAgua;

    @FXML
    private Label ProbAparComida;

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
    private Label PorcetajeReproTesoro;

    @FXML
    private Label TurnosPropAgua;

    @FXML
    private Label TurnosPropComida;

    @FXML
    private Label PorcetajeClonaBiblio;

    @FXML
    private Label TurnosRestaMontaña;

    @FXML
    private Slider SNumColumnas;

    @FXML
    private Slider SNumFilas;

    @FXML
    private Slider STurnosVidaInd;

    @FXML
    private Slider STurnosVidaRe;

    @FXML
    private Label TurnosVidaRe;

    @FXML
    private Label TurnosVidaInd;

    @FXML
    private Button Aceptar;

    @FXML
    private Button Restablecer;

    @FXML
    private Button Cerrar;



    protected IntegerProperty IProbReproducción = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbClonación = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbNuevoRE = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparPozo = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparComida = new SimpleIntegerProperty(0);
    protected IntegerProperty IProbAparBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty ITurnosPropAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty ITurnosPropComida = new SimpleIntegerProperty(0);
    protected IntegerProperty ITurnosRestaMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty IPorcetajeReproTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty IPorcetajeClonaBiblio = new SimpleIntegerProperty(0);
    protected IntegerProperty INumColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty INumFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty ITurnosVidaInd = new SimpleIntegerProperty(0);
    protected IntegerProperty ITurnosVidaRe = new SimpleIntegerProperty(0);

    public DatosCompartidos d;
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
        //Cerrar pantalla
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();;
    }
    @FXML
    void clickRestablecer(ActionEvent event) {
        d.rollbackTabParamCasilla();
    }
    @FXML
    void clickAceptar(ActionEvent event){
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
        SProbReproducción.valueProperty().bindBidirectional(IProbReproducción);
        ProbReproducción.textProperty().bind(IProbReproducción.asString());
        SProbClonación.valueProperty().bindBidirectional(IProbClonación);
        ProbClonación.textProperty().bind(IProbClonación.asString());
        SProbNuevoRE.valueProperty().bindBidirectional(IProbNuevoRE);
        ProbNuevoRE.textProperty().bind(IProbNuevoRE.asString());
        SProbAparTesoro.valueProperty().bindBidirectional(IProbAparTesoro);
        ProbAparTesoro.textProperty().bind(IProbAparTesoro.asString());
        SProbAparPozo.valueProperty().bindBidirectional(IProbAparPozo);
        ProbAparPozo.textProperty().bind(IProbAparPozo.asString());
        SProbAparAgua.valueProperty().bindBidirectional(IProbAparAgua);
        ProbAparAgua.textProperty().bind(IProbAparAgua.asString());
        SProbAparMontaña.valueProperty().bindBidirectional(IProbAparMontaña);
        ProbAparMontaña.textProperty().bind(IProbAparMontaña.asString());
        SProbAparComida.valueProperty().bindBidirectional(IProbAparComida);
        ProbAparComida.textProperty().bind(IProbAparComida.asString());
        SProbAparBiblioteca.valueProperty().bindBidirectional(IProbAparBiblioteca);
        ProbAparBiblioteca.textProperty().bind(IProbAparBiblioteca.asString());
        STurnosPropAgua.valueProperty().bindBidirectional(ITurnosPropAgua);
        TurnosPropAgua.textProperty().bind(ITurnosPropAgua.asString());
        STurnosPropComida.valueProperty().bindBidirectional(ITurnosPropComida);
        TurnosPropComida.textProperty().bind(ITurnosPropComida.asString());
        STurnosRestaMontaña.valueProperty().bindBidirectional(ITurnosRestaMontaña);
        TurnosRestaMontaña.textProperty().bind(ITurnosRestaMontaña.asString());
        SPorcetajeReproTesoro.valueProperty().bindBidirectional(IPorcetajeReproTesoro);
        PorcetajeReproTesoro.textProperty().bind(IPorcetajeReproTesoro.asString());
        SPorcetajeClonaBiblio.valueProperty().bindBidirectional(IPorcetajeClonaBiblio);
        PorcetajeClonaBiblio.textProperty().bind(IPorcetajeClonaBiblio.asString());

        STurnosVidaInd.valueProperty().bindBidirectional(ITurnosVidaInd);
        TurnosVidaInd.textProperty().bind(ITurnosVidaInd.asString());
        STurnosVidaRe.valueProperty().bindBidirectional(ITurnosVidaRe);
        TurnosVidaRe.textProperty().bind(ITurnosVidaRe.asString());
        assert SProbReproducción != null : "fx:id=\"SProbReproducción\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbClonación != null : "fx:id=\"SProbClonación\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbReproducción != null : "fx:id=\"ProbReproducción\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbClonación != null : "fx:id=\"ProbClonación\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbNuevoRE != null : "fx:id=\"SProbNuevoRE\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparTesoro != null : "fx:id=\"SProbAparTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparPozo != null : "fx:id=\"SProbAparPozo\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparAgua != null : "fx:id=\"SProbAparAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparMontaña != null : "fx:id=\"SProbAparMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparComida != null : "fx:id=\"SProbAparComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SProbAparBiblioteca != null : "fx:id=\"SProbAparBiblioteca\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbNuevoRE != null : "fx:id=\"ProbNuevoRE\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparPozo != null : "fx:id=\"ProbAparPozo\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparMontaña != null : "fx:id=\"ProbAparMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparBiblioteca != null : "fx:id=\"ProbAparBiblioteca\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparTesoro != null : "fx:id=\"ProbAparTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparAgua != null : "fx:id=\"ProbAparAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert ProbAparComida != null : "fx:id=\"ProbAparComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropAgua != null : "fx:id=\"STurnosPropAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosPropComida != null : "fx:id=\"STurnosPropComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosRestaMontaña != null : "fx:id=\"STurnosRestaMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeReproTesoro != null : "fx:id=\"SPorcetajeReproTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SPorcetajeClonaBiblio != null : "fx:id=\"SPorcetajeClonaBiblio\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert PorcetajeReproTesoro != null : "fx:id=\"PorcetajeReproTesoro\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosPropAgua != null : "fx:id=\"TurnosPropAgua\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosPropComida != null : "fx:id=\"TurnosPropComida\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert PorcetajeClonaBiblio != null : "fx:id=\"PorcetajeClonaBiblio\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosRestaMontaña != null : "fx:id=\"TurnosRestaMontaña\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumColumnas != null : "fx:id=\"SNumColumnas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert SNumFilas != null : "fx:id=\"SNumFilas\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaInd != null : "fx:id=\"STurnosVidaInd\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert STurnosVidaRe != null : "fx:id=\"STurnosVidaRe\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosVidaRe != null : "fx:id=\"TurnosVidaRe\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
        assert TurnosVidaInd != null : "fx:id=\"TurnosVidaInd\" was not injected: check your FXML file 'TabDeTablero.fxml'.";
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


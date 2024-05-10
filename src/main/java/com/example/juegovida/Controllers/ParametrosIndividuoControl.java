package com.example.juegovida.Controllers;

import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ResourceBundle;

public class ParametrosIndividuoControl {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView fondo;

    @FXML
    private ImageView fondoselecc;

    @FXML
    private Label lblselecc;

    @FXML
    private ImageView imslmuerte;

    @FXML
    private ImageView imslrep;

    @FXML
    private ImageView imslclon;

    @FXML
    private Slider ProbClonacion;

    @FXML
    private Slider ProbReproduccion;

    @FXML
    private Slider ProbMuerte;

    @FXML
    private ImageView immuerte;

    @FXML
    private ImageView imclon;

    @FXML
    private ImageView imrep;

    @FXML
    private Label lblmuerte;

    @FXML
    private Label lblreprod;

    @FXML
    private Label lblclonacion;

    @FXML
    private ImageView imguardar;

    @FXML
    private Label lblguardar;

    @FXML
    private Button buttonguardar;
    private DatosCompartidos d;
    private Stage scene;
    private Tesoro t = new Tesoro();
    private Pozo po = new Pozo();
    private Recurso r = new Recurso();
    private Biblioteca b = new Biblioteca();
    private Agua a = new Agua();
    private Comida c = new Comida();
    private Montaña m =  new Montaña();
    private
    @FXML
    void click(ActionEvent event) throws IOException {
        d.commitProbIndividuos();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMRECURSOS);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(),700,500); //vCarga escena
        stage.setScene(scene);
        ParamRecursosControl p= fxmlLoader.getController();
        p.loadUserDataPramRE(new DatosCompartidos(a,c,b,t,m,po,r));
        p.setStage(stage);
        stage.show();
    }
    @FXML
    void initialize() {
        assert fondo != null : "fx:id=\"fondo\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert fondoselecc != null : "fx:id=\"fondoselecc\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert lblselecc != null : "fx:id=\"lblselecc\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imslmuerte != null : "fx:id=\"imslmuerte\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imslrep != null : "fx:id=\"imslrep\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imslclon != null : "fx:id=\"imslclon\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert ProbClonacion != null : "fx:id=\"ProbClonacion\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert ProbReproduccion != null : "fx:id=\"ProbReproduccion\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert ProbMuerte != null : "fx:id=\"ProbMuerte\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert immuerte != null : "fx:id=\"immuerte\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imclon != null : "fx:id=\"imclon\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imrep != null : "fx:id=\"imrep\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert lblmuerte != null : "fx:id=\"lblmuerte\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert lblreprod != null : "fx:id=\"lblreprod\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert lblclonacion != null : "fx:id=\"lblclonacion\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert imguardar != null : "fx:id=\"imguardar\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert lblguardar != null : "fx:id=\"lblguardar\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";
        assert buttonguardar != null : "fx:id=\"buttonguardar\" was not injected: check your FXML file 'parametrosIndiv.fxml'.";

    }
    protected void updateGUIwithModelParamInd() {
        ProbClonacion.valueProperty().bindBidirectional(d.ProbClonacionIndivProperty());
        ProbMuerte.valueProperty().bindBidirectional(d.ProbMuerteIndivProperty());
        ProbReproduccion.valueProperty().bindBidirectional(d.ProbReproduccionIndivProperty());
    }
    public void loadUserDataParamInd(DatosCompartidos parametrosData) {
        this.d = parametrosData;
        this.updateGUIwithModelParamInd();
    }

    public void setStage(Stage s){
        this.scene = s;
    }
}


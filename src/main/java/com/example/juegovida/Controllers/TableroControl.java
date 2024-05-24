package com.example.juegovida.Controllers;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import com.example.juegovida.App.Tab.TabApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TableroControl {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane TabApp;
    protected Casilla casilla;
    private Individuo in;
    private Tablero t;
    private DatosCompartidos d;

    @FXML
    public void click() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMCASILLA);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene; //vCarga escena
        scene = new Scene(fxmlLoader.load(),700,500);
        stage.setScene(scene);
        ParamCasillaControl p= fxmlLoader.getController();
        p.setStage(stage);
        stage.show();
    }
    public void clickstart() throws IOException {

    }
    public void clickstop() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMCASILLA);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene; //vCarga escena
        scene = new Scene(fxmlLoader.load(),700,500);
        stage.setScene(scene);
        ParamCasillaControl p= fxmlLoader.getController();
        p.setStage(stage);
        stage.show();
    }
    public void clickps() throws IOException {


    }






    public void setStage(Stage stage) {
    }
    public void loadUserDataTabTablero(DatosCompartidos parametrosData) {
        this.d = parametrosData;
    }

    public void clickajustes() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.TABPARAMETROSTABLERO);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene; //vCarga escena
        scene = new Scene(fxmlLoader.load(),700,500);
        stage.setScene(scene);
        TabParamTableroControl p= fxmlLoader.getController();
        p.loadUserDataTabTablero(this.d);
        p.setStage(stage);
        stage.show();
    }
}

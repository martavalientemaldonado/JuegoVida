package com.example.juegovida.Controllers;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Utilities.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private GridPane TabApp;
    protected Casilla casilla;
    private Individuo in;
    private Tablero t;

    @FXML
    public void click(Casilla c) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMCASILLA);
        URL url;
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
        p.loadUserDataCasilla(c);
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


    public void setStage(Stage stage) {
    }
}

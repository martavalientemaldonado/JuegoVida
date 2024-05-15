package com.example.juegovida.Controllers;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
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
    private GridPane TableroJuego;
    protected Casilla casilla;
    private Individuo in;

    @FXML
    public void click() throws IOException {
        for (int i = 0; i < casilla.getFila(); i++) {
            for (int j = 0; j < casilla.getColumna(); j++) {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader();
                File fichero = new File(Paths.PARAMINDIV);
                URL url = null;
                try {
                    url = fichero.toURL();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
                fxmlLoader.setLocation(url); // Para encontrar donde esta
                Scene scene = new Scene(fxmlLoader.load(), 700, 500); //vCarga escena
                stage.setScene(scene);
                ParametrosIndividuoControl p = fxmlLoader.getController();
                p.loadUserDataParamInd(new DatosCompartidos(this.in));
                p.setStage(stage);
                stage.show();
            }
        }

    }

    public void setStage(Stage stage) {
    }
}
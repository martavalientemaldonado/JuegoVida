package com.example.juegovida.Controllers;

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

public class ParametrosIndividuoControl {
    @FXML
    private Button buttonguardar;

    @FXML
    private ImageView fondo;

    @FXML
    private ImageView fondoselecc;

    @FXML
    private ImageView imclon;

    @FXML
    private ImageView imguardar;

    @FXML
    private ImageView immuerte;

    @FXML
    private ImageView imrep;

    @FXML
    private ImageView imslclon;

    @FXML
    private ImageView imslmuerte;

    @FXML
    private ImageView imslrep;

    @FXML
    private Label lblclonacion;

    @FXML
    private Label lblguardar;

    @FXML
    private Label lblmuerte;

    @FXML
    private Label lblreprod;

    @FXML
    private Label lblselecc;

    @FXML
    private Slider slclon;

    @FXML
    private Slider slmuerte;

    @FXML
    private Slider slrep;

    @FXML
    void click(ActionEvent event) throws IOException {
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
        PantallaInicioControl p= fxmlLoader.getController();
        p.setStage(stage);
        stage.show();

    }


    }


package com.example.juegovida.Controllers;

import com.example.juegovida.Utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class PantallaInicioControl implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botoncargarp;

    @FXML
    private Button botonnuevap;

    @FXML
    private ImageView imbotcargarp;

    @FXML
    private ImageView imbotonnuevap;

    @FXML
    private ImageView imfondo;

    @FXML
    private Label lblcargarpart;

    @FXML
    private Label lblnuevapart;

    @FXML
    void clickcargar(ActionEvent event) {

    }

    @FXML
    void clicknueva(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMINDIV);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(ur); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(),700,500); //vCarga escena
        stage.setScene(scene);
        ParametrosIndividuoControl p= fxmlLoader.getController();
        p.setStage(stage);
        stage.show();

    }

    void setStage(Stage stage) {
    }

    @FXML
    void initialize() {
        assert botoncargarp != null : "fx:id=\"botoncargarp\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert botonnuevap != null : "fx:id=\"botonnuevap\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imbotcargarp != null : "fx:id=\"imbotcargarp\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imbotonnuevap != null : "fx:id=\"imbotonnuevap\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imfondo != null : "fx:id=\"imfondo\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert lblcargarpart != null : "fx:id=\"lblcargarpart\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert lblnuevapart != null : "fx:id=\"lblnuevapart\" was not injected: check your FXML file 'PantallaInicio.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


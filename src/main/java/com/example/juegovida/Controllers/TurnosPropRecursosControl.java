package com.example.juegovida.Controllers;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TurnosPropRecursosControl<T> {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView probnuevorecurso;

    @FXML
    private Slider TurnosAgua;

    @FXML
    private Slider Turnosomida;

    @FXML
    private Slider TurnosMontaña;

    @FXML
    private Slider TurnosTesoro;

    @FXML
    private Slider TurnosBiblioteca;

    @FXML
    private Slider TurnosPozo;
    private DatosCompartidos<T> d;

    @FXML
    void clickAceptar(ActionEvent event) throws IOException {
        d.commitProporcionaRecursos();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.DIMTURNOSVIDA);
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

    @FXML
    void clickRestablecer(ActionEvent event) {
        d.rollbackProporcionaRecursos();
    }

    @FXML
    void initialize() {
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert TurnosAgua != null : "fx:id=\"TurnosAgua\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert Turnosomida != null : "fx:id=\"Turnosomida\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert TurnosMontaña != null : "fx:id=\"TurnosMontaña\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert TurnosTesoro != null : "fx:id=\"TurnosTesoro\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert TurnosBiblioteca != null : "fx:id=\"TurnosBiblioteca\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";
        assert TurnosPozo != null : "fx:id=\"TurnosPozo\" was not injected: check your FXML file 'TurnosPropRe.fxml'.";

    }
}

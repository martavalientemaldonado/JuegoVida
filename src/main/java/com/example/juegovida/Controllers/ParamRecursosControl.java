package com.example.juegovida.Controllers;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.Utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ParamRecursosControl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView probnuevorecurso;

    @FXML
    private Slider ProbabilidadNuevoRe;

    @FXML
    private Slider ProbabilidadAgua;

    @FXML
    private Slider ProbabilidadComida;

    @FXML
    private Slider ProbabilidadMontaña;

    @FXML
    private Slider ProbabilidadTesoro;

    @FXML
    private Slider ProbabilidadBiblioteca;

    @FXML
    private Slider ProbabilidadPozo;

    @FXML
    void clickAceptar(ActionEvent event) throws IOException {
        Comida.ProbAparicion = ProbabilidadComida.getValue();
        Montaña.ProbAparicion = ProbabilidadMontaña.getValue();
        Tesoro.ProbAparicion = ProbabilidadTesoro.getValue();
        Biblioteca.ProbAparicion = ProbabilidadBiblioteca.getValue();
        Pozo.ProbAparicion = ProbabilidadPozo.getValue();
        Agua.ProbAparicion = ProbabilidadAgua.getValue();
        Recurso.ProbabilidadNuevoRE = ProbabilidadNuevoRe.getValue();
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
        p.setStage(stage);
        stage.show();
    }

    @FXML
    void clickRestablecer(ActionEvent event) {
        ProbabilidadAgua.setValue(Agua.ProbAparicion);
        ProbabilidadComida.setValue(Comida.ProbAparicion);
        ProbabilidadMontaña.setValue(Montaña.ProbAparicion);
        ProbabilidadTesoro.setValue(Tesoro.ProbAparicion);
        ProbabilidadBiblioteca.setValue(Biblioteca.ProbAparicion);
        ProbabilidadPozo.setValue(Pozo.ProbAparicion);
        ProbabilidadNuevoRe.setValue(Recurso.ProbabilidadNuevoRE);
    }

    @FXML
    void initialize() {
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadNuevoRe != null : "fx:id=\"ProbabilidadNuevoRe\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadAgua != null : "fx:id=\"ProbabilidadAgua\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadComida != null : "fx:id=\"ProbabilidadComida\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadMontaña != null : "fx:id=\"ProbabilidadMontaña\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadTesoro != null : "fx:id=\"ProbabilidadTesoro\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadBiblioteca != null : "fx:id=\"ProbabilidadBiblioteca\" was not injected: check your FXML file 'paramindiv.fxml'.";
        assert ProbabilidadPozo != null : "fx:id=\"ProbabilidadPozo\" was not injected: check your FXML file 'paramindiv.fxml'.";

    }

    public void setStage(Stage stage) {
    }
}
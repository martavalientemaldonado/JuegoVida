package com.example.juegovida.Controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

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
    void clickAceptar(ActionEvent event) {

    }

    @FXML
    void clickRestablecer(ActionEvent event) {

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
}
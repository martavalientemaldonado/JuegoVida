package com.example.juegovida.Controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TurnosPropRecursosControl {
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

    @FXML
    void clickAceptar(ActionEvent event) {

    }

    @FXML
    void clickRestablecer(ActionEvent event) {

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

package com.example.juegovida.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
public class DimyTurnosControl {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView probnuevorecurso;

    @FXML
    private Slider NumColumnas;

    @FXML
    private Slider NumFilas;

    @FXML
    private Slider TurnosVidaIndiv;

    @FXML
    private Slider TurnosVidaRecursos;

    @FXML
    void clickAceptar(ActionEvent event) {

    }

    @FXML
    void clickRestablecer(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert NumColumnas != null : "fx:id=\"NumColumnas\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert NumFilas != null : "fx:id=\"NumFilas\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert TurnosVidaIndiv != null : "fx:id=\"TurnosVidaIndiv\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert TurnosVidaRecursos != null : "fx:id=\"TurnosVidaRecursos\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";

    }
}

package com.example.juegovida.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.DatosCompartidos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DimyTurnosControl{
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
    private DatosCompartidos d;
    private Stage scene;

    @FXML
    void clickAceptar(ActionEvent event) {
        d.commitDimyVida();


        //Cerrar pantalla
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void clickRestablecer(ActionEvent event) {
        d.rollbackDimyVida();
    }

    @FXML
    void initialize() {
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert NumColumnas != null : "fx:id=\"NumColumnas\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert NumFilas != null : "fx:id=\"NumFilas\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert TurnosVidaIndiv != null : "fx:id=\"TurnosVidaIndiv\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";
        assert TurnosVidaRecursos != null : "fx:id=\"TurnosVidaRecursos\" was not injected: check your FXML file 'DimyTurnosVida.fxml'.";

    }
    protected void updateGUIwithModelDimyNumTurn() {
        NumColumnas.valueProperty().bindBidirectional(d.NumColumnasProperty());
        NumFilas.valueProperty().bindBidirectional(d.NumFilasProperty());
        TurnosVidaIndiv.valueProperty().bindBidirectional(d.TrunosVidaIndivProperty());
        TurnosVidaRecursos.valueProperty().bindBidirectional(d.TurnosVidaRecursosProperty());
    }
    public void loadUserDataDimyNumTurn(DatosCompartidos parametrosData) {
        this.d = parametrosData;
        this.updateGUIwithModelDimyNumTurn();
    }

    public void setStage(Stage s){
        this.scene = s;
    }
}

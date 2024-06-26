package com.example.juegovida.Controllers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.App.BucledeControl.BucleControl;
import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.TabApp;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private DatosCompartidos d;
    private Stage scene;

    @FXML
    void clickAceptar(ActionEvent event) throws Exception {
        d.commitDimyVida();
        System.out.println(d.ProbAparicionAguaProperty());

        // Crear y mostrar la primera ventana
        Stage stage = new Stage();
        TabApp t = new TabApp();
        t.loaddata(d);
        Scene scene = new Scene(t.Tablero(d.getMatriz()), 1200, 700); //vCarga escena
        stage.setScene(scene);
        stage.show();
        // Cerrar la pantalla anterior
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

    public void setStage(Stage s) {
        this.scene = s;
    }
}
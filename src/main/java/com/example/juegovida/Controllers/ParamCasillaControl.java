package com.example.juegovida.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ParamCasillaControl{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label NuevoRe;

    @FXML
    private Label NuevoIndiv;

    @FXML
    private ImageView probnuevorecurso;

    @FXML
    private ChoiceBox<String> NuevoInd;

    @FXML
    private ChoiceBox<String> NuevoRecurso;
    private String[] ind = {"Normal", "Común", "Avanzado"};

    @FXML
    void clickAceptar(ActionEvent event) {
        //Tanto NuevoInd como NuevoRe
    }

    @FXML
    void initialize() {
        NuevoInd.getItems().addAll("Básico", "Normal", "Avanzado");
        NuevoInd.setOnAction(this::getIndividuo);
        NuevoRecurso.getItems().addAll("Pozo", "Agua", "Tesoro", "Biblioteca", "Montaña", "Comida");
        NuevoRecurso.setOnAction(this::getRecurso);
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
        assert NuevoInd != null : "fx:id=\"NuevoInd\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
        assert NuevoRecurso != null : "fx:id=\"NuevoRecurso\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
    }
    public void getIndividuo(ActionEvent event){
        String Ind = NuevoInd.getValue();
        NuevoIndiv.setText(Ind);
    }
    public void getRecurso(ActionEvent event){
        String Re = NuevoRecurso.getValue();
        NuevoRe.setText(Re);
    }

    public void setStage(Stage stage) {
    }
}

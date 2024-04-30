package com.example.juegovida.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class BienvenidaControl implements Initializable {
private Stage stage;
public void setStage(Stage s){
    this.stage=s;
}
    @FXML
    private AnchorPane PARALELLE;

    @FXML
    private Label lblbienv;

    @FXML
    void click(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


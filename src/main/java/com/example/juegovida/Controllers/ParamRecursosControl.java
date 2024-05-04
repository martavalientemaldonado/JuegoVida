package com.example.juegovida.Controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ParamRecursosControl {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button lnlbutton;

    @FXML
    void click(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert lnlbutton != null : "fx:id=\"lnlbutton\" was not injected: check your FXML file 'paramindiv.fxml'.";

    }

}


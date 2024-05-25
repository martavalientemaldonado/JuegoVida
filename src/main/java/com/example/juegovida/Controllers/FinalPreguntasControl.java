package com.example.juegovida.Controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.juegovida.App.Tab.TabApp;

import com.example.juegovida.App.Tab.Tablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static com.example.juegovida.Controllers.PantallaInicioControl.logger;


public class FinalPreguntasControl {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;
        private Tablero t;
        @FXML
        private Button buttonguargar;

        @FXML
        void guardarclick(ActionEvent event) {
            logger.info("Guardando partida en archivo...");
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar partida");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
            File archivoSeleccionado = fileChooser.showSaveDialog(new Stage());
            if (archivoSeleccionado != null) {
                this.t.guardar(this.t);
                logger.info("Partida guardada exitosamente en el archivo: " + archivoSeleccionado.getAbsolutePath());

                logger.error("Error al guardar la partida en el archivo: " + archivoSeleccionado.getAbsolutePath());
            } else {
                logger.warn("No se seleccionó ningún archivo para guardar la partida.");
            }
        }




    @FXML
        void initialize() {
            assert buttonguargar != null : "fx:id=\"buttonguargar\" was not injected: check your FXML file 'FinalPreguntas.fxml'.";

        }


    public void loaddata(Tablero t){
        this.t=t;}
}



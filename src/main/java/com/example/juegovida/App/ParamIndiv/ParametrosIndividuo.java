package com.example.juegovida.App.ParamIndiv;
import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class ParametrosIndividuo extends Application {

    public static void main(String[] args) {
        launch(args); //LLama a start

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.BIENVENIDA);//Carga scene en stage
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.<Parent>load(),700,500); //vCarga escena
        stage.setScene(scene);
        BienvenidaControl p= fxmlLoader.getController(); // Le pasas tu escena
        p.setStage(stage);
        stage.show();

    }

    }




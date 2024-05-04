package com.example.juegovida.App;

import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Utilities.Paths;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static javafx.application.Application.launch;

public class PantallaInicio {

    public static void main(String[] args) {
        launch();

    }
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PANTALLAINICIO);//Carga scene en stage
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(),700,500); //vCarga escena
        stage.setScene(scene);
        BienvenidaControl p= fxmlLoader.getController(); // Le pasas tu escena
        p.setStage(stage);
        stage.show();

    }




}

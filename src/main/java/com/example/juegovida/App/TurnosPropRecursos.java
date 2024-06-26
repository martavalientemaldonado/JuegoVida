package com.example.juegovida.App;

import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TurnosPropRecursos extends Application {
    private Stage stage;
    public static void main(String[] args) {
        launch(args); //LLama a start

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.TURNOSPROBREC);//Carga scene en stage

        URL url;
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

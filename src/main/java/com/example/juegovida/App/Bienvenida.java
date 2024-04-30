package com.example.juegovida.App;
import com.example.juegovida.Controllers.BienvenidaControl;

import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Bienvenida extends Application {
    public static void main(String[] args) {
        launch(); //LLama a start

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
        fxmlLoader.setLocation(url);
        Scene scene = new Scene(fxmlLoader.load(),450,500);
        stage.setScene(scene);
        BienvenidaControl p= fxmlLoader.getController();
        p.setStage(stage);
        stage.show();

    }
}

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

public class DimensionesyTurnosVida extends Application {

    private Stage stage;
    public static void main(String[] args) {
        launch(args); //LLama a start

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage.setResizable(false);
    }

    private void setStage(Stage stage) {
    }
}

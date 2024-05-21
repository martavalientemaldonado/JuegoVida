package com.example.juegovida.App;

import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TabParamTablero extends Application {
    private Stage stage;
    public static void main(String[] args) {
        launch(args); //LLama a start

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Bienvenida.class.getResource("TabDeTablero.fxml"));
        File fichero = new File(Paths.TABPARAMETROSTABLERO);//Carga scene en stage

        URL url;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

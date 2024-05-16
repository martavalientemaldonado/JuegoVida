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
        FXMLLoader fxmlLoader = new FXMLLoader(TabParamTablero.class.getResource("TabDeTablero.fxml"));
        File fichero = new File(Paths.TABPARAMETROSTABLERO);//Carga scene en stage
        URL url;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,700,500); //vCarga escena
        stage.setScene(scene);
        BienvenidaControl p= fxmlLoader.getController(); // Le pasas tu escena
        p.setStage(stage);
        stage.show();
    }
}

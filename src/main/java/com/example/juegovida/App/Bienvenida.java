package com.example.juegovida.App;
import com.example.juegovida.Controllers.BienvenidaControl;

import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.juegovida.App.Tablero.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.juegovida.App.Tablero.setTab;

public class Bienvenida extends Application {

    public static void main(String[] args) {
        launch(args); //LLama a start

    }
    @Override
    public void start(Stage stage) throws Exception {
        Stage s= new Stage();
        Scene se=  new Scene(setTab(4,4),1000,600);
        s.setScene(se);
        s.show();
    }
}

package com.example.juegovida.App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.juegovida.App.Tab.Tablero.setTab;

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

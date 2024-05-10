package com.example.juegovida.App;

import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Utilities.Paths;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablero {
    public static Parent setTab(int filas, int columnas) throws FileNotFoundException {
        Pane prueb= new Pane();

        GridPane mainGrid= new GridPane(); //Crear grid
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);
        mainGrid.setGridLinesVisible(true);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(0,0,0,0));
        for (int i=0;i<filas;i++){
            for (int j=0; j<columnas;j++){
                GridPane second= new GridPane();
                Label l= new Label("");
                Label l2= new Label("");
                Label l3= new Label("");
                Label l4= new Label("");
                second.add(l,0,0);
                second.add(l2,0,1);
                second.add(l3,1,0);
                second.add(l4,1,1);
                mainGrid.add(second,i,j);
            }
        }
        FlowPane f= new FlowPane();
        f.getChildren().add(mainGrid);
        prueb.getChildren().add(f);
        return prueb;
    }


}

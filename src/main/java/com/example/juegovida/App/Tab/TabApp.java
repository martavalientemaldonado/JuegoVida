package com.example.juegovida.App.Tab;

import com.example.juegovida.App.Bienvenida;
import com.example.juegovida.App.ParamRecursos;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.Clases.Individuo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class TabApp extends Application {
    private static final Logger log = LogManager.getLogger(TabApp.class);
    private Region placeholder;

    private Stage stage;

    public static void main(String[] args) {
        launch(args); //LLama a start

    }

    protected Casilla casilla;


    @Override
    public void start(Stage primaryStage) throws Exception {
        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");
        GridPane mainGrid = new GridPane();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                //Label placeholder = new Label("Celda "  + "," + j);
                Button btnNewObject = new Button("Celda " +i + "," + j);
                VBox placeholder = new VBox(btnNewObject);
                btnNewObject.setOnAction(e -> new ParamRecursos());
                btnNewObject.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");

                mainGrid.add(placeholder,i,j);
            }

        }
        ScrollPane s = new ScrollPane(mainGrid);
        Scene sn= new Scene(s, 800,800);
        primaryStage.setScene(sn);
        primaryStage.show();
    }
}

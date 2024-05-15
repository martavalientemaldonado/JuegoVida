package com.example.juegovida.App.Tab;

import com.example.juegovida.App.Bienvenida;
import com.example.juegovida.App.DimensionesyTurnosVida;
import com.example.juegovida.App.ParamRecursos;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.Recurso;
import com.example.juegovida.Controllers.TableroControl;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TabApp{
    private static final Logger log = LogManager.getLogger(TabApp.class);
    private Region placeholder;




    public DimensionesyTurnosVida dim;

    public Parent Tablero(Tablero t) throws Exception {
        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");
        GridPane mainGrid = new GridPane();


        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getColumna(); j++) {
                // Label placeholder = new Label("Celda "  + "," + j);
                Casilla c= new Casilla<>(i,j);
                Button btnNewObject = new Button("Individuos "+c.lIndiv.getNumElementos()+" Recursos "+c.lRec.getNumElementos());
                VBox placeholder = new VBox(btnNewObject);
                TableroControl tab = new TableroControl();
                EventHandler click = new EventHandler() { //Boton conectar
                    @Override
                    public void handle(Event event) {
                        try {
                            tab.click();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                btnNewObject.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");

                mainGrid.add(placeholder, i, j);
            }

        }
        //ScrollPane s = new ScrollPane(mainGrid);
       ScrollPane s = new ScrollPane(mainGrid);


        return s;

    }
}

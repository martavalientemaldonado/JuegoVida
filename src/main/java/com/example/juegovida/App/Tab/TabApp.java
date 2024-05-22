package com.example.juegovida.App.Tab;

import com.example.juegovida.Controllers.TableroControl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TabApp{
    private static final Logger log = LogManager.getLogger(TabApp.class);
    private Region placeholder;
    private Node layout;


    public Parent Tablero(Tablero t) throws Exception {
        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");
        GridPane mainGrid = new GridPane();



        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getColumna(); j++) {
                // Label placeholder = new Label("Celda "  + "," + j);
                Casilla c= new Casilla(i,j);
                Button btnNewObject = new Button("Individuos "+c.lIndiv.getNumElementos()+" Recursos "+c.lRec.getNumElementos());
                VBox placeholder = new VBox(btnNewObject);
                TableroControl tab = new TableroControl();
                EventHandler<ActionEvent> click = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {

                            tab.click();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                btnNewObject.setOnAction(click);
                btnNewObject.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setMinSize(80, 80); // Tamaño mínimo para visualización

                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");




                mainGrid.add(placeholder, i, j);

            }

        }
        ScrollPane s = new ScrollPane(mainGrid);


        return s;

    }

}

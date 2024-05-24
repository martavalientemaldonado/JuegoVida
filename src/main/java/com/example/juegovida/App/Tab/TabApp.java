package com.example.juegovida.App.Tab;

import com.example.juegovida.App.BucledeControl.BucleControl;
import com.example.juegovida.Controllers.TableroControl;
import com.example.juegovida.Errores.Mas3Indiv;
import com.example.juegovida.Errores.Mas3Recs;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class TabApp{
    private static final Logger log = LogManager.getLogger(TabApp.class);
    private Region placeholder;
    private Node layout;
    public boolean botoncasillas;

    private BucleControl bucle;

    public void loadData(BucleControl bucle){
        this.bucle = bucle;
    }


    public Parent Tablero(Tablero t) throws Exception {
        log.info("Inicio del método de arranque de la aplicación para mostrar un grid de forma programática");
        GridPane mainGrid = new GridPane();
        botoncasillas=false;
        Button start = new Button("PLAY");
        VBox st = new VBox(start);
        st.setStyle("-fx-border-color: yellow; -fx-text-alignment: center;");
        st.setMinSize(90, 40);
        Button pause = new Button("PAUSE");
        VBox ps = new VBox(pause);
        ps.setStyle("-fx-border-color: blue; -fx-text-alignment: center;");
        ps.setMinSize(90, 40);
        Button stop = new Button("STOP");
        VBox sto = new VBox(stop);
        sto.setStyle("-fx-border-color: red; -fx-text-alignment: center;");
        sto.setMinSize(90, 40);
        start.setMinSize(90, 40);
        stop.setMinSize(90, 40);
        pause.setMinSize(90, 40);
        //start.setTranslateX(300);
        st.setTranslateX(300);
        //stop.setTranslateX(450);
        sto.setTranslateX(450);
        //pause.setTranslateX(600);
        ps.setTranslateX(600);


        TableroControl tab = new TableroControl();
        EventHandler<ActionEvent> clickstart= new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    tab.clickstart();
                    bucle.bucleEntero();
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Mas3Indiv e) {
                    throw new RuntimeException(e);
                } catch (Mas3Recs e) {
                    throw new RuntimeException(e);
                }
            }
        };
        start.setOnAction(clickstart);
        EventHandler<ActionEvent> clickstop= new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        };
        stop.setOnAction(clickstop);
        EventHandler<ActionEvent> clickps= new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                botoncasillas=true;
                System.out.println(botoncasillas);
            }
        };
        pause.setOnAction(clickps);


        for (int i = 0; i < t.getFila(); i++) {
            for (int j = 0; j < t.getColumna(); j++) {
                // Label placeholder = new Label("Celda "  + "," + j);
                Casilla c= new Casilla(i,j);
                Button btnNewObject = new Button("Individuos "+c.lIndiv.getNumElementos()+" Recursos "+c.lRec.getNumElementos());
                VBox placeholder = new VBox(btnNewObject);
                EventHandler<ActionEvent> click = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {
                            System.out.println(botoncasillas);
                            if(botoncasillas==true) {
                                tab.click();
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                Casilla celda = new Casilla(j,i);
                btnNewObject.setOnAction(click);
                btnNewObject.setMinSize(80, 80); // Tamaño mínimo para visualización
                placeholder.setMinSize(80, 80); // Tamaño mínimo para visualización

                placeholder.setStyle("-fx-border-color: green; -fx-text-alignment: center;");
                mainGrid.add(placeholder, i, j);
            }
        }
/***
        FlowPane f = new FlowPane();
        //f.getChildren().add(mainGrid);
        f.setBackground(Background.fill(Color.GREEN));
        f.setAlignment(Pos.CENTER);
        f.setTranslateY(100);
        f.setTranslateX(60);
 */
        HBox hbox = new HBox(start,pause,stop);
        hbox.setAlignment(Pos.CENTER);
        //f.getChildren().addAll(hbox);
        ScrollPane s = new ScrollPane(hbox);
        ScrollPane s2 = new ScrollPane(mainGrid);
        SplitPane split = new SplitPane(s,s2);
        split.setOrientation(Orientation.VERTICAL);
        split.setDividerPositions(0.1);

        return split;

    }

}

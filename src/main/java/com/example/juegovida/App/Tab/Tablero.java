package com.example.juegovida.App.Tab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;

public class Tablero {
    private static double NunColumnas;
    private static double NunFilas;

    public static double getNunColumnas() {
        return NunColumnas;
    }

    public static void setNunColumnas(double nunColumnas) {
        NunColumnas = nunColumnas;
    }

    public static void setNunFilas(double nunFilas) {
        NunFilas = nunFilas;
    }

    public static double getNunFilas() {
        return NunFilas;
    }

    public static Parent setTab() throws FileNotFoundException {


        Pane prueb = new Pane();

        GridPane mainGrid = new GridPane(); //Crear grid
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);
        mainGrid.setGridLinesVisible(true);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setPadding(new Insets(0, 0, 0, 0));
        for (int i = 0; i < NunFilas; i++) {
            for (int j = 0; j < NunColumnas; j++) {
                GridPane second = new GridPane();
                Label lBib = new Label();
                lBib.setPrefSize(32, 32);
                Label lPozo = new Label();
                lPozo.setPrefSize(32, 32);
                Label lTesoro = new Label();
                lTesoro.setPrefSize(32, 32);
                Label lAgua = new Label();
                lAgua.setPrefSize(32, 32);
                Label lMont = new Label();
                lMont.setPrefSize(32, 32);


                second.add(lBib, 0, 0);
                second.add(lPozo, 0, 1);
                second.add(lTesoro, 1, 0);
                second.add(lAgua, 1, 1);
                mainGrid.add(second, i, j);

                for (int k = 0; k < 3; k++) {
                    for (int x = 0; x < 3; x++) {
                        GridPane terc = new GridPane();
                        Label Indiv1 = new Label();
                        Indiv1.setPrefSize(10.6, 10.6);
                        Label Indiv2 = new Label();
                        Indiv2.setPrefSize(10.6, 10.6);
                        Label Indiv3 = new Label();
                        Indiv3.setPrefSize(10.6, 10.6);

                        Label Rec1 = new Label();
                        Rec1.setPrefSize(10.6, 10.6);
                        Label Rec2 = new Label();
                        Rec2.setPrefSize(10.6, 10.6);
                        Label Rec3 = new Label();
                        Rec3.setPrefSize(10.6, 10.6);

                        terc.add(lBib, 0, 0);
                        terc.add(lPozo, 0, 1);
                        terc.add(lTesoro, 1, 0);
                        terc.add(lAgua, 1, 1);
                        mainGrid.add(second, k, x);


                    }
                }
            }

        }

        FlowPane f = new FlowPane();
        f.getChildren().add(mainGrid);
        prueb.getChildren().add(f);
        return prueb;
    }
}

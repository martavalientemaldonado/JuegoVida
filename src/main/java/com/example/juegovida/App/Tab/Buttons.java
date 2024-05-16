package com.example.juegovida.App.Tab;

import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Buttons extends StackPane {

    public Buttons(String med){
        setAlignment(Pos.CENTER);
        Rectangle r=new Rectangle();
        r.setFill(Color.BLACK);
        r.setVisible(false);
        getChildren().addAll(r);
    }
    public void click(Runnable action){
        setOnMouseClicked(e -> {
            FillTransition ft= new FillTransition(Duration.seconds(1),
                    Color.WHITE, Color.WHITE);
            ft.setOnFinished((e2 -> action.run()));
            ft.play();
        });
    }
}

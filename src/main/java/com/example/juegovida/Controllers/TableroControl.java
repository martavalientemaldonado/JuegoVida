package com.example.juegovida.Controllers;

import com.example.juegovida.App.BucledeControl.BucleControl;
import com.example.juegovida.App.Tab.ArbolBinarioInd;
import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Errores.ElRepetidoError;
import com.example.juegovida.Errores.Mas3Indiv;
import com.example.juegovida.Errores.Mas3Recs;
import com.example.juegovida.Utilities.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TableroControl {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane TabApp;
    protected Casilla casilla;
    private Individuo in;
    private Tablero t;
    private DatosCompartidos d;
    private BucleControl bucle;
    boolean P;

    public void click(Casilla c) throws IOException {
        if(P) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            File fichero = new File(Paths.PARAMCASILLA);
            URL url;
            try {
                url = fichero.toURL();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            fxmlLoader.setLocation(url); // Para encontrar donde esta
            Scene scene; //vCarga escena
            scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setScene(scene);
            ParamCasillaControl p = fxmlLoader.getController();
            this.bucle.setListaIndividuos(new ArbolBinarioInd());
            p.loadUserDataTabTablero(d, this.bucle, c);
            p.setStage(stage);
            stage.show();
        }
        else{

        }
    }
    public void setP(boolean t){
        this.P=t;
    }
    public void clickstart() throws IOException {


    }
    public void clickstop() throws IOException {
        this.t.guardar(this.t);
        this.P=true;
    }
    public void clickps() throws IOException {


    }


    public void loadUserDataTabNuevo(DatosCompartidos parametrosData, BucleControl b) {
        this.bucle=b;
        this.d = parametrosData;
    }

    public void clickajustes() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.TABPARAMETROSTABLERO);
        URL url ;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url);
        Parent root = fxmlLoader.load();
        TabParamTableroControl p = fxmlLoader.getController();

        if (p == null) {
            throw new RuntimeException("El controlador es nulo. Asegúrate de que el FXML está correctamente configurado y tiene el controlador asociado.");
        }

        p.loadUserDataTabTablero(this.d);
        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML




    public void setStage(Stage stage) {
    }
}

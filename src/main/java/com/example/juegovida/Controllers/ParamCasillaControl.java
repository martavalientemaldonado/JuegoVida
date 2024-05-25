package com.example.juegovida.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.juegovida.App.BucledeControl.BucleControl;
import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Clases.Recursos.*;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Errores.Mas3Indiv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ParamCasillaControl{
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label NuevoRe;
    private Casilla casilla;

    @FXML
    private Label NuevoIndiv;

    @FXML
    private ImageView probnuevorecurso;

    @FXML
    private ChoiceBox<String> NuevoInd;

    @FXML
    private ChoiceBox<String> NuevoRecurso;
    private Stage scene;


    @FXML
    void clickAceptar(ActionEvent event) throws Mas3Indiv {
        //Tanto NuevoInd como NuevoRe
        if("Básico" == NuevoInd.getValue()){
            BucleControl.setNumeroIdIndUlt(BucleControl.getNumeroIdIndUlt()+1);
            AñadirIndividuoBasico();
        }
        if("Normal" == NuevoInd.getValue()){
            BucleControl.setNumeroIdIndUlt(BucleControl.getNumeroIdIndUlt()+1);
            AñadirIndividuoNormal();
        }
        if("Avanzado" == NuevoInd.getValue()){
            BucleControl.setNumeroIdIndUlt(BucleControl.getNumeroIdIndUlt()+1);
            AñadirIndividuoAvanzado();
        }
        if("Pozo" == NuevoRecurso.getValue()){
            AñadirRecursoPozo();
        }
        if("Agua" == NuevoRecurso.getValue()){
            AñadirRecursoAgua();
        }
        if("Tesoro" == NuevoRecurso.getValue()){
            AñadirRecursoTesoro();
        }
        if("Biblioteca" == NuevoRecurso.getValue()){
            AñadirRecursoBiblioteca();
        }
        if("Montaña" == NuevoRecurso.getValue()){
            AñadirRecursoMontaña();
        }
        if("Comida" == NuevoRecurso.getValue()){
            AñadirRecursoComida();
        }
        //Cerrar pantalla
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        NuevoInd.getItems().addAll("Básico", "Normal", "Avanzado");
        NuevoInd.setOnAction(this::getIndividuo);
        NuevoRecurso.getItems().addAll("Pozo", "Agua", "Tesoro", "Biblioteca", "Montaña", "Comida");
        NuevoRecurso.setOnAction(this::getRecurso);
        assert probnuevorecurso != null : "fx:id=\"probnuevorecurso\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
        assert NuevoInd != null : "fx:id=\"NuevoInd\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
        assert NuevoRecurso != null : "fx:id=\"NuevoRecurso\" was not injected: check your FXML file 'ParamCasilla.fxml'.";
    }
    public void getIndividuo(ActionEvent event){
        String Ind = NuevoInd.getValue();
        NuevoIndiv.setText(Ind);
    }
    public void getRecurso(ActionEvent event){
        String Re = NuevoRecurso.getValue();
        NuevoRe.setText(Re);
    }

    public void setStage(Stage stage) {
    }
    @FXML
    protected void AñadirIndividuoAvanzado() throws Mas3Indiv {
        if(casilla.getlIndiv().getNumElementos()<3){
            Individuo nuevo = new Individuo(BucleControl.getNumeroIdIndUlt(), 2);
            casilla.addIndiv(nuevo);
            BucleControl.getListaIndividuos().add(nuevo);
        }
    }
    @FXML
    protected void AñadirIndividuoNormal() throws Mas3Indiv {
        if(casilla.getlIndiv().getNumElementos()<3){
            Individuo nuevo = new Individuo(BucleControl.getNumeroIdIndUlt(), 1);
            casilla.addIndiv(nuevo);
            BucleControl.getListaIndividuos().add(nuevo);
        }
    }
    @FXML
    protected void AñadirIndividuoBasico() throws Mas3Indiv {
        if(casilla.getlIndiv().getNumElementos()<3){
            Individuo nuevo = new Individuo(BucleControl.getNumeroIdIndUlt(), 0);
            casilla.addIndiv(nuevo);
            BucleControl.getListaIndividuos().add(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoPozo(){
        if(casilla.getlRec().getNumElementos()<3){
            Pozo nuevo = new Pozo();
            casilla.addRec(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoAgua() {
        if(casilla.getlRec().getNumElementos()<3){
            Agua nuevo = new Agua();
            casilla.addRec(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoTesoro(){
        if(casilla.getlRec().getNumElementos()<3){
            Tesoro nuevo = new Tesoro();
            casilla.addRec(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoBiblioteca(){
        if(casilla.getlRec().getNumElementos()<3){
            Biblioteca nuevo = new Biblioteca();
            casilla.addRec(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoMontaña() {
        if(casilla.getlRec().getNumElementos()<3){
            Montaña nuevo = new Montaña();
            casilla.addRec(nuevo);
        }
    }
    @FXML
    protected void AñadirRecursoComida(){
        if(casilla.getlRec().getNumElementos()<3){
            Comida nuevo = new Comida();
            casilla.addRec(nuevo);
        }
    }
    public void loadUserDataCasilla(Casilla c) {
        this.casilla = c;
    }
}

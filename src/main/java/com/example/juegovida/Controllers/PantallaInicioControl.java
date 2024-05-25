package com.example.juegovida.Controllers;

import com.example.juegovida.App.Tab.Casilla;
import com.example.juegovida.App.Tab.TabApp;
import com.example.juegovida.App.Tab.Tablero;
import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PantallaInicioControl implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private TabApp tab;
    private Stage stage;

    @FXML
    private Button botoncargarp;

    @FXML
    private Button botonnuevap;

    @FXML
    private ImageView imbotcargarp;

    @FXML
    private ImageView imbotonnuevap;

    @FXML
    private ImageView imfondo;

    @FXML
    private Label lblcargarpart;

    @FXML
    private Label lblnuevapart;
    static final Logger logger = LogManager.getLogger(PantallaInicioControl.class);

    @FXML
    void clickcargar(ActionEvent event){
        /*

         */

        logger.info("Cargando partida desde archivo...");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo de partida");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File archivoSeleccionado = fileChooser.showOpenDialog(new Stage());

        if (archivoSeleccionado != null) {
            Tablero partida= new Tablero().cargar();
            if (partida != null) {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("src/main/java/com/example/juegovida/App/Tab/TabApp.java"));
                try {
                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                    stage.setTitle("Tablero");
                    stage.setScene(scene);
                    stage.show();
                    logger.info("Partida cargada y ventana de tablero mostrada.");
                } catch (Exception e) {
                    logger.error("Error al cargar la vista del tablero", e);
                    throw new RuntimeException("Error al cargar la vista del tablero", e);
                }
            } else {
                logger.warn("La partida cargada es nula.");
            }
        } else {
            logger.warn("No se seleccionó ningún archivo para cargar la partida.");
        }

    }



    @FXML
    void clicknueva(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PARAMINDIV);
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(),700,500); //vCarga escena
        stage.setScene(scene);
        ParametrosIndividuoControl p= fxmlLoader.getController();
        p.loadUserDataParamInd(new DatosCompartidos(new Individuo()));
        p.setStage(stage);
        stage.show();

        //Cerrar pantalla
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    void setStage(Stage stage) {
        this.stage=stage;
    }

    @FXML
    void initialize() {
        assert botoncargarp != null : "fx:id=\"botoncargarp\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert botonnuevap != null : "fx:id=\"botonnuevap\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imbotcargarp != null : "fx:id=\"imbotcargarp\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imbotonnuevap != null : "fx:id=\"imbotonnuevap\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert imfondo != null : "fx:id=\"imfondo\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert lblcargarpart != null : "fx:id=\"lblcargarpart\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
        assert lblnuevapart != null : "fx:id=\"lblnuevapart\" was not injected: check your FXML file 'PantallaInicio.fxml'.";

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loaddata(TabApp t){
        this.tab=t;
    }
}


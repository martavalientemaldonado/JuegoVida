package com.example.juegovida.App;

import com.example.juegovida.Clases.Individuo;
import com.example.juegovida.Controllers.BienvenidaControl;
import com.example.juegovida.Controllers.PantallaInicioControl;
import com.example.juegovida.Controllers.ParametrosIndividuoControl;
import com.example.juegovida.DatosCompartidos;
import com.example.juegovida.Utilities.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException;

import static javafx.application.Application.launch;

public class PantallaInicio extends Application {

    public static void main(String[] args) {
        launch();

    }
    private Individuo in = new Individuo();
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File fichero = new File(Paths.PANTALLAINICIO);//Carga scene en stage
        URL url = null;
        try {
            url = fichero.toURL();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fxmlLoader.setLocation(url); // Para encontrar donde esta
        Scene scene = new Scene(fxmlLoader.load(),700,500); //vCarga escena
        stage.setScene(scene);
        ParametrosIndividuoControl p= fxmlLoader.getController(); // Le pasas tu escena
        p.loadUserDataParamInd(new DatosCompartidos(this.in));
        p.setStage(stage);
        stage.show();

    }




}

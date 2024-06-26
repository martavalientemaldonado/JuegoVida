package com.example.juegovida.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;

public class Bienvenida extends Application {
    private static final Logger log = LogManager.getLogger(Bienvenida.class);
    public static void main(String[] args) {
        launch(args); //LLama a start

    }
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlUrl = getClass().getResource("/bienvenida.fxml");
        stage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        // Los logs sólo operan si la clase utilizada coincide con el patrón que se pone en el log4j2.xml.
        // En este caso el patrón es "es.uah" que coincide con nuestro paquete, por eso funciona.


        log.info("Fin del método de arranque de la aplicación para mostrar un grid de forma programática");
    }
}

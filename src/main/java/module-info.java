module com.example.juegovida {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires com.google.gson;


    opens com.example.juegovida.Controllers to javafx.fxml;
    exports com.example.juegovida.Controllers;
    opens com.example.juegovida.App to javafx.fxml;
    exports com.example.juegovida.App;
    exports com.example.juegovida.App.Tab;
    opens com.example.juegovida.App.Tab to javafx.fxml;
    exports com.example.juegovida.App.Tab.ColaInd;
    opens com.example.juegovida.App.Tab.ColaInd to javafx.fxml;
    exports com.example.juegovida;
    opens com.example.juegovida to javafx.fxml;
    exports com.example.juegovida.App.Tab.GrafoCasillas;
    opens com.example.juegovida.App.Tab.GrafoCasillas to javafx.fxml;

}
module com.example.juegovida {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juegovida.Controllers to javafx.fxml;
    exports com.example.juegovida.Controllers;
    opens com.example.juegovida.App to javafx.fxml;
    exports com.example.juegovida.App;
}
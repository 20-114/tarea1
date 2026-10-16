module com.example.tarea1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tarea1 to javafx.fxml;
    opens com.example.tarea1.controller to javafx.fxml;
    exports com.example.tarea1;
    exports com.example.tarea1.controller;
    exports com.example.tarea1.dto;
}
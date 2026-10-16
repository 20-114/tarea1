package com.example.tarea1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UsuariosController {
    public Button btnAgregar;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleEliminarrUsuario(ActionEvent actionEvent) {
    }

    public void handleAgregarUsuario(ActionEvent actionEvent) {
    }
}

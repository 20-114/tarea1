package com.example.tarea1.controller;

import com.example.tarea1.dto.UsuarioDto;
import com.example.tarea1.model.UsuariosModel;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class UsuariosController {
    @FXML
    public TextField txtId;
    @FXML
    public TextField txtUsuario;
    @FXML
    public TextField txtContrasena;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnEliminar;
    @FXML
    public TableView tablaUsuarios;
    public TableColumn colId;
    public TableColumn colNombre;
    public TableColumn colContrasena;

    private UsuariosModel usuariosModel;
    private ObservableList<UsuarioDto> usuariosObservable;
    private int contadorId = 0;



    public ArrayList<UsuarioDto> getUsuarios(){
        return this.usuariosModel.getUsuarios();
    }

    @FXML
    public void inicialize(){
        /***
         * Se inicializan los valores por defecto de las columnas de la tabla
         */
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colContrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        /***
         * Se inicializa la lista observable
         */
        usuariosObservable = FXCollections.observableArrayList();
        /***
         * Se asigna la lista observable a la tablaUsuarios para
         * que los usuarios se visualicen desde la misma en el entorno grafico
         */
        tablaUsuarios.setItems(this.usuariosObservable);
    }

    public void handleEliminarrUsuario(ActionEvent actionEvent) {

    }

    public void handleAgregarUsuario(ActionEvent actionEvent) {
    }
}

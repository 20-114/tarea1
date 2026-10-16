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
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class UsuariosController {

    @FXML
    public TextField txtNombre;
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

    UsuarioDto usuarioDto = new UsuarioDto();
    private UsuariosModel usuariosModel;
    private ObservableList<UsuarioDto> usuariosObservable;
    private int contadorId = 0;

    public ArrayList<UsuarioDto> getUsuarios(){
        return this.usuariosModel.getUsuarios();
    }

    public int getContadorId(){
        this. contadorId = this.contadorId += 1;
        return contadorId;
    }

    public UsuariosController() {
        this.usuariosModel = new UsuariosModel();
    }

    @FXML
    public void initialize(){
        /***
         * Se inicializan los valores por defecto de las columnas de la tabla
         */
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colContrasena.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        /***
         * Se inicializa la lista observable
         */
        this.usuariosObservable = FXCollections.observableArrayList();
        /***
         * Se asigna la lista observable a la tablaUsuarios para
         * que los usuarios se visualicen desde la misma en el entorno grafico
         */
        this.tablaUsuarios.setItems(this.usuariosObservable);
    }

    public void handleEliminarrUsuario(ActionEvent actionEvent) {
    }

    public void handleAgregarUsuario(ActionEvent actionEvent) throws Exception  {
        try {
            UsuarioDto nuevoUsuario = new UsuarioDto();

            if (txtNombre.getText().trim().isEmpty() || txtContrasena.getText().trim().isEmpty()) {
                throw new Exception("Los campos nombre y/o contraseña no pueden quedar vacios");
            }
            /***
             * Setea los valores de los TextField y el contador de id al nuevo usuario
             */
            nuevoUsuario.setId(this.getContadorId());
            nuevoUsuario.setNombre(txtNombre.getText());
            nuevoUsuario.setContrasena(txtContrasena.getText());
            /***
             * Reinicializa el valor de los TextField nombre y contrasena
             */
            this.txtNombre.setText("");
            this.txtContrasena.setText("");

            this.txtNombre.requestFocus();

            this.usuariosModel.agregarUsuario(nuevoUsuario);
            this.usuariosObservable.addAll(this.usuariosModel.getUsuarios());
        } catch (Exception e){
            printError(e);
        }
    }
    @FXML
    public void handleConseguirElemento(MouseEvent mouseEvent) {
        UsuarioDto usuarioDto = (UsuarioDto) this.tablaUsuarios.getSelectionModel().getSelectedItem();
    }

    public void printError(Exception e){
        Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

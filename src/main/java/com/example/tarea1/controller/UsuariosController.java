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
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colNombre;
    @FXML
    public TableColumn colContrasena;
    @FXML
    public TextField txtId;

    private UsuariosModel usuariosModel;
    private ObservableList<UsuarioDto> usuariosObservable;
    private int contadorId = 0;
    UsuarioDto usuarioEliminar;

    public ArrayList<UsuarioDto> getUsuarios(){
        return this.usuariosModel.getUsuarios();
    }


    public int getContadorId(){
        //suma 1 al contadorId papa hacer que sea autoincremental el id de los usuarios
        this. contadorId = this.contadorId += 1;
        return contadorId;
    }

    public UsuariosController() {

        this.usuariosModel = new UsuariosModel();
    }

    @FXML
    public void initialize(){
        //Se ejecuta luego de cargar el archivo .fxml para configurar la tabla y la visualización de la lista
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

    public void handleEliminarrUsuario(ActionEvent actionEvent) throws Exception {
        //Elimina un usuario de la lista
        /***
         * Elimina el objeto usuarioEliminar que hace referencia al usuario clickeado de
         * la tabla desde la función handleConseguirElemento() mediante el metodo eliminarUsuario()
         * de usuariosModel
         */
        this.usuariosModel.eliminarUsuario(this.usuarioEliminar);
        /***
         *Actualiza la tabla volviendo a cargar la lista de usuarios
         */
        this.usuariosObservable.setAll(this.usuariosModel.getUsuarios());
        /***
         * Limpia el valor de la variable usuarioEliminar
         */
        this.usuarioEliminar = null;
    }

    @FXML
    public void handleConseguirElemento(MouseEvent mouseEvent) {
        //Consigue la selección de una fila cuando se hace click en la tabla
        /***
         * Extrae el objeto seleccionado de la tabla
         */
        UsuarioDto usuarioDto = (UsuarioDto) this.tablaUsuarios.getSelectionModel().getSelectedItem();
        /***
         * Evalua como true cuando la instancia del objeto UsuarioDto no es null
         */
        if (usuarioDto != null){
            /***
             * Consigue el id del usuario seleccionado
             */
            this.txtId.setText(usuarioDto.getId().toString());
            /***
             * Habilita el boton btnEliminar
             */
            this.btnEliminar.setDisable(false);
            /***
             * Guarda la referencia del objeto UsuarioDto en la variable usuarioEliminar
             */
            this.usuarioEliminar = usuarioDto;
        }
    }
    public void handleAgregarUsuario(ActionEvent actionEvent) throws Exception  {
        //Adiciona un nuevo elemento (usuario) a la lista cuando btnAgregar es presionado y los TextField no estan vacios
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
             * Limpia el valor de los TextField nombre y contrasena
             */
            this.txtNombre.setText("");
            this.txtContrasena.setText("");
            /***
             * Relocaliza el cursor en el TextField txtNombre
             */
            this.txtNombre.requestFocus();
            /***
             * Guarda el objeto "nuevoUsuario" en la lista mediante el metodo agregarUsuario() de usuarioModel
             */
            this.usuariosModel.agregarUsuario(nuevoUsuario);
            /***
             * Actualiza la tabla con el nuevo usuario
             */
            this.usuariosObservable.add(nuevoUsuario);
        } catch (Exception e){
            printError(e);
        }
    }

    public void printError(Exception e){
        /***
         * Crea una instancia de la ventana de error
         */
        Alert alert =new Alert(Alert.AlertType.ERROR);
        /***
         * Define el texto en la parte superior de la ventana
         */
        alert.setTitle("Error");
        /***
         * Crea un encabezado en la parte superior del Cuero de la ventana
         */
        alert.setHeaderText("Error");
        /***
         * Define el mensaje de error según la Exception controlada
         */
        alert.setContentText(e.getMessage());
        /***
         * Despliega la ventana de error y pausa la aplicación hasta que sea cerrada
         */
        alert.showAndWait();
    }
}

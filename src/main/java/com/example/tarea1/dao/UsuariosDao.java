package com.example.tarea1.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsuariosDao {
    private final static String NOMBRE_ARCHIVO = "usuario.json";
    public Path ruta;

    public UsuariosDao(){
        this.ruta = Path.of(System.getProperty("user.home"), NOMBRE_ARCHIVO);
        System.out.println(this.ruta);
    }

    public void guardarNombre(String nombre) throws IOException {
        try {
            Files.writeString(this.ruta, nombre);
        } catch (IOException e){
            System.out.println("Error al guardar" + e.getMessage());
        }
    }

    public String leerNombre(){
        String resultado = "";
        try {
            resultado = Files.readString(this.ruta);
        } catch (IOException e){
            System.out.println("Error al leer" + e.getMessage());
        }
        return resultado;
    }
}

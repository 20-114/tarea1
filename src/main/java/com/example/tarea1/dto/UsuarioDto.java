package com.example.tarea1.dto;

public class UsuarioDto {
    private Integer id;
    private String nombre = "";
    private String contrasena = "";

    public UsuarioDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString(){
        return "UsuarioDto" +
                "|id: " + id +
                "|nombre: " + nombre +
                "|contrasena: " + contrasena;
    }
}

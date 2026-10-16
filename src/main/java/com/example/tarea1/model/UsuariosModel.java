package com.example.tarea1.model;

import com.example.tarea1.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuariosModel {
    private ArrayList<UsuarioDto> usuarios = new ArrayList<>();

    public ArrayList<UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(UsuarioDto usuario){
        this.usuarios = getUsuarios();
        this.usuarios.add(usuario);
    }
    public void eliminarUsuario(UsuarioDto usuario){
        this.usuarios = getUsuarios();
        this.usuarios.remove(usuario);
    }


}

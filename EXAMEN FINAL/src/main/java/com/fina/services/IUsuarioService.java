package com.fina.services;

import com.cibertec.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> obtenerTodos();
    Usuario obtenerUsuarioPorId(Long id);
    void registrarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
}

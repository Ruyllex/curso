package com.example.curso.curso.dao;

import com.example.curso.curso.Model.Usuario;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuario();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarPassword(Usuario usuario);
}

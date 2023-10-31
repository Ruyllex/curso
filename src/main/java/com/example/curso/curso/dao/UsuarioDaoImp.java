package com.example.curso.curso.dao;

import com.example.curso.curso.Model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        List<Usuario> resultado =  entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
    @Override
    public boolean verificarPassword(Usuario usuario) {
        String query = "FROM Usuario WHERE email= :email AND password = :password";
        List<Usuario> resultado =  entityManager.createQuery(query).setParameter("email",usuario.getEmail()).setParameter("password",usuario.getPassword()).getResultList();
        return (!resultado.isEmpty());
    }

}

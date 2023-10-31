package com.example.curso.curso.Controller;

import com.example.curso.curso.Model.Usuario;
import com.example.curso.curso.dao.UsuarioDao;
import com.example.curso.curso.dao.UsuarioDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarPassword(usuario)){
           return "OK";
        }
        return "LOGIN INCORRECTO";
    }
}

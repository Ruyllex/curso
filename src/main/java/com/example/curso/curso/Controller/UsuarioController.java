package com.example.curso.curso.Controller;

import com.example.curso.curso.Model.Usuario;
import com.example.curso.curso.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario Ruy = new Usuario();
        Ruy.setId(1L);
        Ruy.setDNI(43595414);
        Ruy.setNombre("Ruy");
        Ruy.setApellido("Mori");
        Ruy.setEmail("ruymori630@gmail.com");
        return Ruy;
    }
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuario();
    }
    @RequestMapping(value="api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }
    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }
}

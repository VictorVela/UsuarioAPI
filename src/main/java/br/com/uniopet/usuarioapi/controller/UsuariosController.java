package br.com.uniopet.usuarioapi.controller;

import br.com.uniopet.usuarioapi.model.Usuario;
import br.com.uniopet.usuarioapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {return usuarioService.findAll();}

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id){return usuarioService.findById(id);}

    @PostMapping
    public Long create (@RequestBody Usuario usuario){return usuarioService.saveOrUpdate(usuario);}

}

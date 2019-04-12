package br.com.uniopet.usuarioapi.service;

import br.com.uniopet.usuarioapi.model.Usuario;
import br.com.uniopet.usuarioapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){ return usuarioRepository.findAll();}

    public Usuario findById(Long id){return usuarioRepository.findById(id).get();}

    public Long saveOrUpdate(Usuario usuario){
        if (usuario.getId() != null){
            usuarioRepository.save(usuario);
            return usuario.getId();
        }

        usuarioRepository.save(usuario);
        return usuario.getId();
    }

    public String deleteById(Usuario usuario){
        usuarioRepository.deleteById(usuario.getId());

        if (!usuarioRepository.existsById(usuario.getId())){
            return "Deletado com sucesso";
        }

        return "Erro ao deletar";
    }
}

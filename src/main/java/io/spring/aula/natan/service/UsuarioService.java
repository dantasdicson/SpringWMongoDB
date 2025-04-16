package io.spring.aula.natan.service;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }
    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }
    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }
  
    
    
//    public Page<Usuario> listaPaginada(int count, int page){
//        Pageable pages = new PageRequest(page, count);
//        return usuarioRepository.findAll(pages);
//    } 

     public Page<Usuario> listaPaginada(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return usuarioRepository.findAll(pages);
    }

   public Usuario getById(String id) {
        return usuarioRepository.findById(id).get();
   }
//
//    
//    }
    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
        
    }
    public Usuario consultarUsuario(String id){
       return usuarioRepository.findById(id).get();
    }
}
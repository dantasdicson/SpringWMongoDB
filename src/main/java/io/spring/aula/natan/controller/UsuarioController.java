
package io.spring.aula.natan.controller;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return this.usuarioService.listaUsuario();
    }
   @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getById(@PathVariable String id) {
        return this.usuarioService.getById(id);
    }

    @RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.usuarioService.listaPaginada(page, count);
    }

    @RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
    public List<Usuario> listaPaginada(@PathVariable String nome) {
        return this.usuarioService.buscaPorNome(nome);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.usuarioService.deleteUsuario(id);
    }

}

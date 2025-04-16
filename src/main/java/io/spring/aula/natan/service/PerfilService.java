
package io.spring.aula.natan.service;
import io.spring.aula.natan.entity.Perfil;

import io.spring.aula.natan.repository.PerfilRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    public List<Perfil> listaPerfil() {
        return perfilRepository.findAll();
    }
    public Page<Perfil> listaPaginada(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return perfilRepository.findAll(pages);
    }


    public Perfil salvarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void deletePerfil(String id) {
        perfilRepository.deleteById(id);
    }

    public Optional<Perfil> getById(String id) {
        return perfilRepository.findById(id);
    }

    public List<Perfil> buscaPorNome(String nome) {
        return perfilRepository.findByNomeLikeIgnoreCase(nome);
    }
}

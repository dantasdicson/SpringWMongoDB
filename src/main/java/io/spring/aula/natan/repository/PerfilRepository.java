package io.spring.aula.natan.repository;


import io.spring.aula.natan.entity.Perfil;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PerfilRepository extends MongoRepository<Perfil, String> {

    public List<Perfil> findByNomeLikeIgnoreCase(String nome);

}


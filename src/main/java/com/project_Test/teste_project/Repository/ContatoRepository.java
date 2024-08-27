package com.project_Test.teste_project.Repository;

import com.project_Test.teste_project.Dtos.ContatoDTO;
import com.project_Test.teste_project.Model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByContatoCelular(String contatoCelular);
}

package com.project_Test.Repository;

import com.project_Test.Dtos.ContatoDTO;
import com.project_Test.Model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByContatoCelular(String contatoCelular);

    @Query("SELECT c FROM Contato c WHERE c.contatoCelular LIKE %:celular%")
    List<Contato> findByContatoCelularContaining(@Param("celular") String celular);

}


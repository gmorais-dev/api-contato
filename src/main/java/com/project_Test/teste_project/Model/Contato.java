package com.project_Test.teste_project.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contato", schema = "public")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contatoId;

    @Column(nullable = false, length = 100)
    private String contatoNome;

    @Column(nullable = false, length = 255)
    private String contatoEmail;

    @Column(nullable = false, length = 11, unique = true)
    private String contatoCelular;

    @Column(length = 10)
    private String contatoTelefone;

    @Column(nullable = false)
    private char contatoSnFavorito;

    @Column(nullable = false)
    private char contatoSnAtivo;

    @Column(nullable = false)
    private LocalDateTime contatoDhCad;
}

package com.project_Test.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoDTO {

    private Long contatoId;
    private String contatoNome;
    private String contatoEmail;
    private String contatoCelular;
    private String contatoTelefone;
    private char contatoSnFavorito;
    private char contatoSnAtivo;
    private LocalDateTime contatoDhCad;

}



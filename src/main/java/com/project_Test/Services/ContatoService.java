package com.project_Test.Services;


import com.project_Test.Dtos.ContatoDTO;
import com.project_Test.Exceptions.DuplicateResourceException;
import com.project_Test.Exceptions.ResourceNotFoundException;
import com.project_Test.Model.Contato;
import com.project_Test.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoDTO cadastrarContato(ContatoDTO contatoDTO) {

        Optional<Contato> contatoExistente = contatoRepository.findByContatoCelular(contatoDTO.getContatoCelular());
        if (contatoExistente.isPresent()) {
            throw new DuplicateResourceException("Contato já cadastrado com este número de celular.");
        }

        Contato contato = new Contato();
        contato.setContatoNome(contatoDTO.getContatoNome());
        contato.setContatoEmail(contatoDTO.getContatoEmail());
        contato.setContatoCelular(contatoDTO.getContatoCelular());
        contato.setContatoTelefone(contatoDTO.getContatoTelefone());
        contato.setContatoSnFavorito(contatoDTO.getContatoSnFavorito());
        contato.setContatoSnAtivo('S');
        contato.setContatoDhCad(LocalDateTime.now());

        contato = contatoRepository.save(contato);
        contatoDTO.setContatoId(contato.getContatoId());
        contatoDTO.setContatoDhCad(contato.getContatoDhCad());

        return contatoDTO;
    }
    public List<ContatoDTO> buscarPorNumero(String celular) {
        List<Contato> contatos = contatoRepository.findByContatoCelularContaining(celular);
        if (contatos.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum contato encontrado com o número de celular: " + celular);
        }
        return contatos.stream().map(contato -> {
            ContatoDTO contatoDTO = new ContatoDTO();
            contatoDTO.setContatoId(contato.getContatoId());
            contatoDTO.setContatoNome(contato.getContatoNome());
            contatoDTO.setContatoEmail(contato.getContatoEmail());
            contatoDTO.setContatoCelular(contato.getContatoCelular());
            contatoDTO.setContatoTelefone(contato.getContatoTelefone());
            contatoDTO.setContatoSnFavorito(contato.getContatoSnFavorito());
            contatoDTO.setContatoSnAtivo(contato.getContatoSnAtivo());
            contatoDTO.setContatoDhCad(contato.getContatoDhCad());
            return contatoDTO;
        }).collect(Collectors.toList());
    }
    public List<ContatoDTO> listarContatos() {
        return contatoRepository.findAll().stream().map(contato -> {
            ContatoDTO dto = new ContatoDTO();
            dto.setContatoId(contato.getContatoId());
            dto.setContatoNome(contato.getContatoNome());
            dto.setContatoEmail(contato.getContatoEmail());
            dto.setContatoCelular(contato.getContatoCelular());
            dto.setContatoTelefone(contato.getContatoTelefone());
            dto.setContatoSnFavorito(contato.getContatoSnFavorito());
            dto.setContatoSnAtivo(contato.getContatoSnAtivo());
            dto.setContatoDhCad(contato.getContatoDhCad());
            return dto;
        }).collect(Collectors.toList());
    }

    public ContatoDTO atualizarContato(Long id, ContatoDTO contatoDTO) {
        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado."));

        contato.setContatoNome(contatoDTO.getContatoNome());
        contato.setContatoEmail(contatoDTO.getContatoEmail());
        contato.setContatoTelefone(contatoDTO.getContatoTelefone());
        contato.setContatoSnFavorito(contatoDTO.getContatoSnFavorito());
        contato = contatoRepository.save(contato);
        contatoDTO.setContatoDhCad(contato.getContatoDhCad());
        return contatoDTO;
    }

    public void inativarAtivarContato(Long id) {
        Contato contato = contatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado."));
        if (contato.getContatoSnAtivo() == 'N') {
            contato.setContatoSnAtivo('S');

        } else if (contato.getContatoSnAtivo() == 'S') {
            contato.setContatoSnAtivo('N');

        }
        contatoRepository.save(contato);
    }
}
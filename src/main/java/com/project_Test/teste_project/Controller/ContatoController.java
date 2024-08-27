package com.project_Test.teste_project.Controller;

import com.project_Test.teste_project.Dtos.ContatoDTO;
import com.project_Test.teste_project.Services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping (name = "/salvar")
    public ResponseEntity<ContatoDTO> cadastrarContato(@RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(contatoService.cadastrarContato(contatoDTO));
    }
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> listarContatos() {
        return ResponseEntity.ok(contatoService.listarContatos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(contatoService.atualizarContato(id, contatoDTO));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativarContato(@PathVariable Long id) {
        contatoService.inativarContato(id);
        return ResponseEntity.noContent().build();
    }
}

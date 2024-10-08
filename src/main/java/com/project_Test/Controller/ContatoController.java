package com.project_Test.Controller;


import com.project_Test.Dtos.ContatoDTO;
import com.project_Test.Services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;
    @PostMapping("/salvar")
    public ResponseEntity<ContatoDTO> cadastrarContato(@RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(contatoService.cadastrarContato(contatoDTO));
    }
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> listarContatos() {
        return ResponseEntity.ok(contatoService.listarContatos());
    }
    @GetMapping("/{celular}")
    public ResponseEntity<List<ContatoDTO>> buscarPorCelular(@PathVariable String celular) {
        List<ContatoDTO> contatos = contatoService.buscarPorNumero(celular);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(contatoService.atualizarContato(id, contatoDTO));
    }
    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativarAtivarContato(@PathVariable Long id) {
        contatoService.inativarAtivarContato(id);
        return ResponseEntity.noContent().build();
    }
}

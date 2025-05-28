/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.controller;

import jakarta.validation.Valid;
import my.company.livraria.models.Escritor;
import my.company.livraria.service.EscritorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Iury
 */

@RestController
@RequestMapping("/escritores")
public class EscritorController {
    @Autowired private EscritorService service;

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Escritor escritor) {
        return ResponseEntity.ok(service.salvar(escritor));
    }

    @GetMapping
    public List<Escritor> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Escritor> buscar(@Valid @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@Valid @PathVariable Long id) { service.deletar(id); }

    // PUT /escritores/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEscritor(
            @PathVariable Long id,
            @Valid @RequestBody Escritor escritorAtualizado) {

        Optional<Escritor> escritorOptional = service.buscarPorId(id);
        if (escritorOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        Escritor escritorExistente = escritorOptional.get();
        escritorExistente.setNome(escritorAtualizado.getNome());
        escritorExistente.setCpf(escritorAtualizado.getCpf());
        escritorExistente.setEmail(escritorAtualizado.getEmail());
        escritorExistente.setIdade(escritorAtualizado.getIdade());

        service.salvar(escritorExistente);

        return ResponseEntity.ok(escritorExistente);
    }
}

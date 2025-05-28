/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.controller;

import jakarta.validation.Valid;
import my.company.livraria.models.Escritor;
import my.company.livraria.models.Livro;
import my.company.livraria.service.LivroService;
import my.company.livraria.service.EscritorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Iury
 */
@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired private LivroService service;
    @Autowired private EscritorService escritorService;

    @PostMapping
    public ResponseEntity<?> salvarLivro(@Valid @RequestBody Livro livro) {

        Optional<Escritor> autor = escritorService.buscarPorId(livro.getAutor().getId_autor());
        if (autor.isEmpty()) {
            return ResponseEntity.badRequest().body("Autor não encontrado");
        }
        livro.setAutor(autor.get());

        Livro salvo = service.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Livro> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@Valid @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/autor")
    public List<Livro> buscarPorAutor(@RequestParam String nome) {
        return service.buscarPorNomeAutor(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }

    // PUT /livros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLivro(
            @PathVariable Long id,
            @Valid @RequestBody Livro livroAtualizado) {

        Optional<Livro> livroOptional = service.buscarPorId(id);
        if (livroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Livro livroExistente = livroOptional.get();
        livroExistente.setNome(livroAtualizado.getNome());
        livroExistente.setPreco(livroAtualizado.getPreco());
        livroExistente.setEditora(livroAtualizado.getEditora());
        livroExistente.setAno_publicacao(livroAtualizado.getAno_publicacao());
        livroExistente.setAutor(livroAtualizado.getAutor());

        service.salvar(livroExistente);

        return ResponseEntity.ok(livroExistente);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.service;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import my.company.livraria.repository.LivroRepository;
import my.company.livraria.models.Livro;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Iury
 */
@Service
public class LivroService {
    @Autowired private LivroRepository  livroRepo;

    public LivroService(LivroRepository livroRepo) {
        this.livroRepo = livroRepo;
    }

    public Livro salvar(@Valid Livro livro) {
        return livroRepo.save(livro);
    }

    public List<Livro> listar() {
        return livroRepo.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepo.findById(id);
    }

    public void deletar(Long id) {
        livroRepo.deleteById(id);
    }

    public List<Livro> buscarPorNomeAutor(String nome) {
        return livroRepo.findByAutorNomeContainingIgnoreCase(nome);
    }


}

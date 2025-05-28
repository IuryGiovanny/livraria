/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.service;

import my.company.livraria.models.Escritor;
import my.company.livraria.repository.EscritorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Iury
 */
@Service
public class EscritorService {

    @Autowired
    private EscritorRepository escritorRepo;

    public Escritor salvar(Escritor escritor) {
        return escritorRepo.save(escritor);
    }

    public List<Escritor> listar() {
        return escritorRepo.findAll();
    }

    public Optional<Escritor> buscarPorId(Long id) {
        return escritorRepo.findById(id);
    }

    public Escritor atualizar(Long id, Escritor escritorAtualizado) {
        return escritorRepo.findById(id)
                .map(escritor -> {
                    escritor.setNome(escritorAtualizado.getNome());
                    escritor.setCpf(escritorAtualizado.getCpf());
                    escritor.setEmail(escritorAtualizado.getEmail());
                    escritor.setIdade(escritorAtualizado.getIdade());
                    return escritorRepo.save(escritor);
                }).orElseThrow(() -> new RuntimeException("Escritor não encontrado"));
    }

    public void deletar(Long id) {
        escritorRepo.deleteById(id);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.repository;

import my.company.livraria.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author Iury
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorNomeContainingIgnoreCase(String nome);
}

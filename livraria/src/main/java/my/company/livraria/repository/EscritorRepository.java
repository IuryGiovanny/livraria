/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.company.livraria.repository;


import my.company.livraria.models.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Iury
 */
public interface EscritorRepository extends JpaRepository<Escritor, Long> {
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entity.Maestro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepo extends JpaRepository <Maestro, Integer> {
     // Método para buscar un maestro por su ID
    Maestro findById(int id_maestro);
    
    @Query(value = "SELECT * FROM Maestro WHERE grado =? AND grupo = ?", nativeQuery = true)
    List<Maestro> findMaestrobyGradoandGrupo(@Param("grado") int grado, @Param("grupo") String grupo);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entity.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepo extends JpaRepository<Alumno, Integer>{
     // Método para buscar un producto por su ID
    Alumno findById(int id_alumno);
    
    @Query(value = "SELECT * FROM Alumno WHERE edad BETWEEN ?1 AND ?2", nativeQuery = true)
    List <Alumno> findAlumnobyEdad (int edad1, int edad2);
    
}

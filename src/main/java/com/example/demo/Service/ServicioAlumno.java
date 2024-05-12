/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entity.Alumno;
import com.example.demo.Repository.AlumnoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAlumno {
     @Autowired
    
    AlumnoRepo ralumno;
    public List<Alumno> obtenerTodosAlumnos(){
     return ralumno.findAll();
    }
   
               
     public Alumno obtenerAlumnoPorCodigo(int id_alumno) {
        // Buscar el producto por su código
        Alumno alumno = ralumno.findById(id_alumno);
        
        // Cargar el fabricante asociado al producto
        alumno.getId_maestro().getNombreM(); // Esto forzará la carga del fabricante desde la base de datos
        return alumno;
    }
     public List <Alumno> obtenerAlumnoporEdad(int edad1, int edad2){
         return ralumno.findAlumnobyEdad(edad1, edad2);
     }
    public boolean eliminar(Alumno e){
        boolean respuesta = false;
        try{
            ralumno.delete(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al eliminar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
    
}

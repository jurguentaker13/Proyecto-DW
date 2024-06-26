/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Maestro;
import com.example.demo.Service.ServicioAlumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Alumno")
public class AlumnoPrueba {
    @Autowired
    ServicioAlumno salumno;
    
   @GetMapping("/")
    public List<Alumno> prueba2(){
            return salumno.obtenerTodosAlumnos();
    }
    @GetMapping("/codigoAlumno")
    public Alumno prueba(int id_alumno) {
        return salumno.obtenerAlumnoPorCodigo(id_alumno);
    }
   @GetMapping("/Edad")
    public ResponseEntity<List<Alumno>> prueba3(int edad1, int edad2) {
    List <Alumno> users = salumno.obtenerAlumnoporEdad(edad1, edad2);
        if(!users.isEmpty()){
            return ResponseEntity.ok(users);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/idMaestro")
    public List<Alumno> prueba4(Maestro id_maestro) {
        return salumno.findAlumnobyIdMaestro(id_maestro);
    }
   @PostMapping("/guardar")
    public List<Alumno> guardar(
            @RequestParam int id_alumno,
            @RequestParam String nombreA,
            @RequestParam String apellidoP,
            @RequestParam String apellidoM,
            @RequestParam int edad,
            @RequestParam int id_maestro) {  // Assuming id_maestro is an int, adjust if it's an object

        Alumno e = new Alumno();
        e.setId_alumno(id_alumno);
        e.setNombreA(nombreA);
        e.setApellidoP(apellidoP);
        e.setApellidoM(apellidoM);
        e.setEdad(edad);
        Maestro maestro = new Maestro();
        maestro.setId_maestro(id_maestro);
        e.setId_maestro(maestro);  // Assuming you have a method to set a Maestro by id

        if (salumno.guardar(e)) {
            return salumno.obtenerTodosAlumnos();
        }
        return null;
    }
     @PutMapping("/actualizar")
    public List <Alumno> actualizar(int id_alumno, String nombreA, String apellidoP, String apellidoM, int edad, Maestro id_maestro){
        Alumno e = new Alumno();
        e.setId_maestro(id_maestro);
        e.setNombreA(nombreA);
        e.setApellidoP(apellidoP);
        e.setApellidoM(apellidoM);
        e.setEdad(edad);
        e.getId_maestro();
        if(salumno.actualizar(e)){
             return salumno.obtenerTodosAlumnos();
        }
       return null;
    }
    @DeleteMapping("/eliminar")
        public List <Alumno> eliminar(int id_alumno){
        Alumno e = new Alumno();
        e.setId_alumno(id_alumno);
        if(salumno.eliminar(e)){
             return salumno.obtenerTodosAlumnos();
        }
       return null;
    }
    
}

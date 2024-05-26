/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Entity.Maestro;
import com.example.demo.Service.ServicioMaestro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Maestro")
public class MaestroPrueba {
    @Autowired
    ServicioMaestro smaestro;
     @GetMapping("/Maestro")
    public List<Maestro> prueba2(){
            return smaestro.obtenerTodosMaestros();
            }
    @GetMapping("/id")
    public Maestro prueba(int id_maestro) {
        return smaestro.obtenerMaestroPorCodigo(id_maestro);
    }
     @GetMapping("/GradoyGrupo")
    public ResponseEntity<List<Maestro>> prueba3(int grado, String grupo) {
    List <Maestro> users = smaestro.findMaestrobyGradoandGrupo(grado, grupo);
        if(!users.isEmpty()){
            return ResponseEntity.ok(users);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/guardarM")
    public List <Maestro> guardar(int id_maestro, String nombreM, String apellidoP, String apellidoM, int grado, String grupo){
        Maestro e = new Maestro();
        e.setId_maestro(id_maestro);
        e.setNombreM(nombreM);
        e.setApellidoP(apellidoP);
        e.setApellidoM(apellidoM);
        e.setGrado(grado);
        e.setGrupo(grupo);
        if(smaestro.guardar(e)){
             return smaestro.obtenerTodosMaestros();
        }
       return null;
    }
    
    
    @PutMapping("/actualizarM")
    public List <Maestro> actualizar(int id_maestro, String nombreM, String apellidoP, String apellidoM, int grado, String grupo){
        Maestro e = new Maestro();
        e.setId_maestro(id_maestro);
        e.setNombreM(nombreM);
        e.setApellidoP(apellidoP);
        e.setApellidoM(apellidoM);
        e.setGrado(grado);
        e.setGrupo(grupo);
        if(smaestro.guardar(e)){
             return smaestro.obtenerTodosMaestros();
        }
       return null;
    }
    
    @DeleteMapping("/eliminarM")
   public List <Maestro> eliminar(int id_maestro, String nombreM, String apellidoP, String apellidoM, int grado, String grupo){
        Maestro e = new Maestro();
        e.setId_maestro(id_maestro);
        e.setNombreM(nombreM);
        e.setApellidoP(apellidoP);
        e.setApellidoM(apellidoM);
        e.setGrado(grado);
        e.setGrupo(grupo);
        if(smaestro.guardar(e)){
             return smaestro.obtenerTodosMaestros();
        }
       return null;
}
}

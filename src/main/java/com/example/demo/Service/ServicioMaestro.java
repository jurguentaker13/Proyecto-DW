/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entity.Maestro;
import com.example.demo.Repository.MaestroRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMaestro {
    @Autowired
    
     MaestroRepo rmaestro;
    
    public List<Maestro> obtenerTodosMaestros(){
     return rmaestro.findAll();
    }
    
     public Maestro obtenerMaestroPorCodigo(int id_maestro) {
        return rmaestro.findById(id_maestro);
    }
     
    public List <Maestro> findMaestrobyGradoandGrupo(int grado, String grupo){
        return rmaestro.findMaestrobyGradoandGrupo(grado, grupo);
    }
    
    public boolean guardar(Maestro e){
        boolean respuesta = false;
        try{
            rmaestro.save(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al guardar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
    
    public boolean actualizar(Maestro e){
        boolean respuesta = false;
        try{
            rmaestro.save(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al guardar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
    public boolean eliminar(Maestro e){
        boolean respuesta = false;
        try{
            rmaestro.delete(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al eliminar" + error);
            respuesta = false;
        }
        return respuesta;
    }
}

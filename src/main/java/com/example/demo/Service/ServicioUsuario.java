/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;


import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {
    
    @Autowired
    
UsuarioRepo rusuario;
    
    public List<Usuario> obtenerTodosUsuarios(){
     return rusuario.findAll();
    }
    
    
    public boolean guardar(Usuario e){
    boolean respuesta = false;
    try{
            rusuario.save(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al guardar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
    
    public boolean actualizar(Usuario e){
        boolean respuesta = false;
        try{
            rusuario.save(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al guardar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
    public boolean eliminar(Usuario e){
        boolean respuesta = false;
        try{
            rusuario.delete(e);
            respuesta = true;
        }catch(Exception error){
            System.out.println("Error al eliminar" + error);
            respuesta = false;
        }
        return respuesta;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;


import com.example.demo.Entity.Usuario;
import com.example.demo.Service.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Usuario")
public class UsuarioPrueba {
    
    @Autowired
    ServicioUsuario susuario;
    
   @GetMapping("/")
    public List<Usuario> prueba2(){
            return susuario.obtenerTodosUsuarios();
    }
    
@PostMapping("/guardarU")
    public List <Usuario> guardar(String username, String password, String rol){
        Usuario e = new Usuario();
        e.setUsername(username);
        e.setPassword(password);
        e.setRol(rol);
        
        if(susuario.guardar(e)){
             return susuario.obtenerTodosUsuarios();
        }
       return null;
    }
    
    
    @PutMapping("/actualizarU")
    public List <Usuario> actualizar(String username, String password, String rol){
        Usuario e = new Usuario();
        e.setUsername(username);
        e.setPassword(password);
        e.setRol(rol);
        
        if(susuario.guardar(e)){
             return susuario.obtenerTodosUsuarios();
        }
       return null;
    }
    
    @DeleteMapping("/eliminarU")
   public List <Usuario> eliminar(String username, String password, String rol){
        Usuario e = new Usuario();
        e.setUsername(username);
        e.setPassword(password);
        e.setRol(rol);
        
        if(susuario.guardar(e)){
             return susuario.obtenerTodosUsuarios();
        }
       return null;
    }
}

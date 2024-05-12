/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alumno")
public class Alumno {
    @Id
    private int id_alumno;
    private String nombreA;
    private String apellidoP;
    private String apellidoM;
    private int edad;
   
    
    @ManyToOne(fetch = FetchType.EAGER)
    //Solo llama a los maestro cuando sea necesario.
    @JoinColumn(name = "id_maestro")
    private Maestro id_maestro;

    public Alumno() {
    }

    public Alumno(int id_alumno, String nombreA, String apellidoP, String apellidoM, int edad, Maestro id_maestro) {
        this.id_alumno = id_alumno;
        this.nombreA = nombreA;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.id_maestro = id_maestro;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Maestro getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(Maestro id_maestro) {
        this.id_maestro = id_maestro;
    }
    
}

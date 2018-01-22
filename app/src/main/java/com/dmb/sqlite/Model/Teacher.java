package com.dmb.sqlite.Model;

/**
 * Created by davidmari on 22/1/18.
 */

public class Teacher {
    private String nombre, ciclo, curso, despacho;
    private int edad;

    public Teacher(String nombre, String ciclo, String curso, String despacho, int edad) {
        this.nombre=nombre;
        this.ciclo=ciclo;
        this.curso=curso;
        this.despacho=despacho;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
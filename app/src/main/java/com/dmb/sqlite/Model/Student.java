package com.dmb.sqlite.Model;

/**
 * Created by davidmari on 22/1/18.
 */

public class Student {
    private String nombre, ciclo, curso;
    private int edad, nota;

    public Student(String nombre, String ciclo, String curso, int nota, int edad) {
        this.nombre=nombre;
        this.ciclo=ciclo;
        this.curso=curso;
        this.nota=nota;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
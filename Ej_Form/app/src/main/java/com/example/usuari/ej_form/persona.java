package com.example.usuari.ej_form;

/**
 * Created by usuari on 13/03/2018.
 */

public class persona {
    private String nombre;
    private String email;
    private int edad;

    public persona(){
    }
    public persona(String nombre, String email, int edad){
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}

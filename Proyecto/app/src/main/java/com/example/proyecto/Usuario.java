package com.example.proyecto;

public class Usuario {
    public static String nombre, apellido, correo, contraseña;
    public static int idUsuario;

    public Usuario(int idUsuario, String nombre, String apellido, String correo, String contraseña){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public Usuario(){
    }
    public int getIDUsuario() {
        return idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }
    public String getContraseña() {
        return contraseña;
    }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

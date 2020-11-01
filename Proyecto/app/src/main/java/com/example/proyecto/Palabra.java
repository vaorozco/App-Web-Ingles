package com.example.proyecto;

import java.util.ArrayList;

public class Palabra {
    public String nombre;
    public byte[] imagen;
    public byte[] sonido;
    public static ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();

    public Palabra(String nombre, byte[]  imagen, byte[]  sonido){
        this.nombre = nombre;
        this.imagen = imagen;
        this.sonido = sonido;
    }
    public Palabra(){
    }
    public String getNombre() {
        return nombre;
    }
    public byte[] getImage() {
        return imagen;
    }
    public byte[] getSonido(){ return sonido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setImage(byte[] imagen) {
        this.imagen = imagen;
    }
    public void setSonido(byte[] sonido) { this.sonido = sonido; }

    public ArrayList<Palabra> getListaPalabra() {
        return listaPalabras;
    }

    public void agregarPalabra(Palabra palabra){
        this.listaPalabras.add(palabra);
    }

}
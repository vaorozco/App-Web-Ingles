package com.example.proyecto;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Fonema {
    public String nombre;
    public byte[] imagen;
    public byte[] sonido;
    public static ArrayList<Fonema> listaFonemas = new ArrayList<Fonema>();

    public Fonema(String nombre, byte[]  imagen, byte[]  sonido){
        this.nombre = nombre;
        this.imagen = imagen;
        this.sonido = sonido;
    }
    public Fonema(){
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

    public ArrayList<Fonema> getListaFonemas() {
        return listaFonemas;
    }

    public void agregarFonema(Fonema fonema){
        this.listaFonemas.add(fonema);
    }

    public ArrayList listaNombres(){
        ArrayList listaNombresFonemas = new ArrayList<>();
        for (Fonema fonema: listaFonemas) {
            //System.out.println(fonema.getNombre());
            listaNombresFonemas.add(fonema.getNombre());
        }
        return listaNombresFonemas;
    }

    public MediaPlayer mediaPlayer = new MediaPlayer();
    public void reproducirSonido2(byte[] mp3SoundByteArray, Context context) {
        try {
            // create temp file that will hold byte array
            File tempMp3 = File.createTempFile("sonido", "mp3",context.getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();
            mediaPlayer.reset();
            FileInputStream fis = new FileInputStream(tempMp3);
            mediaPlayer.setDataSource(fis.getFD());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException ex) {
            String s = ex.toString();
            ex.printStackTrace();
        }
    }

}


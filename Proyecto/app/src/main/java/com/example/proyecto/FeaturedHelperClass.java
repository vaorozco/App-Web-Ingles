package com.example.proyecto;

import android.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FeaturedHelperClass {

    byte[] imagen;
    String nombre;
    byte[] sonido;

    public FeaturedHelperClass(byte[] image, String title, byte[] sonido) {
        this.imagen = image;
        this.nombre = title;
        this.sonido = sonido;
    }

    public byte[] getImage() {
        return imagen;
    }

    public String getTitle() {
        return nombre;
    }

    public byte[] getSonido() {
        return sonido;
    }

}

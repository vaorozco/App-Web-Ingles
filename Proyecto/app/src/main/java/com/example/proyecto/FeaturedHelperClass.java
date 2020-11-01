package com.example.proyecto;

import android.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FeaturedHelperClass {

    int image;
    String title, description;
    byte[] sonido;

    public FeaturedHelperClass(int image, String title, byte[] sonido) {
        this.image = image;
        this.title = title;
        this.sonido = sonido;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public byte[] getSonido() {
        return sonido;
    }

    public String getDescription() {
        return description;
    }

}

package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class VerFonema extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    int idFonema;
    String nombreFonema;
    byte[] bytesImagenFonema, bytesSonidoFonema;
    TextView textViewFonema;
    ImageView imagenFonema, parlanteFonema, imagenPalabra1, imagenPalabra2, imagenPalabra3, parlantePalabra1, parlantePalabra2, parlantePalabra3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fonema);
        Fonema fonema = new Fonema();//se utiliza para método reproducirSonido2()
        //recyclerView palabras con fonemas
        recyclerView = findViewById(R.id.recyclerView);

        //Aquí iría procedimiento para traer palabras con sus imágenes
        //Del Banco de Fonemas, se recibe un int con el fonema seleccionado y se ejecuta ese sp con ese int, para obtener palabras que tienen ese fonema

       // textViewFonema = findViewById(R.id.textView19);
        imagenFonema = findViewById(R.id.imageView10);
        parlanteFonema = findViewById(R.id.imageView11);
        Intent i = getIntent();
        //idFonema = i.getIntExtra("idFonema",0);
        nombreFonema = i.getStringExtra("nombreFonema");
        bytesImagenFonema = i.getByteArrayExtra("imagenFonema");
        bytesSonidoFonema = i.getByteArrayExtra("sonidoFonema");
        //textViewFonema.setText(nombreFonema);
        Bitmap bitmapImagen = BitmapFactory.decodeByteArray(bytesImagenFonema,0,bytesImagenFonema.length);
        imagenFonema.setImageBitmap(bitmapImagen);
        //imagenFonema.setImageResource(R.drawable.mypost);

        parlanteFonema.setOnClickListener(new View.OnClickListener() { //suena sonido al dar click al parlante
            @Override
            public void onClick(View v) {
                //reproducirSonido(bytesSonidoFonema,VerFonema.this); funciona 100%
                fonema.reproducirSonido2(bytesSonidoFonema,VerFonema.this);
            }
        });

        recycler();

    }

    private void recycler(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.juegos,nombreFonema, bytesSonidoFonema));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bancofonemas,"Logo de Banco",bytesSonidoFonema));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.memoria,"Logo de Memoria",bytesSonidoFonema));

        adapter = new FeaturedAdapter(featuredLocations, VerFonema.this);
        recyclerView.setAdapter(adapter);

    }

    public MediaPlayer mediaPlayer = new MediaPlayer();
    public void reproducirSonido(byte[] mp3SoundByteArray, Context context) {
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
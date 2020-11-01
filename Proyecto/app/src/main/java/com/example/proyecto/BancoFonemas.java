package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BancoFonemas extends AppCompatActivity implements View.OnClickListener {
    ImageView imagenPrueba;
    TextView nombreFonema, textView19;
    Fonema fonema = new Fonema();
    ImageView parlante, fonema1, fonema2, fonema3, fonema4, fonema5, fonema6, fonema7, fonema8, fonema9, fonema10, fonema11, fonema12, fonema13, fonema14, fonema15,
            fonema16, fonema17,fonema18,fonema19,fonema20,fonema21,fonema22,fonema23,fonema24,fonema25,fonema26,fonema27,fonema28,fonema29,fonema30,fonema31,
            fonema32,fonema33,fonema34,fonema35,fonema36;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_fonemas);
        fonema1 = findViewById(R.id.fonema1); fonema1.setOnClickListener(this); fonema2 = findViewById(R.id.fonema2); fonema2.setOnClickListener(this);
        fonema3 = findViewById(R.id.fonema3); fonema3.setOnClickListener(this); fonema4 = findViewById(R.id.fonema4); fonema4.setOnClickListener(this);
        fonema5 = findViewById(R.id.fonema5); fonema5.setOnClickListener(this); fonema6 = findViewById(R.id.fonema6); fonema6.setOnClickListener(this);
        fonema7 = findViewById(R.id.fonema7); fonema7.setOnClickListener(this); fonema8 = findViewById(R.id.fonema8); fonema8.setOnClickListener(this);
        fonema9 = findViewById(R.id.fonema9); fonema9.setOnClickListener(this); fonema10 = findViewById(R.id.fonema10); fonema10.setOnClickListener(this);
        fonema11 = findViewById(R.id.fonema11); fonema11.setOnClickListener(this); fonema12 = findViewById(R.id.fonema12); fonema12.setOnClickListener(this);
        fonema13 = findViewById(R.id.fonema13); fonema13.setOnClickListener(this); fonema14 = findViewById(R.id.fonema14); fonema14.setOnClickListener(this);
        fonema15 = findViewById(R.id.fonema15); fonema15.setOnClickListener(this); fonema16 = findViewById(R.id.fonema16); fonema16.setOnClickListener(this);
        fonema17 = findViewById(R.id.fonema17); fonema17.setOnClickListener(this); fonema18 = findViewById(R.id.fonema18); fonema18.setOnClickListener(this);
        fonema19 = findViewById(R.id.fonema19); fonema19.setOnClickListener(this); fonema20 = findViewById(R.id.fonema20); fonema20.setOnClickListener(this);
        fonema21 = findViewById(R.id.fonema21); fonema21.setOnClickListener(this); fonema22 = findViewById(R.id.fonema22); fonema22.setOnClickListener(this);
        fonema23 = findViewById(R.id.fonema23); fonema23.setOnClickListener(this); fonema24 = findViewById(R.id.fonema24); fonema24.setOnClickListener(this);
        fonema25 = findViewById(R.id.fonema25); fonema25.setOnClickListener(this); fonema26 = findViewById(R.id.fonema26); fonema26.setOnClickListener(this);
        fonema27 = findViewById(R.id.fonema27); fonema27.setOnClickListener(this); fonema28 = findViewById(R.id.fonema28); fonema28.setOnClickListener(this);
        fonema29 = findViewById(R.id.fonema29); fonema29.setOnClickListener(this); fonema30 = findViewById(R.id.fonema30); fonema30.setOnClickListener(this);
        fonema31 = findViewById(R.id.fonema31); fonema31.setOnClickListener(this); fonema32 = findViewById(R.id.fonema32); fonema32.setOnClickListener(this);
        fonema33 = findViewById(R.id.fonema33); fonema33.setOnClickListener(this); fonema34 = findViewById(R.id.fonema34); fonema34.setOnClickListener(this);
        fonema35 = findViewById(R.id.fonema35); fonema35.setOnClickListener(this); fonema36 = findViewById(R.id.fonema36); fonema36.setOnClickListener(this);

        imagenPrueba = findViewById(R.id.imageView6);
        nombreFonema = findViewById(R.id.textView5);
        //textView19 = findViewById(R.id.textView19); //prueba enviar nombre fonema a otro activity
        parlante = findViewById(R.id.imageView7);
        Bitmap bitmapImagen = BitmapFactory.decodeByteArray(fonema.getListaFonemas().get(0).getImage(),0,fonema.getListaFonemas().get(0).getImage().length);
        imagenPrueba.setImageBitmap(bitmapImagen);
        nombreFonema.setText(fonema.getListaFonemas().get(0).getNombre());
        //nombreFonema.setText(fonema.getNombre());
        parlante.setOnClickListener(new View.OnClickListener() { //suena sonido al dar click al parlante
            @Override
            public void onClick(View v) {
                //reproducirFonema(fonema.getListaFonemas().get(0).getSonido());
                fonema.reproducirSonido2(fonema.getListaFonemas().get(0).getSonido(),BancoFonemas.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String id = id = getResources().getResourceEntryName(v.getId());
        int idFonema = Integer.parseInt(id.replace("fonema","")); //se elimina la palabra fonema del recurso obtenido y se convierte a int. Ej: fonema1 -> 1
        System.out.println("ESTE ES EL IDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD:"+idFonema);
        Intent intent = new Intent(getApplicationContext(), VerFonema.class);
        intent.putExtra("idFonema",1);
        intent.putExtra("nombreFonema",fonema.getListaFonemas().get(0).getNombre());
        intent.putExtra("imagenFonema",fonema.getListaFonemas().get(0).getImage());
        intent.putExtra("sonidoFonema",fonema.getListaFonemas().get(0).getSonido());
        startActivity(intent);
       /* if (v.getId() == R.id.fonema1){
        //Intent intent = new Intent(getApplicationContext(), VerFonema.class);
        intent.putExtra("idFonema",1);
        intent.putExtra("nombreFonema",fonema.getListaFonemas().get(0).getNombre());
        intent.putExtra("imagenFonema",fonema.getListaFonemas().get(0).getImage());
        intent.putExtra("sonidoFonema",fonema.getListaFonemas().get(0).getSonido());
        startActivity(intent);
        //textView19.setText(fonema.getListaFonemas().get(0).getNombre());
        }
        else if (v.getId() == R.id.fonema2){
        // en cada uno enviar nombre, imagen y sonido del fonema
            //Intent intent = new Intent(getApplicationContext(), VerFonema.class);
            intent.putExtra("idFonema",2);
            intent.putExtra("nombreFonema",fonema.getListaFonemas().get(1).getNombre());
            intent.putExtra("imagenFonema",fonema.getListaFonemas().get(1).getImage());
            intent.putExtra("sonidoFonema",fonema.getListaFonemas().get(1).getSonido());
            startActivity(intent);
        }
        else if (v.getId() == R.id.fonema3){

        }
        else if (v.getId() == R.id.fonema4) {

        }
        else if (v.getId() == R.id.fonema5) {

        }
        else if (v.getId() == R.id.fonema6) {

        }
        else if (v.getId() == R.id.fonema7) {

        }
        else if (v.getId() == R.id.fonema8) {

        }
        else if (v.getId() == R.id.fonema9) {

        }
        else if (v.getId() == R.id.fonema10) {


        }
        else if (v.getId() == R.id.fonema11) {

        }
        else if (v.getId() == R.id.fonema12) {

        }
        else if (v.getId() == R.id.fonema13) {

        }
        else if (v.getId() == R.id.fonema14) {

        }
        else if (v.getId() == R.id.fonema15) {

        }
        else if (v.getId() == R.id.fonema16) {

        }
        else if (v.getId() == R.id.fonema17) {

        }
        else if (v.getId() == R.id.fonema18) {

        }
        else if (v.getId() == R.id.fonema19) {

        }
        else if (v.getId() == R.id.fonema20) {

        }
        else if (v.getId() == R.id.fonema21) {

        }
        else if (v.getId() == R.id.fonema22) {

        }
        else if (v.getId() == R.id.fonema23) {

        }
        else if (v.getId() == R.id.fonema24) {

        }
        else if (v.getId() == R.id.fonema25) {


        }
        else if (v.getId() == R.id.fonema26) {

        }
        else if (v.getId() == R.id.fonema27) {

        }
        else if (v.getId() == R.id.fonema28) {

        }
        else if (v.getId() == R.id.fonema29) {

        }
        else if (v.getId() == R.id.fonema30) {

        }
        else if (v.getId() == R.id.fonema31) {

        }
        else if (v.getId() == R.id.fonema32) {

        }
        else if (v.getId() == R.id.fonema33) {

        }
        else if (v.getId() == R.id.fonema34) {

        }
        else if (v.getId() == R.id.fonema35) {

        }
        else if (v.getId() == R.id.fonema36) {

        }*/

    }


    private MediaPlayer mediaPlayer = new MediaPlayer();
    private void reproducirFonema(byte[] mp3SoundByteArray) {
        try {
            // create temp file that will hold byte array
            File tempMp3 = File.createTempFile("sonidoFonema", "mp3", getCacheDir());
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
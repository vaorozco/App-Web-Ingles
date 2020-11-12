package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.proyecto.ConnectionHelper.conexionBD;

public class VerFonema extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    int idFonema;
    String nombreFonema;
    byte[] bytesImagenFonema, bytesSonidoFonema;
    TextView textViewFonema;
    ImageView imagenFonema, parlanteFonema, imagenPalabra1, imagenPalabra2, imagenPalabra3, parlantePalabra1, parlantePalabra2, parlantePalabra3;
    ProgressDialog progressDialog;
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
        idFonema = i.getIntExtra("idFonema",1);
        nombreFonema = i.getStringExtra("nombreFonema");
        bytesImagenFonema = i.getByteArrayExtra("imagenFonema");
        bytesSonidoFonema = i.getByteArrayExtra("sonidoFonema");
        //textViewFonema.setText(nombreFonema);
        Bitmap bitmapImagen = BitmapFactory.decodeByteArray(bytesImagenFonema,0,bytesImagenFonema.length);
        imagenFonema.setImageBitmap(bitmapImagen);
        //imagenFonema.setImageResource(R.drawable.mypost);

        try {//progressDialog = ProgressDialog.show(getApplicationContext(),"Cargando Imágenes","Por favor espere...",false,false);
            recycler(idFonema);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //progressDialog.dismiss();
        parlanteFonema.setOnClickListener(new View.OnClickListener() { //suena sonido al dar click al parlante
            @Override
            public void onClick(View v) {
                //reproducirSonido(bytesSonidoFonema,VerFonema.this); funciona 100%
                fonema.reproducirSonido2(bytesSonidoFonema,VerFonema.this);
            }
        });
    }

    private void recycler(int idFonema)throws SQLException {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Palabra palabra = new Palabra();
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        //ConnectionHelper con = new ConnectionHelper();
        //Connection connect = conexionBD();
        CallableStatement spIDPalabra = conexionBD().prepareCall("{call dbo.SeleccionarPalabrasFonema(?)}");
        spIDPalabra.setInt(1,idFonema);
        //System.out.println("IDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"+idFonema);
        ResultSet rsIDPalabra = spIDPalabra.executeQuery();

        while(rsIDPalabra.next()){
            int idPalabra = rsIDPalabra.getInt(1);

            featuredLocations.add(new FeaturedHelperClass(palabra.getListaPalabra().get(idPalabra-1).getImage(),
                                                          palabra.getListaPalabra().get(idPalabra-1).getNombre(),
                                                          palabra.getListaPalabra().get(idPalabra-1).getSonido()));
        }
        rsIDPalabra.close();
        spIDPalabra.close();
        conexionBD().close();
        /*featuredLocations.add(new FeaturedHelperClass(R.drawable.juegos,nombreFonema, bytesSonidoFonema));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bancofonemas,"Logo de Banco",bytesSonidoFonema));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.memoria,"Logo de Memoria",bytesSonidoFonema));*/
        adapter = new FeaturedAdapter(featuredLocations, VerFonema.this);
        recyclerView.setAdapter(adapter);
    }

    /*public MediaPlayer mediaPlayer = new MediaPlayer();
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
    }*/
}
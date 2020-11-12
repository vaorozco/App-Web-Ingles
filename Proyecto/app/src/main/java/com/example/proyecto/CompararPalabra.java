package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.io.IOException;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.example.proyecto.ConnectionHelper.conexionBD;

public class CompararPalabra extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{//, AdapterView.OnItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button botonGrabar, botonParar, botonEscucharPalabra ,botonEscucharme;
    String pathSave = "";
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    TextView textView;
    final int REQUEST_PERMISSION_CODE=1000;
    Fonema fonema = new Fonema();
    Spinner spinner, spinner2;
    Palabra palabra = new Palabra();
    ArrayList listaNombresPalabras = new ArrayList<>();
    ArrayList<byte[]> listaSonidosPalabras = new ArrayList<byte[]>();
    //ArrayList listaSonidosPalabras = new ArrayList<byte[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_palabra);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar6);
        /*-------------------------------------Toolbar-------------------------------------*/
        //setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this); //esto activa los botones del menú
        View header = navigationView.getHeaderView(0);

        textView = header.findViewById(R.id.nombreMenu);
        //navigationView.setCheckedItem(R.id.nav_home);

        if(!checkPermissionFromDevice())
            requestPermission();
        spinner = findViewById(R.id.spinner3);
        spinner2 = findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fonema.listaNombres());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        botonEscucharPalabra = findViewById(R.id.botonEscucharPalabra);
        botonGrabar = findViewById(R.id.botonGrabar); //button1 boton grabar
        botonParar = findViewById(R.id.botonParar); //button2 boton parar
        botonEscucharme = findViewById(R.id.botonEscucharme); //button3 boton escucharme

        botonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                if (checkPermissionFromDevice()){
                    pathSave = getExternalCacheDir().getAbsolutePath();
                    pathSave+= "/audiorecordtest.3gp";
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    setupMediaRecorder();
                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    botonParar.setVisibility(View.VISIBLE);
                    botonParar.setEnabled(true);
                    botonEscucharme.setEnabled(false);
                    Toast.makeText(CompararPalabra.this, "Grabando...", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestPermission();
                }
            }
        });

        botonParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                botonParar.setEnabled(false);
                botonEscucharme.setEnabled(true);
                botonGrabar.setEnabled(true);
            }
        });

        botonEscucharme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonParar.setVisibility(View.INVISIBLE);
                botonParar.setEnabled(false);
                botonEscucharme.setEnabled(true);
                botonGrabar.setEnabled(true);
                mediaPlayer = new MediaPlayer();
                try{
                    mediaPlayer.setDataSource(pathSave);
                    mediaPlayer.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                mediaPlayer.start();
                Toast.makeText(CompararPalabra.this,"Sonando...",Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listaNombresPalabras.removeAll(listaNombresPalabras);
                listaSonidosPalabras.removeAll(listaSonidosPalabras);
                try {CallableStatement spIDPalabra = conexionBD().prepareCall("{call dbo.SeleccionarPalabrasFonema(?)}");
                    spIDPalabra.setInt(1,position+1);
                    ResultSet rsIDPalabra = spIDPalabra.executeQuery();
                    while(rsIDPalabra.next()){
                        int idPalabra = rsIDPalabra.getInt(1);
                        listaNombresPalabras.add(palabra.getListaPalabra().get(idPalabra-1).getNombre());
                        byte[] sonido = palabra.getListaPalabra().get(idPalabra-1).getSonido();
                        listaSonidosPalabras.add(sonido);
                    }
                    rsIDPalabra.close();
                    spIDPalabra.close();
                    conexionBD().close();
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                spinner2.setAdapter(new ArrayAdapter<String>(CompararPalabra.this,android.R.layout.simple_spinner_dropdown_item,
                        listaNombresPalabras));

                //set divSpinner Visibility to Visible
                //spinner2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "Palabra seleccionada: "+listaNombresPalabras.get(position) ,Toast.LENGTH_SHORT).show();
                botonEscucharPalabra.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //fonema.reproducirSonido2((byte[]) listaSonidosPalabras.get(position),CompararPalabra.this);
                        fonema.reproducirSonido2(listaSonidosPalabras.get(position),CompararPalabra.this);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });





    }

    /*@Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        System.out.println("POSITIONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN"+ position);
        Toast.makeText(getApplicationContext(), "Fonema seleccionado: "+fonema.listaNombres().get(position) ,Toast.LENGTH_SHORT).show();
        try {CallableStatement spIDPalabra = conexionBD().prepareCall("{call dbo.SeleccionarPalabrasFonema(?)}");
        spIDPalabra.setInt(1,position+1);
        ResultSet rsIDPalabra = spIDPalabra.executeQuery();
        while(rsIDPalabra.next()){
            int idPalabra = rsIDPalabra.getInt(1);
            listaNombresPalabras.add(palabra.getListaPalabra().get(idPalabra-1).getNombre());
        }
        rsIDPalabra.close();
        spIDPalabra.close();
        conexionBD().close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        spinner2.setAdapter(new ArrayAdapter<String>(CompararPalabra.this,android.R.layout.simple_spinner_dropdown_item,
                listaNombresPalabras));
        /*spinner2 = findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fonema.listaNombres());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        //spinner.setAdapter(adapter);
        /*spinner2.setOnItemSelectedListener(this);

        botonEscucharPalabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fonema.reproducirSonido2(palabra.getListaPalabra().get(position).getSonido(),CompararPalabra.this);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    private void setupMediaRecorder(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(pathSave);

    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{
                WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        },REQUEST_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case REQUEST_PERMISSION_CODE:
            {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"Permiso Obtenido",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this,"Permiso Denegado", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

    private boolean checkPermissionFromDevice(){
        int write_external_storage_result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent1 = new Intent(getApplicationContext(),MiPerfil.class);
                startActivity(intent1);
                break;
            case R.id.nav_exit:
                Intent intent2 = new Intent(getApplicationContext(),Login.class);
                startActivity(intent2);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
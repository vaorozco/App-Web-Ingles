package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.io.File;
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

import java.util.UUID;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class CompararFonema extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Button botonGrabar, botonParar, botonEscucharme, botonEscucharFonema;
    String pathSave = "";
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    TextView textView;
    final int REQUEST_PERMISSION_CODE=1000;
    Fonema fonema = new Fonema();

    //String[] letras = { "A", "B", "C", "D", "E" }; //lista para Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_fonema);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar5);
        /*-------------------------------------Toolbar-------------------------------------*/
        //setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        Usuario usuario = new Usuario();
        textView = header.findViewById(R.id.nombreMenu);
        //navigationView.setCheckedItem(R.id.nav_home);
        if(!checkPermissionFromDevice())
            requestPermission();
        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fonema.listaNombres());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        botonEscucharFonema = findViewById(R.id.botonEscucharFonema);
        botonGrabar = findViewById(R.id.botonGrabar); //button1 boton grabar
        botonParar = findViewById(R.id.botonParar); //button2 boton parar
        botonEscucharme = findViewById(R.id.botonEscucharme); //button3 boton escucharme

        /*botonEscucharFonema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fonema.reproducirSonido2(fonema.getListaFonemas().get(0).getSonido(),CompararFonema.this);
            }
        });*/

            botonGrabar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v){

                    if (checkPermissionFromDevice()){
                    /*pathSave = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"
                            + UUID.randomUUID().toString() + "_audio_record.3gp";*/
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
                    botonGrabar.setEnabled(false);//se agregó
                    botonParar.setVisibility(View.VISIBLE);
                    botonParar.setEnabled(true);
                    botonEscucharme.setEnabled(false);
                    Toast.makeText(CompararFonema.this, "Grabando...", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(CompararFonema.this,"Sonando...",Toast.LENGTH_SHORT).show();

                }
            });
        }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        botonEscucharFonema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fonema.reproducirSonido2(fonema.getListaFonemas().get(position).getSonido(),CompararFonema.this);
            }
        });
        Toast.makeText(getApplicationContext(), "Fonema seleccionado: "+fonema.listaNombres().get(position) ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void setupMediaRecorder(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(pathSave);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

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

    //@Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    //@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this,MenuPrincipal.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                Intent intent1 = new Intent(this,MiPerfil.class);
                startActivity(intent1);
                break;
            case R.id.nav_exit:
                Intent intent2 = new Intent(this,Login.class);
                startActivity(intent2);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
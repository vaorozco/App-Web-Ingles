package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static android.text.TextUtils.isEmpty;
import static com.example.proyecto.ConnectionHelper.conexionBD;

public class MiPerfil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

        DrawerLayout drawerLayout;
        NavigationView navigationView;
        Toolbar toolbar;
        TextView textView, nombre, apellido, correo, contraseña;
        Button guardarCambios;
        //Button modificarPerfil;
        //String nombreModificado, apellidoModificado, contraseñaModificada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar4);
        nombre = findViewById(R.id.nombrePerfil);
        apellido = findViewById(R.id.apellidoPerfil);
        correo = findViewById(R.id.correoPerfil);
        contraseña = findViewById(R.id.contraseñaPerfil2);
        guardarCambios = findViewById(R.id.modificarPerfil);
        guardarCambios.setOnClickListener(this);
        /*-------------------------------------Toolbar-------------------------------------*/
        //setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_profile);
        View header = navigationView.getHeaderView(0);
        Usuario usuario = new Usuario();
        textView = header.findViewById(R.id.nombreMenu);
        textView.setText(usuario.getNombre()+" "+usuario.getApellido()); //nombre del usuario registrado en el header
        nombre.setText(usuario.getNombre()); //nombre del usuario registrado
        apellido.setText(usuario.getApellido()); //nombre del usuario registrado
        correo.setText(usuario.getCorreo()); //nombre del usuario registrado
        contraseña.setText(usuario.getContraseña()); //nombre del usuario registrado
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.modificarPerfil){
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre.getText().toString());
            usuario.setApellido(apellido.getText().toString());
            usuario.setCorreo(correo.getText().toString());
            usuario.setContraseña(contraseña.getText().toString());
            Toast.makeText(this,"Se han realizado los cambios",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        }
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
                Intent intent = new Intent(MiPerfil.this,MenuPrincipal.class);
                startActivity(intent);
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_exit:
                Intent intent2 = new Intent(MiPerfil.this,Login.class);
                startActivity(intent2);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
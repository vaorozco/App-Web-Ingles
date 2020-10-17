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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    ImageView imagenJuegos;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar1);
        /*-------------------------------------Toolbar-------------------------------------*/
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        imagenJuegos = (ImageView) findViewById(R.id.imageView5);
        //botonRegistro = (Button) findViewById(R.id.button3);
        //textoRecuperar = (TextView) findViewById(R.id.textView2);
        imagenJuegos.setOnClickListener(this);
        //botonRegistro.setOnClickListener(this);
        //textoRecuperar.setOnClickListener(this);
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
                break;
            case R.id.nav_profile:
                Intent intent = new Intent(MenuPrincipal.this,MiPerfil.class);
                startActivity(intent);
                break;
            case R.id.nav_exit:
                Intent intent2 = new Intent(MenuPrincipal.this,Login.class);
                startActivity(intent2);
        }
    drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /*@Override
    public void onClick(View v) {
        abrirRecuperarContrasena();
    }
});*/
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageView5)
        {
            Intent intent=new Intent(getApplicationContext(),Juegos.class);
            startActivity(intent);
        }
        /*else if (v.getId()==R.id.textView2)
        {
            Intent in=new Intent(getApplicationContext(),RecuperarContrasena.class);
            startActivity(in);
        }
        else if (v.getId()==R.id.button2)
        {
            Intent in=new Intent(getApplicationContext(),MenuPrincipal.class);
            startActivity(in);
        }*/
    }

}
package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener{
    ImageView imagenJuegos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        imagenJuegos = (ImageView) findViewById(R.id.imageView5);
        //botonRegistro = (Button) findViewById(R.id.button3);
        //textoRecuperar = (TextView) findViewById(R.id.textView2);
        imagenJuegos.setOnClickListener(this);
        //botonRegistro.setOnClickListener(this);
        //textoRecuperar.setOnClickListener(this);
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
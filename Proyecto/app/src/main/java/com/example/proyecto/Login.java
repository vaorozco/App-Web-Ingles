package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button botonRegistro, botonIniciar;
    TextView textoRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //button = (Button) findViewById(R.id.button2);
        botonRegistro = (Button) findViewById(R.id.button3);
        textoRecuperar = (TextView) findViewById(R.id.textView2);
        botonRegistro.setOnClickListener(this);
        textoRecuperar.setOnClickListener(this);
    }
            /*@Override
            public void onClick(View v) {
                abrirRecuperarContrasena();
            }
        });*/
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button3)
                {
                    Intent intent=new Intent(getApplicationContext(),Registro.class);
                    startActivity(intent);
                }
                else if (v.getId()==R.id.textView2)
                {
                    Intent in=new Intent(getApplicationContext(),RecuperarContrasena.class);
                    startActivity(in);
                }
                /*switch (v.getId()) {
                    case R.id.button3:
                        Intent intent = new Intent(getApplicationContext(), Registro.class);
                        startActivity(intent);
                    case R.id.textView2:
                        Intent intentRecuperar = new Intent(getApplicationContext(), RecuperarContrasena.class);
                        startActivity(intentRecuperar);
                }*/
            }
        }

    /*public void openNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
    /*public void abrirRecuperarContrasena() {
        Intent intent = new Intent(this, RecuperarContrasena.class);
        startActivity(intent);
    }
    public void abrirRegistro() {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }*/

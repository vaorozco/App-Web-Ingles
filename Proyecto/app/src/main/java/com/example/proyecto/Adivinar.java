package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Adivinar extends AppCompatActivity implements View.OnClickListener {

    TextView palabra1, palabra2, palabra3;
    ImageView parlante;
    ArrayList<Palabra> listaPalabras = new ArrayList<>();
    Palabra palabra = new Palabra();
    Palabra objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinar);

        parlante = findViewById(R.id.parlanteAdivinar);
        parlante.setOnClickListener(this);
        palabra1 = findViewById(R.id.palabra1);
        palabra1.setOnClickListener(this);
        palabra2 = findViewById(R.id.palabra2);
        palabra2.setOnClickListener(this);
        palabra3 = findViewById(R.id.palabra3);
        palabra3.setOnClickListener(this);
        int limite = 8; // numeros random del 0 al 2 (se debe tener limite = 36 al final del proyecto)
        for (int i = 0; i < 3; i++) {
            Random rand = new Random(); //instancia de clase random
            int int_random = rand.nextInt(limite);
            if (!listaPalabras.contains(palabra.getListaPalabra().get(int_random))) {
                listaPalabras.add(palabra.getListaPalabra().get(int_random));
            } else {
                i = i - 1;
            }
        }
        objeto = listaPalabras.get(0);
        Collections.shuffle(listaPalabras);
        palabra1.setText(listaPalabras.get(0).getNombre());
        palabra2.setText(listaPalabras.get(1).getNombre());
        palabra3.setText(listaPalabras.get(2).getNombre());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.parlanteAdivinar) {
            Fonema fonema = new Fonema();
            fonema.reproducirSonido2(objeto.getSonido(), this);
        } else if (v.getId() == R.id.palabra1) {
            if (palabra1.getText() == objeto.getNombre()){
                palabra1.setTextColor(Color.parseColor("#1be350"));
                Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Adivinar.class);
                startActivity(intent);
                finish();
            }
            else{
                palabra1.setTextColor(Color.parseColor("#e31b1b"));
                Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.palabra2) {
            if (palabra2.getText() == objeto.getNombre()) {
                palabra2.setTextColor(Color.parseColor("#1be350"));
                Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Adivinar.class);
                startActivity(intent);
                finish();
            }
            else{
                palabra2.setTextColor(Color.parseColor("#e31b1b"));
                Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.palabra3) {
            if (palabra3.getText() == objeto.getNombre()) {
                palabra3.setTextColor(Color.parseColor("#1be350"));
                Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Adivinar.class);
                startActivity(intent);
                finish();
            }else{
                palabra3.setTextColor(Color.parseColor("#e31b1b"));
                Toast.makeText(this, "Respuesta Incorrecta", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
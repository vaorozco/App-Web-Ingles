package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Juegos extends AppCompatActivity implements View.OnClickListener {

    ImageView memoria, pareo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);
        memoria = findViewById(R.id.imageView9); memoria.setOnClickListener(this);
        pareo = findViewById(R.id.imageView8); pareo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageView9){
            Intent intent = new Intent(getApplicationContext(),Memoria.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.imageView8) {
            Intent intent = new Intent(getApplicationContext(), Adivinar.class);
            startActivity(intent);
        }
    }

}
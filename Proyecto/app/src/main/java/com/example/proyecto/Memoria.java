package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class Memoria extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_11, iv_12, iv_21, iv_22, iv_31, iv_32, iv_41, iv_42;
    Integer[] listaCartas = {101, 102, 103, 104, 105, 106, 107, 108};
    int image101, image102, image103, image104, image105, image106, image107, image108;
    int primerCarta, segundaCarta, primerClick, segundoClick; int numeroCarta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        iv_11 = findViewById(R.id.iv_11);
        iv_11.setOnClickListener(this);
        iv_12 = findViewById(R.id.iv_12);
        iv_12.setOnClickListener(this);
        iv_21 = findViewById(R.id.iv_21);
        iv_21.setOnClickListener(this);
        iv_22 = findViewById(R.id.iv_22);
        iv_22.setOnClickListener(this);
        iv_31 = findViewById(R.id.iv_31);
        iv_31.setOnClickListener(this);
        iv_32 = findViewById(R.id.iv_32);
        iv_32.setOnClickListener(this);
        iv_41 = findViewById(R.id.iv_41);
        iv_41.setOnClickListener(this);
        iv_42 = findViewById(R.id.iv_42);
        iv_42.setOnClickListener(this);
        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_21.setTag("2");
        iv_22.setTag("3");
        iv_31.setTag("4");
        iv_32.setTag("5");
        iv_41.setTag("6");
        iv_42.setTag("7");

        frontOfCardsResources();
        Collections.shuffle(Arrays.asList(listaCartas));


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_11) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_11, theCard);
        } else if (v.getId() == R.id.iv_12) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_12, theCard);
        } else if (v.getId() == R.id.iv_21) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_21, theCard);
        } else if (v.getId() == R.id.iv_22) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_22, theCard);
        } else if (v.getId() == R.id.iv_31) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_31, theCard);
        } else if (v.getId() == R.id.iv_32) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_32, theCard);
        } else if (v.getId() == R.id.iv_41) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_41, theCard);
        } else if (v.getId() == R.id.iv_42) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(iv_42, theCard);
        }
    }

    private void doStuff(ImageView view, int card) {
        if (listaCartas[card] == 101) {
            view.setImageResource(image101);
        } else if (listaCartas[card] == 102) {
            view.setImageResource(image102);
        } else if (listaCartas[card] == 103) {
            view.setImageResource(image103);
        } else if (listaCartas[card] == 104) {
            view.setImageResource(image104);
        } else if (listaCartas[card] == 105) {
            view.setImageResource(image105);
        } else if (listaCartas[card] == 106) {
            view.setImageResource(image106);
        } else if (listaCartas[card] == 107) {
            view.setImageResource(image107);
        } else if (listaCartas[card] == 108) {
            view.setImageResource(image108);
        }

        if (numeroCarta == 1) {
            primerCarta = listaCartas[card];
            if (primerCarta > 104) {
                primerCarta = primerCarta - 4;
            }
            numeroCarta = 2;
            primerClick = card;
            view.setEnabled(false);
        } else if (numeroCarta == 2) {
            segundaCarta = listaCartas[card];
            if (segundaCarta > 104) {
                segundaCarta = segundaCarta - 4;
            }
            numeroCarta = 1;
            segundoClick = card;
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }

    private void calculate() {


        if (primerCarta == segundaCarta) {
            if (primerClick == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (primerClick == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (primerClick == 2) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (primerClick == 3) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (primerClick == 4) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (primerClick == 5) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (primerClick == 6) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (primerClick == 7) {
                iv_42.setVisibility(View.INVISIBLE);
            }

            if (segundoClick == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 2) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 3) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 4) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 5) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 6) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (segundoClick == 7) {
                iv_42.setVisibility(View.INVISIBLE);
            }
        }
        else{
            iv_11.setImageResource(R.drawable.fonet);
            iv_12.setImageResource(R.drawable.fonet);
            iv_21.setImageResource(R.drawable.fonet);
            iv_22.setImageResource(R.drawable.fonet);
            iv_31.setImageResource(R.drawable.fonet);
            iv_32.setImageResource(R.drawable.fonet);
            iv_41.setImageResource(R.drawable.fonet);
            iv_42.setImageResource(R.drawable.fonet);
        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);

        revisarResultado();

    }

    private void revisarResultado(){
        if (iv_11.getVisibility()== View.INVISIBLE &&
        iv_12.getVisibility()== View.INVISIBLE &&
        iv_21.getVisibility()== View.INVISIBLE &&
        iv_22.getVisibility()== View.INVISIBLE &&
        iv_31.getVisibility()== View.INVISIBLE &&
        iv_32.getVisibility()== View.INVISIBLE &&
        iv_41.getVisibility()== View.INVISIBLE &&
        iv_42.getVisibility()== View.INVISIBLE){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Memoria.this);
            alertDialogBuilder.setMessage("Juego Terminado").setCancelable(false)
            .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            })
            .setPositiveButton("Juego Nuevo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent = new Intent(getApplicationContext(),Memoria.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


    }

    private void frontOfCardsResources() {
        image101 = R.drawable.bancofonemas;
        image102 = R.drawable.compararfonemas;
        image103 = R.drawable.compararpalabras;
        image104 = R.drawable.juegos;
        image105 = R.drawable.bancofonemas;
        image106 = R.drawable.compararfonemas;
        image107 = R.drawable.compararpalabras;
        image108 = R.drawable.juegos;
    }


}
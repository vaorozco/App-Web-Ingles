package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Memoria extends AppCompatActivity implements View.OnClickListener {

    TextView iv_11, iv_21, iv_31, iv_41; //iv_22, iv_31, iv_42;
    ImageView iv_12, iv_22, iv_32, iv_42;
    ArrayList<Integer> listaCartas = new ArrayList<>();
    ArrayList<Integer> listaTextos = new ArrayList<>(Arrays.asList(101, 102, 103, 104));
    ArrayList<Integer> listaImagenes = new ArrayList<>(Arrays.asList(105, 106, 107, 108));
    int primerCarta, segundaCarta, primerClick, segundoClick;
    int numeroCarta = 1;
    List<Integer> listaRandom = new ArrayList<>();
    ArrayList<Palabra> listaPalabras = new ArrayList<>();
    Palabra palabra = new Palabra();
    TextView[] listaTextView = {iv_11, iv_21, iv_31, iv_41};
    ImageView[] listaImageView = {iv_12, iv_22, iv_32, iv_42};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        Collections.shuffle(listaTextos);
        Collections.shuffle(listaImagenes);

        int limite = 4; // numeros random del 0 al 3 (se debe tener limite = 36 al final del proyecto)
        for (int i = 0; i < 4; i++) {
            Random rand = new Random(); //instance of random class
            int int_random = rand.nextInt(limite);
            if (!listaRandom.contains(int_random)) {
                listaRandom.add(int_random);
            } else {
                i = i - 1;
            }
        }

        int tag = -1;
        for (int i = 0; i < 4; i++) {
            tag = tag + 1;
            int num = i + 1;
            String vista = "iv_" + num + "1"; //idea de trabajar con el Tag
            int resID = getApplicationContext().getResources().getIdentifier(vista.toLowerCase(), "id",this.getPackageName());
            listaTextView[i] = ((TextView) findViewById(resID));
            int num1 = listaTextos.get(i) - 101;
            listaCartas.add(listaTextos.get(i));
            listaTextView[i].setOnClickListener(this);
            listaTextView[i].setText(palabra.getListaPalabra().get(listaRandom.get(num1)).getNombre());
            listaTextView[i].setTag(Integer.toString(tag));

            tag = tag + 1;
            String vista2 = "iv_" + num + "2"; //idea de trabajar con el Tag
            int resID2 = getApplicationContext().getResources().getIdentifier(vista2.toLowerCase(), "id",this.getPackageName());
            listaImageView[i] = ((ImageView) findViewById(resID2));
            listaImageView[i].setOnClickListener(this);
            int num2 = listaImagenes.get(i) - 105;
            listaCartas.add(listaImagenes.get(i));
            Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(num2)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(num2)).getImage().length);
            listaImageView[i].setImageBitmap(bitmapImagen);
            listaImageView[i].setTag(Integer.toString(tag));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_11) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaTextView[0], theCard);
        } else if (v.getId() == R.id.iv_12) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaImageView[0], theCard);
        } else if (v.getId() == R.id.iv_21) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaTextView[1], theCard);
        } else if (v.getId() == R.id.iv_22) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaImageView[1], theCard);
        } else if (v.getId() == R.id.iv_31) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaTextView[2], theCard);
        } else if (v.getId() == R.id.iv_32) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaImageView[2], theCard);
        } else if (v.getId() == R.id.iv_41) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaTextView[3], theCard);
        } else if (v.getId() == R.id.iv_42) {
            int theCard = Integer.parseInt((String) v.getTag());
            doStuff(listaImageView[3], theCard);
        }
    }

    private void doStuff(View view, int card) {
        if (numeroCarta == 1) {
            primerCarta = listaCartas.get(card);
            if (primerCarta > 104) {
                primerCarta = primerCarta - 4;
            }
            numeroCarta = 2;
            primerClick = card;
            view.setEnabled(false);
        } else if (numeroCarta == 2) {
            segundaCarta = listaCartas.get(card);
            if (segundaCarta > 104) {
                segundaCarta = segundaCarta - 4;
            }
            numeroCarta = 1;
            segundoClick = card;
            listaTextView[0].setEnabled(false);
            listaImageView[0].setEnabled(false);
            listaTextView[1].setEnabled(false);
            listaImageView[1].setEnabled(false);
            listaTextView[2].setEnabled(false);
            listaImageView[2].setEnabled(false);
            listaTextView[3].setEnabled(false);
            listaImageView[3].setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calcular();
                }
            }, 1000);
        }
    }

    private void calcular() {
        if (primerCarta == segundaCarta) {
            if (primerClick == 0) {
                listaTextView[0].setVisibility(View.INVISIBLE);
            } else if (primerClick == 1) {
                listaImageView[0].setVisibility(View.INVISIBLE);
            } else if (primerClick == 2) {
                listaTextView[1].setVisibility(View.INVISIBLE);
            } else if (primerClick == 3) {
                listaImageView[1].setVisibility(View.INVISIBLE);
            } else if (primerClick == 4) {
                listaTextView[2].setVisibility(View.INVISIBLE);
            } else if (primerClick == 5) {
                listaImageView[2].setVisibility(View.INVISIBLE);
            } else if (primerClick == 6) {
                listaTextView[3].setVisibility(View.INVISIBLE);
            } else if (primerClick == 7) {
                listaImageView[3].setVisibility(View.INVISIBLE);
            }

            if (segundoClick == 0) {
                listaTextView[0].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 1) {
                listaImageView[0].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 2) {
                listaTextView[1].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 3) {
                listaImageView[1].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 4) {
                listaTextView[2].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 5) {
                listaImageView[2].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 6) {
                listaTextView[3].setVisibility(View.INVISIBLE);
            } else if (segundoClick == 7) {
                listaImageView[3].setVisibility(View.INVISIBLE);
            }
        }
        listaTextView[0].setEnabled(true);
        listaImageView[0].setEnabled(true);
        listaTextView[1].setEnabled(true);
        listaImageView[1].setEnabled(true);
        listaTextView[2].setEnabled(true);
        listaImageView[2].setEnabled(true);
        listaTextView[3].setEnabled(true);
        listaImageView[3].setEnabled(true);
        revisarResultado();
    }

    private void revisarResultado() {
        if (listaTextView[0].getVisibility() == View.INVISIBLE && listaImageView[0].getVisibility() == View.INVISIBLE && listaTextView[1].getVisibility() == View.INVISIBLE &&
                listaImageView[1].getVisibility() == View.INVISIBLE && listaTextView[2].getVisibility() == View.INVISIBLE && listaImageView[2].getVisibility() == View.INVISIBLE &&
                listaTextView[3].getVisibility() == View.INVISIBLE && listaImageView[3].getVisibility() == View.INVISIBLE) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Memoria.this);
            alertDialogBuilder.setMessage("Juego Terminado").setCancelable(false).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            }).setPositiveButton("Juego Nuevo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent = new Intent(getApplicationContext(), Memoria.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}

//código de Memoria bueno - se ocultan cartas
/*public class Memoria extends AppCompatActivity implements View.OnClickListener {

    TextView iv_11, iv_21, iv_31, iv_41; //iv_22, iv_31, iv_42;
    ImageView iv_12, iv_22, iv_32, iv_42;
    //Integer[] listaCartas = {101, 102, 103, 104,105, 106, 107, 108};
    ArrayList<Integer> listaCartas = new ArrayList<>();
    ArrayList<Integer> listaTextos = new ArrayList<>(Arrays.asList(101, 102, 103, 104));
    ArrayList<Integer> listaImagenes = new ArrayList<>(Arrays.asList(105, 106, 107, 108));
    int primerCarta, segundaCarta, primerClick, segundoClick;
    int numeroCarta = 1;
    List<Integer> listaRandom = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria);

        //iv_11 = findViewById(R.id.iv_11);
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
        iv_12.setTag("1"); //105 106 107 108
        iv_21.setTag("2");
        iv_22.setTag("3"); //105
        iv_31.setTag("4");
        iv_32.setTag("5"); //105
        iv_41.setTag("6");
        iv_42.setTag("7"); //105

        //frontOfCardsResources();
        Collections.shuffle(listaTextos);
        Collections.shuffle(listaImagenes);
        for (int i = 0; i < 4; i++) {
            listaCartas.add(listaTextos.get(i));
            listaCartas.add(listaImagenes.get(i));

        }


        int limite = 4; // numeros random del 0 al 3 (se debe tener limite = 36 al final del proyecto)
        for (int i = 0; i < 4; i++) {
            Random rand = new Random(); //instance of random class
            int int_random = rand.nextInt(limite);
            if (!listaRandom.contains(int_random)) {
                listaRandom.add(int_random);
            } else {
                i = i - 1;
            }
        }
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

    private void doStuff(View view, int card) {
        Palabra palabra = new Palabra(); // se agrega
        if (listaCartas.get(card) == 101) {
            //setImageResource(image102);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(0)).getNombre());

            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(0)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(0)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }

            //view.setImageResource(image101);
        } else if (listaCartas.get(card) == 102) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(1)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(1)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(1)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //}
            //view.setImageResource(image102); //original

        } else if (listaCartas.get(card) == 103) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(2)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(2)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(2)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //}
            //view.setImageResource(image103);
        } else if (listaCartas.get(card) == 104) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(3)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(3)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(3)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //}

            //view.setImageResource(image104);
        } else if (listaCartas.get(card) == 105) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(0)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(0)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(0)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //view.setImageResource(image105);
        } else if (listaCartas.get(card) == 106) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(1)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(1)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(1)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //view.setImageResource(image106);
        } else if (listaCartas.get(card) == 107) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(2)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(2)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(2)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //view.setImageResource(image107);
        } else if (listaCartas.get(card) == 108) {

            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(palabra.getListaPalabra().get(listaRandom.get(3)).getNombre());
            } else {
                Bitmap bitmapImagen = BitmapFactory.decodeByteArray(palabra.getListaPalabra().get(listaRandom.get(3)).getImage(), 0, palabra.getListaPalabra().get(listaRandom.get(3)).getImage().length);
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(bitmapImagen);
            }
            //imageView.setImageResource(image108);
            //view.setImageResource(image108);
        }

        if (numeroCarta == 1) {
            primerCarta = listaCartas.get(card);
            if (primerCarta > 104) {
                primerCarta = primerCarta - 4;
            }
            numeroCarta = 2;
            primerClick = card;
            //view.setEnabled(false);
        } else if (numeroCarta == 2) {
            segundaCarta = listaCartas.get(card);
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
                    calcular();
                }
            }, 1000);
        }
    }

    private void calcular() {
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
        } else {
            iv_11.setText("Memoria");
            iv_12.setImageResource(R.drawable.fonet);
            iv_21.setText("Memoria");
            iv_22.setImageResource(R.drawable.fonet);
            iv_31.setText("Memoria");
            iv_32.setImageResource(R.drawable.fonet);
            iv_41.setText("Memoria");
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

    private void revisarResultado() {
        if (iv_11.getVisibility() == View.INVISIBLE && iv_12.getVisibility() == View.INVISIBLE && iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE && iv_31.getVisibility() == View.INVISIBLE && iv_32.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE && iv_42.getVisibility() == View.INVISIBLE) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Memoria.this);
            alertDialogBuilder.setMessage("Juego Terminado").setCancelable(false).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            }).setPositiveButton("Juego Nuevo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Intent intent = new Intent(getApplicationContext(), Memoria.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}*/

package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.ImageWriter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import static com.example.proyecto.ConnectionHelper.conexionBD;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button botonRegistro, botonIniciar;
    TextView textoRecuperar;
    EditText correo, contraseña;
    String correoEntrada, contraseñaEntrada,nombre, apellido, nombreElemento;
    int IDUsuario;
    //String image;
    //Byte sonido;
    byte[] imagen, sonido;
    ConstraintLayout constraintLayout;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        botonIniciar = (Button) findViewById(R.id.button2);
        botonRegistro = (Button) findViewById(R.id.button3);
        textoRecuperar = (TextView) findViewById(R.id.textView2);
        correo = findViewById(R.id.editTextTextEmailAddress3);
        contraseña = findViewById(R.id.editTextTextPassword3);
        constraintLayout = findViewById(R.id.conLogin);
        botonIniciar.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
        textoRecuperar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) { //boton para abrir registo
            Intent intent = new Intent(getApplicationContext(), Registro.class);
            startActivity(intent);
        } else if (v.getId() == R.id.textView2) { //boton para abrir recuperarContraseña
            Intent in = new Intent(getApplicationContext(), RecuperarContrasena.class);
            startActivity(in);
        } else if (v.getId() == R.id.button2) { //botón para iniciar sesión
            if (isEmpty(correo.getText().toString()) || isEmpty(contraseña.getText().toString()))
                ShowSnackBar("Por favor complete todos los campos");
            else {
                Login.admitirUsuario admitirUsuario = new Login.admitirUsuario();
                admitirUsuario.execute("");
            }
        }
    }

    public void ShowSnackBar(String message) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG)
                .setAction("CERRAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).setActionTextColor(getResources().getColor(android.R.color.holo_red_light)).show();
    }

    public Boolean isEmpty(String strValue) {
        if (strValue == null || strValue.trim().equals(("")))
            return true;
        else
            return false;
    }

    public class admitirUsuario extends AsyncTask<String, Void, String> {
        String Correo, Contrasena; // deben ser diferentes a las primeras, estas inician con mayúscula

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Correo = correo.getText().toString();
            Contrasena = contraseña.getText().toString();
            progressDialog = ProgressDialog.show(Login.this,"Verificando Datos","Por favor espere...",false,false);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                ConnectionHelper con = new ConnectionHelper();
                Connection connect = conexionBD();
                CallableStatement sp = conexionBD().prepareCall("{call dbo.loginApp(?,?) }");
                correoEntrada = correo.getText().toString();
                contraseñaEntrada = contraseña.getText().toString();
                sp.setString(1,correoEntrada);
                sp.setString(2,contraseñaEntrada);
                ResultSet rs = sp.executeQuery();
                rs.next();
                int valorRetorno = rs.getInt(1);
                if (valorRetorno==0){
                    sp.close();
                    conexionBD().close();
                    progressDialog.dismiss();
                    ShowSnackBar("Correo o contraseña incorrectos");
                }
                else{
                    IDUsuario = rs.getInt(2);
                    nombre = rs.getString(3);
                    apellido = rs.getString(4);
                    sp.close(); // se cierra sp de loginAPP

                    //------------------------------Empieza código 2da Iteración------------------------------
                    //-------------------------------Descargar Fonemas de la BD-------------------------------

                    Usuario usuario = new Usuario(IDUsuario,nombre,apellido,correoEntrada,contraseñaEntrada);
                    CallableStatement spFonema = conexionBD().prepareCall("{call dbo.obtenerFonemas }");
                    ResultSet rsFonema = spFonema.executeQuery();
                    while(rsFonema.next()) {
                        nombreElemento = rsFonema.getString(1);
                        imagen = rsFonema.getBytes(2);
                        sonido = rsFonema.getBytes(3);
                        //byte[] bytes = android.util.Base64.decode(image, Base64.DEFAULT);
                        //Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        //imagenPrueba.setImageBitmap(bitmap);
                        //sonido = rsFonema.getByte(3);
                        //System.out.println("Nombreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "+nombreFonema);
                        //System.out.println("Imagen: "+imagen);
                        //System.out.println("Sonido: "+sonido);
                        Fonema fonema = new Fonema(nombreElemento, imagen, sonido);//, sonido);
                        fonema.agregarFonema(fonema);
                    }
                    rsFonema.close();

                    CallableStatement spPalabra = conexionBD().prepareCall("{call dbo.obtenerPalabras }");
                    ResultSet rsPalabra = spPalabra.executeQuery();
                    while(rsPalabra.next()){
                        nombreElemento = rsPalabra.getString(1);
                        imagen = rsPalabra.getBytes(2);
                        sonido = rsPalabra.getBytes(2);
                        System.out.println("Nombreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee Palabraaaaaaaaaaaaaaaaaaaaaaaaa: "+nombreElemento);
                        Palabra palabra = new Palabra(nombreElemento, imagen, sonido);
                        palabra.agregarPalabra(palabra);

                    }
                    rsPalabra.close();
                        //System.out.println("Primer Fonema------------------------------: "+fonema.listaFonemas.get(0).getNombre());
                        //System.out.println("Segundo Fonema------------------------------: "+fonema.listaFonemas.get(1).getNombre());


                    //rsFonema.close();//cierra sp obtenerFonemas
                    //------------------------------Termina código 2da Iteración------------------------------


                    conexionBD().close();
                    Intent in = new Intent(getApplicationContext(), MenuPrincipal.class); // si existe se abre menú principal
                    startActivity(in);
                }
                return "¡Bienvenido";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getMessage().toString();
            }
        }

    }
}



package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    ConstraintLayout constraintLayout;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        //button = (Button) findViewById(R.id.button2);
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
                //Intent in = new Intent(getApplicationContext(), MenuPrincipal.class);
                //startActivity(in);
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
                CallableStatement sp = conexionBD().prepareCall("{call dbo.loginCredenciales(?,?) }");
                String correoEntrada = correo.getText().toString();
                String contraseñaEntrada = contraseña.getText().toString();
                sp.setString(1,correoEntrada);
                sp.setString(2,contraseñaEntrada);
                //sp.setString(1, correo.getText().toString());
                //sp.setString(2, contraseña.getText().toString());
                ResultSet rs = sp.executeQuery();
                rs.next();
                int valorRetorno = rs.getInt(1);
                //System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+valorRetorno);
                if (valorRetorno==0){
                    progressDialog.dismiss();
                    ShowSnackBar("Correo o contraseña incorrectos");
                }
                else{
                    Intent in = new Intent(getApplicationContext(), MenuPrincipal.class); // si existe se abre menú principal
                    startActivity(in);
                   /* CallableStatement sp_obtenerUsuario = conexionBD().prepareCall("{call dbo.obtenerUsuario(?) }");
                   sp_obtenerUsuario.setString(1,correoEntrada);
                   ResultSet rs2 = sp_obtenerUsuario.executeQuery();
                   rs2.next();
                   int valor = rs2.getInt(1);
                   if (valor==0){
                    System.out.println("Error no existe usuario");
                }
                else{
                    Usuario usario = new Usuario();
                    }

                   */
                }
                sp.close();
                conexionBD().close();
                return "¡Bienvenido";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getMessage().toString();
            }
        }
    }
}



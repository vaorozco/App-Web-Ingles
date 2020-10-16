package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import static com.example.proyecto.ConnectionHelper.conexionBD;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button botonRegistro, botonIniciar;
    TextView textoRecuperar;
    EditText correo, contraseña;
    ConstraintLayout constraintLayout;

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
            //progressBar.setVisibility(View.VISIBLE);
            //botonIniciar.setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                ConnectionHelper con = new ConnectionHelper();
                Connection connect = conexionBD();
                CallableStatement sp = conexionBD().prepareCall("{ ? = call dbo.loginAPP(?,?) }");
                sp.registerOutParameter(1, java.sql.Types.INTEGER);
                sp.setString(2, correo.getText().toString());
                sp.setString(3, contraseña.getText().toString());
                sp.execute();
                int valorRetorno = sp.getInt(1); //valor retorno del sp. 1 si existe usuario, 0 no existe
                sp.close();
                conexionBD().close();
                if (valorRetorno==0){
                    ShowSnackBar("Correo o contraseña incorrectos");
                }
                else{
                    Intent in = new Intent(getApplicationContext(), MenuPrincipal.class); // si existe se abre menú principal
                    startActivity(in);
                }
                return "¡Bienvenido";
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getMessage().toString();
            } //catch (Exception e) {
               // return "Ha habido un problema con el código o la base de datos.";
            //}
        }
    }
}



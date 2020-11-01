package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.example.proyecto.ConnectionHelper.conexionBD;

public class Registro extends AppCompatActivity {
    EditText nombre, apellido, correo, contrasena, contrasena2;
    Button registrarme;
    ScrollView scrollView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.editTextTextPersonName);
        apellido = findViewById(R.id.editTextTextPersonName2);
        correo = findViewById(R.id.editTextTextEmailAddress2);
        contrasena = findViewById(R.id.editTextTextPassword);
        contrasena2 = findViewById(R.id.editTextTextPassword2);
        scrollView = findViewById(R.id.conRegistro);
        registrarme = findViewById(R.id.button5);
        this.setTitle("Registro"); //título del header
        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(nombre.getText().toString()) || isEmpty(apellido.getText().toString()) ||
                        isEmpty(correo.getText().toString()) || isEmpty(contrasena.getText().toString()) ||
                        isEmpty(contrasena2.getText().toString()))
                    Toast.makeText(Registro.this,"Por favor complete todos los campos",Toast.LENGTH_SHORT).show();
                else if (!contrasena.getText().toString().equals(contrasena2.getText().toString()))
                    Toast.makeText(Registro.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                else {
                    agregarUsuario agregarUsuario = new agregarUsuario();
                    agregarUsuario.execute("");
                }
            }
        });
    }
    public void ShowSnackBar(String message) {
        Snackbar.make(scrollView, message, Snackbar.LENGTH_LONG)
                .setAction("CERRAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }}).setActionTextColor(getResources().getColor(android.R.color.holo_red_light)).show();
    }
    public Boolean isEmpty(String strValue) {
        if (strValue == null || strValue.trim().equals(("")))
            return true;
        else
            return false;
    }

    private class agregarUsuario extends AsyncTask<String, Void, String> {
        String Nombre, Apellido, Correo, Contrasena, Contrasena2; // deben ser diferentes a las primeras, estas inician con mayúscula
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Nombre = nombre.getText().toString();
            Apellido = apellido.getText().toString();
            Correo = correo.getText().toString();
            Contrasena = contrasena.getText().toString();
            Contrasena2 = contrasena.getText().toString();
            //progressBar.setVisibility(View.VISIBLE);
            progressDialog = ProgressDialog.show(Registro.this,"Verificando Datos","Por favor espere...",false,false);
        }

        @Override
        protected String doInBackground(String... params) {//'Error ya existe este Usuario'
            try {
                ConnectionHelper con = new ConnectionHelper();
                Connection connect = conexionBD();
                CallableStatement sp = conexionBD().prepareCall("{call InsertarUsuario(?,?,?,?,?)}");
                sp.setString(1,nombre.getText().toString());
                sp.setString(2,apellido.getText().toString());
                sp.setString(3,correo.getText().toString());
                sp.setString(4,contrasena.getText().toString());
                sp.setInt(5,2);//(5,correo.getText().toString()); número 2 es tipo estudiante
                ResultSet rs = sp.executeQuery();
                rs.next();
                int valorRetorno = rs.getInt(1);
                if (valorRetorno==0){
                    progressDialog.dismiss();
                    sp.close();
                    conexionBD().close();
                    //Toast.makeText(Registro.this,"Ya existe una cuenta con ese correo",Toast.LENGTH_SHORT);
                    ShowSnackBar("Ya existe una cuenta con ese correo");
                }
                else{
                    progressDialog.dismiss();
                    ShowSnackBar("Ha sido registrado");
                    Intent in = new Intent(getApplicationContext(), Login.class); // si existe se envía al login
                    startActivity(in);
                }
                sp.close();
                conexionBD().close();
                return "Intente de Nuevo";//"Ya existe una cuenta con ese correo";

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getMessage().toString();
            }
        }

        /*@Override
        protected void onPostExecute(String result) {
            ShowSnackBar(result);
            if (result.equals("Registro exitoso")) {
                // Clear();
            }
        }*/
    }
}
package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import static com.example.proyecto.ConnectionHelper.conexionBD;

public class Registro extends AppCompatActivity {
    EditText nombre, apellido, correo, contrasena, contrasena2;
    Button registrarme;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = findViewById(R.id.editTextTextPersonName);
        apellido = findViewById(R.id.editTextTextPersonName2);
        correo = findViewById(R.id.editTextTextEmailAddress2);
        contrasena = findViewById(R.id.editTextTextPassword);
        contrasena2 = findViewById(R.id.editTextTextPassword2);
        constraintLayout = findViewById(R.id.conRegistro);
        registrarme = findViewById(R.id.button5);
        this.setTitle("Registro"); //título del header
        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(nombre.getText().toString()) || isEmpty(apellido.getText().toString()) ||
                        isEmpty(correo.getText().toString()) || isEmpty(contrasena.getText().toString()) ||
                        isEmpty(contrasena2.getText().toString()))
                    ShowSnackBar("Por favor complete todos los campos");
                else if (!contrasena.getText().toString().equals(contrasena2.getText().toString()))
                    ShowSnackBar("Las contraseñas no coinciden");
                else {
                    agregarUsuario agregarUsuario = new agregarUsuario();
                    agregarUsuario.execute("");
                }
            }
        });
    }

    public void ShowSnackBar(String message) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG)
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
            registrarme.setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                ConnectionHelper con = new ConnectionHelper();
                Connection connect = conexionBD();
                String storedProcudureCall = "{call InsertarUsuario(?,?,?,?,?)};"; //stored procedure a llamar
                CallableStatement sp = conexionBD().prepareCall(storedProcudureCall); //formato para llamar stored procedures en la base
                sp.setString(1,nombre.getText().toString());
                sp.setString(2,apellido.getText().toString());
                sp.setString(3,correo.getText().toString());
                sp.setString(4,contrasena.getText().toString());
                sp.setInt(5,2);//(5,correo.getText().toString()); número 2 es tipo estudiante
                sp.executeUpdate();
                sp.close();
                conexionBD().close();
                return "¡Ha sido registrado!";
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getMessage().toString();
            } catch (Exception e) {
                return "Exception. Please check your code and database.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            ShowSnackBar(result);
            //progressBar.setVisibility(View.GONE);
            registrarme.setVisibility(View.VISIBLE);
            if (result.equals("Added successfully")) {
                // Clear();
            }
        }
    }
}
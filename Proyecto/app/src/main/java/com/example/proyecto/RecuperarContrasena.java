package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static android.text.TextUtils.isEmpty;
import static com.example.proyecto.ConnectionHelper.conexionBD;

public class RecuperarContrasena extends AppCompatActivity  implements View.OnClickListener {

    private EditText correo; //editTextTextEmailAddress
    private Button botonRecuperar; //button4
    private String nombre, apellido, contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);
        correo = findViewById(R.id.editTextCorreo);
        //editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        //editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        botonRecuperar = findViewById(R.id.botonRecuperar);
        botonRecuperar.setOnClickListener(this);
    }

    private void sendEmail(String email, String nombre, String apellido, String contraseña) {
        String asunto = "Fonet - Recuperar Contraseña";
        String mensaje = "¡Hola " +nombre+ " " +apellido+"!"+ "\n" + "Te enviamos este correo porque solicitaste recuperar tu contraseña. Tu contraseña es: "+contraseña;
        //String subject = editTextSubject.getText().toString().trim();
        //String message = editTextMessage.getText().toString().trim();
        SendMail sm = new SendMail(this,email, asunto, mensaje);
        sm.execute();
    }
    @Override
    public void onClick(View v) {
        if (isEmpty(correo.getText().toString()))
            Toast.makeText(RecuperarContrasena.this, "Debe ingresar su correo electrónico", Toast.LENGTH_SHORT).show();
        else {
            try {

                ConnectionHelper con = new ConnectionHelper();
                Connection connect = conexionBD();
                CallableStatement sp = conexionBD().prepareCall("{call dbo.recuperarContraseña(?) }");
                String email = correo.getText().toString();
                sp.setString(1, email);
                ResultSet rs = sp.executeQuery();
                rs.next();
                int valorRetorno = rs.getInt(1);
                if (valorRetorno == 0) {
                    sp.close();
                    conexionBD().close();
                    Toast.makeText(RecuperarContrasena.this, "El correo no está registrado", Toast.LENGTH_LONG).show();
                } else {
                    nombre = rs.getString(2);
                    apellido = rs.getString(3);
                    contraseña = rs.getString(4);
                    sendEmail(email, nombre, apellido, contraseña);
                }
                sp.close();
                conexionBD().close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

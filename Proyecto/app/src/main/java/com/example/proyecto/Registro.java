package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
                pruebaConexion();
            }
        });
    }
    public Connection conexionBD(){

        Connection conexion=null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            //conexion=DriverManager.getConnection("jdbc:jtds:sqlserver://fonet.database.windows.net,1433;Initial Catalog=proyecto_fonet;Persist Security Info=False;User ID=avalverder;Password=c3rv@nt3s;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");
            //conexion=DriverManager.getConnection("jdbc:jtds:sqlserver://fonet.database.windows.net,1433;Initial Catalog=proyecto_fonet;Persist Security Info=False;User ID=avalverder;Password=c3rv@nt3s;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");
            String url = String.format("jdbc:jtds:sqlserver://fonet.database.windows.net:1433/proyecto_fonet;user=avalverder;password=c3rv@nt3s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=fonet.database.windows.net;loginTimeout=30;");
            conexion = DriverManager.getConnection(url);


            //conexion=DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.110/Examen1Bases2;instance=VAOC-PC\\MSSQLSERVER01");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public void pruebaConexion(){
        try {
            Toast.makeText(getApplicationContext(),"Conectado",Toast.LENGTH_SHORT).show();
            //jdbc:jtds:sqlserver://mymssqlserver.corp.company.com:1433/mydatabase;instance=myinstance;domain=corp.company.com;
            //Statement statement = conexionBD().createStatement();
            //String query = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values ('Conexión', 'Android', 'anddsql@hotmail.com','siuu')";
            PreparedStatement pst = conexionBD().prepareStatement("Insert into Usuario (nombre,apellido, correo, contraseña) values (?,?,?,?)");
            pst.setString(1,nombre.getText().toString());
            pst.setString(2,apellido.getText().toString());
            pst.setString(3,correo.getText().toString());
            pst.setString(4,contrasena.getText().toString());
            pst.executeUpdate();
            //statement.executeQuery(query);
            Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

}



        //registrarme.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
                //String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                //String connectionUrl = "jdbc:sqlserver://localhost//MSSQLSERVER01;database=Examen1Bases2;integratedSecurity=true;";
                /*try {
                    Class.forName(jdbcDriver);

                } catch (ClassNotFoundException ex) {
                    System.out.println("No funciona");
                }
                try (Connection con = DriverManager.getConnection(connectionUrl);) {
                    System.out.println("Conectado");
                    Statement m_Statement = con.createStatement();
                    String query = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values" +
                            "('Conexión', 'Android', 'anddsql@hotmail.com','siuu')";
                    m_Statement.executeQuery(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

                if (isEmpty(nombre.getText().toString()) || isEmpty(apellido.getText().toString()) ||
                        isEmpty(correo.getText().toString()) || isEmpty(contrasena.getText().toString()) ||
                        isEmpty(contrasena2.getText().toString()))
                    ShowSnackBar("Por favor complete todos los campos");
                else if (!contrasena.getText().toString().equals(contrasena2.getText().toString()))
                    ShowSnackBar("Las contraseñas no coinciden");
                else {
                    AddUsers addUsers = new AddUsers();
                    addUsers.execute("");*//*
                }
            }
        });
    }

    public void ShowSnackBar(String message) {
        Snackbar.make(constraintLayout, message, Snackbar.LENGTH_LONG)
                .setAction("CERRAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                .show();
    }

    public Boolean isEmpty(String strValue) {
        if (strValue == null || strValue.trim().equals(("")))
            return true;
        else
            return false;
    }

    private class AddUsers extends AsyncTask<String, Void, String> {
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
                Connection connect = ConnectionHelper.CONN();

                /*String queryStmt = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values" +
                        "('Conexión', 'Android', 'anddsql@hotmail.com','siuu22')";//"Insert into Cliente " + "(Nombre, ApellidoFamilia, Correo, Contraseña) values " +
                        //"("+ Nombre + "," + Apellido + ","+ Correo + "," + Contrasena+ ")";

                PreparedStatement preparedStatement = connect.prepareStatement(queryStmt);

                preparedStatement.executeUpdate();

                preparedStatement.close();*//*
                Statement m_Statement = connect.createStatement();
                String query = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values" +
                        "('Conexión', 'Android', 'anddsql@hotmail.com','siuu2')";
                m_Statement.executeQuery(query);

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

            //Toast.makeText(signup.this, result, Toast.LENGTH_SHORT).show();
            ShowSnackBar(result);
            //progressBar.setVisibility(View.GONE);
            registrarme.setVisibility(View.VISIBLE);
            if (result.equals("Added successfully")) {
                // Clear();
            }*/
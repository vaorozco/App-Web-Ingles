package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button botonRegistro, botonIniciar;
    TextView textoRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        //button = (Button) findViewById(R.id.button2);
        botonIniciar = (Button) findViewById(R.id.button2);
        botonRegistro = (Button) findViewById(R.id.button3);
        textoRecuperar = (TextView) findViewById(R.id.textView2);
        botonIniciar.setOnClickListener(this);
        botonRegistro.setOnClickListener(this);
        textoRecuperar.setOnClickListener(this);
    }

    public Connection conexionBD(){

        Connection conexion=null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();//fonet.database.windows.net,1433;Initial Catalog=proyecto_fonet;Persist Security Info=False;User ID=avalverder;Password=c3rv@nt3s;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";
            conexion=DriverManager.getConnection("jdbc:jtds:sqlserver://fonet.database.windows.net,1433;Initial Catalog=proyecto_fonet;Persist Security Info=False;User ID=avalverder;Password=c3rv@nt3s;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");
            //conexion=DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.110/Examen1Bases2;instance=MSSQLSERVER01");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public void pruebaConexion(){
        /*try {
            Toast.makeText(getApplicationContext(),"Conectado",Toast.LENGTH_SHORT).show();
            //jdbc:jtds:sqlserver://mymssqlserver.corp.company.com:1433/mydatabase;instance=myinstance;domain=corp.company.com;
            Statement statement = conexionBD().createStatement();
            String query = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values ('Conexión', 'Android', 'anddsql@hotmail.com','siuu')";
            //PreparedStatement pst = conexionBD().prepareStatement("Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values ('Conexión', 'Android', 'anddsql@hotmail.com','siuu')");
            //pst.executeQuery();
            statement.executeQuery(query);
            Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }*/
    }
            /*@Override
            public void onClick(View v) {
                abrirRecuperarContrasena(); 58655
            }
        });*/
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button3)
                {
                    Intent intent=new Intent(getApplicationContext(),Registro.class);
                    startActivity(intent);
                }
                else if (v.getId()==R.id.textView2)
                {
                    Intent in=new Intent(getApplicationContext(),RecuperarContrasena.class);
                    startActivity(in);
                }
                else if (v.getId()==R.id.button2)
                {
                    //Intent in=new Intent(getApplicationContext(),MenuPrincipal.class);62901
                    //startActivity(in);
                    pruebaConexion();
                }
                /*switch (v.getId()) {
                    case R.id.button3:
                        Intent intent = new Intent(getApplicationContext(), Registro.class);
                        startActivity(intent);
                    case R.id.textView2:
                        Intent intentRecuperar = new Intent(getApplicationContext(), RecuperarContrasena.class);
                        startActivity(intentRecuperar);
                }*/
            }
        }


    /*public void openNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
    /*public void abrirRecuperarContrasena() {
        Intent intent = new Intent(this, RecuperarContrasena.class);
        startActivity(intent);
    }
    public void abrirRegistro() {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }*/

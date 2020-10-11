package com.example.proyecto;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHelper {
    @SuppressLint("NewApi")
    public static Connection CONN() {

        String _user = "sa";
        String _pass = "789";
        String _DB = "Examen1Bases2";
        String _server = "138.94.57.63//MSSQLSERVER01";//ip 138.94.57.63
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        /*String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER01;database=proyectoBases;integratedSecurity=true;";*/
        //Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.0.2.2:1433/androidtest","usernameMSSQL","passwordMSSQL");
        Connection conn = null;
        String ConnURL = null;
        //try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//*net.sourceforge.jtds.jdbc.Driver").newInstance();*/
            //ConnURL = //"fonet.database.windows.net;database=proyecto_fonet;user=avalverder;password=c3rv@nt3s;;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
              //      "jdbc:sqlserver://127.0.0.1//MSSQLSERVER01;database=Examen1Bases2;integratedSecurity=true;";
                    //"jdbc:jtds:sqlserver://127.0.0.1:1433;instanceName=MSSQLSERVER01;"+ "databaseName=Examen1Bases2;integratedSecurity=true;";
            /*ConnURL = "jdbc:jtds:sqlserver://" + _server + ";"
                    + "databaseName=" + _DB + ";user=" + _user + ";password="
                    + _pass + ";";*/
            //conn = DriverManager.getConnection(ConnURL);
            //Statement m_Statement = conn.createStatement();
            //String query = "Insert into Cliente (Nombre,ApellidoFamilia, Correo, Contraseña) values" +
              //      "('Conexión', 'Android', 'androidsql@hotmail.com','siuu')";
        /*} catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }*/
        return conn;}
    }
//}

package com.example.proyecto;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionHelper {
    @SuppressLint("NewApi")
    public static Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String url = String.format("jdbc:jtds:sqlserver://fonet.database.windows.net:1433/proyecto_fonet;user=avalverder;password=c3rv@nt3s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=fonet.database.windows.net;loginTimeout=30;");
            conexion = DriverManager.getConnection(url);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conexion;
    }

}

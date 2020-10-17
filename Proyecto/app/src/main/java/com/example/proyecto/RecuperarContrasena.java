package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class RecuperarContrasena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);
    }

    /*//Log.i("Send email", "");

    String[] TO = {"vaorozco@hotmail.com"};
    //String[] CC = {"mcmohd@gmail.com"};
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    emailIntent.setData(Uri.parse("mailto:"));
    emailIntent.setType("text/plain");


      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
      emailIntent.putExtra(Intent.EXTRA_CC, CC);
      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
      emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

      try {
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        finish();
        Log.i("Finished sending email.", "");
    } catch(android.content.ActivityNotFoundException ex) {
        Toast.makeText(RecuperarContrasena.this,
                "There is no email client installed.", Toast.LENGTH_SHORT).show();
    }
*/

}
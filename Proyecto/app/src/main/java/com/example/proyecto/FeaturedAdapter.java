package com.example.proyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;
    Context context;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations, VerFonema activity) {
        this.featuredLocations = featuredLocations;
        this.context = activity;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta_palabra, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        Bitmap bitmapImagen = BitmapFactory.decodeByteArray(featuredHelperClass.getImage(),0,featuredHelperClass.getImage().length);
        //imagen.setImageBitmap(bitmapImagen);
        holder.imagen.setImageBitmap(bitmapImagen);
        //holder.imagen.setImageResource(featuredHelperClass.getImage());
        holder.palabra.setText(featuredHelperClass.getTitle());
        holder.parlante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VerFonema verFonema  = new VerFonema();
                //verFonema.reproducirSonido(featuredHelperClass.getSonido(),context); funciona 100%

                Palabra palabra = new Palabra();
                palabra.reproducirPalabra(featuredHelperClass.getSonido(),context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen, parlante;
        TextView palabra;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imagenPalabra);
            palabra = itemView.findViewById(R.id.palabra);
            parlante = itemView.findViewById(R.id.parlantePalabra);


        }
    }

}

package com.example.tusuerte;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtFrase;
    Button btnProbar;
    ImageView imagenFrase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFrase = findViewById(R.id.textFrase);
        btnProbar =findViewById(R.id.btnProbar);
        imagenFrase = findViewById(R.id.imgOK);

        btnProbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Estás probando tu suerte" , Toast.LENGTH_SHORT).show();
                //txtFrase.setText(R.string.frase_premo);
                int random = (int)(Math.floor(Math.random()*3));
                txtFrase.setText(fraseAleatoria(random));
                imagenFrase.setImageDrawable(imagenParaFrase(random));

            }
        });
    }

    public String fraseAleatoria(int ind){
        Resources res= getResources();
        String frases[] = res.getStringArray(R.array.frases_premonitorias);
        return frases[ind];
    }

    public Drawable imagenParaFrase(int ind){
        Resources res= getResources();
        Drawable imagenes[]=new Drawable[3];
        imagenes[0] = res.getDrawable(R.drawable.loteria);
        imagenes[1] = res.getDrawable(R.drawable.amor);
        imagenes[2] = res.getDrawable(R.drawable.trabajo);
        return imagenes[ind];
    }

    /*public String fraseAleatoria(){
        ArrayList<String> frases = new ArrayList<>();
        frases.add("Te tocará la lotería");
        frases.add("Encontrarás el amor");
        frases.add("Te van a ascender en el trabajo");
        return frases.get((int) (Math.random()*frases.size()));
        }
     */
}
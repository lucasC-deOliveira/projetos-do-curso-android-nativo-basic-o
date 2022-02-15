package com.example.caracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView moeda;
    private ImageButton voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        moeda = findViewById(R.id.imageMoeda);

        voltar = findViewById(R.id.botaoVoltar);

        voltar.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                          startActivity(intent);*/
                                          //matando activity
                                          finish();
                                      }
                                  }
        );
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if(numero == 1){
            moeda.setImageResource(R.drawable.moeda_cara);
        }

        if(numero == 2){
            moeda.setImageResource(R.drawable.moeda_coroa);
        }


    }
}
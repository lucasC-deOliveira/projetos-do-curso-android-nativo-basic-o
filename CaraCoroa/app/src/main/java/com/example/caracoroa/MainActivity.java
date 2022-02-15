package com.example.caracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton jogar;
    private int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        jogar = findViewById(R.id.imageButtonJogar);
        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = random.nextInt(2) +1;
                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                intent.putExtra("numero", numero);
                startActivity(intent);


            }
        });
    }
}
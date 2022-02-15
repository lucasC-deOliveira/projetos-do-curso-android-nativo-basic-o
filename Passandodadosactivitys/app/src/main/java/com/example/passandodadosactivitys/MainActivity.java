package com.example.passandodadosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        //passando evento de click pro butão
        //utilizando classe anonima que implementa interface de click
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //criando intenção (oque voce quer fazer   )
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                //instanciar objeto
                Usuario usuario = new Usuario("Lucas Carvalho", "lucascdoliveira.dev@gmail.com");

                //passar dados
                intent.putExtra("nome","Lucas Carvalho");
                intent.putExtra("idade", 30);
                intent.putExtra("usuario", usuario);

                //chamando nova atividade
                startActivity(intent);
            }
        });
    }
}
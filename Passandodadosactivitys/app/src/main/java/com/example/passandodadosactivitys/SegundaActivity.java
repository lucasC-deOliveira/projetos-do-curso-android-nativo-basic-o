package com.example.passandodadosactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView textNome;
    private TextView textIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textIdade = findViewById(R.id.textIdade);
        textNome = findViewById(R.id.textNome);

        //recuperar dados enviados
        Bundle dados= getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        Usuario usuario = (Usuario) dados.getSerializable("usuario");

        //configurar valores recuperados
        textNome.setText(usuario.getNome());
        textIdade.setText(String.valueOf(usuario.getEmail()));

    }
}
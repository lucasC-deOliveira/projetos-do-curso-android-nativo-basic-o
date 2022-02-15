package com.example.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.R;
import com.example.fragments.fragment.FragmentContatos;
import com.example.fragments.fragment.FragmentConversas;


//fragments são pedaços de layouts que serão reaproveitados
public class MainActivity extends AppCompatActivity {
    private Button buttonConversa, buttonContato;
    private FragmentConversas conversasFragment;
    private FragmentContatos contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperando botões
        buttonContato = findViewById(R.id.buttonContato);
        buttonConversa = findViewById(R.id.buttonConversa);

        //remover sombra da actionBar
        getSupportActionBar().setElevation(0);

        //instanciando fragmento
        conversasFragment = new FragmentConversas();
        contatosFragment = new FragmentContatos();

        //configurar objeto para o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //onde quer exibir fragmento
        transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        //definindo eventos de click e passando fragments

        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //substituir
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //substituir
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });



    }


}
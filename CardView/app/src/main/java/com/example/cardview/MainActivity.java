package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardview.adapter.PostAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //criar dados
        prepararPostagens();

        //definir layout
        //layout horizontal
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        //gridlayout
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerPostagem.setLayoutManager(layoutManager);


        //definir tamanho fixo
        recyclerPostagem.setHasFixedSize(true);

        //definir adapter
        PostAdapter adapter = new PostAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagens(){
        Postagem p = new Postagem("Lucas Carvalho", "UOU que lindo", R.drawable.imagem1);
        this.postagens.add(p);
        p = new Postagem("Rogeria Gatinha", "Lugar Incrivel!", R.drawable.imagem2);
        this.postagens.add(p);
        p = new Postagem("Jorgão", "Incrivel olhar a grama crescer aqui", R.drawable.imagem3);
        this.postagens.add(p);
        p = new Postagem("Lucas Carvalho", "Cansado", R.drawable.imagem4);
        this.postagens.add(p);
    }
}
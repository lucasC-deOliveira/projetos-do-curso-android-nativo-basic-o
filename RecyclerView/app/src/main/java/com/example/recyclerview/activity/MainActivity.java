package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //configurar adapter
        //utilizado para adptar dados para a listagem
        Adapter adapter = new Adapter(listaFilmes);


        //configurar recyclerview
        //deve se passar um gerenciador de layout
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //definir tamanho fixo
        recyclerView.setHasFixedSize(true);

        //definir um divisor de item
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        //passar o adaptador
        recyclerView.setAdapter(adapter);


        // adicionar evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                              getApplicationContext(), "Item Pressionado: " + filme.getFilme(), Toast.LENGTH_SHORT
                            ).show();

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(), "Clique Longo: " + filme.getFilme(), Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    })
        );
    }

    //função para adicionar dados
    public void criarFilmes(){

        Filme filme = new Filme("Homem Aranha", "Ação", "2000");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem Aranha 2", "Ação", "2003");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem Aranha 3", "Ação", "2007");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem de ferro", "Ação", "2008");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem de ferro 2", "Ação", "2010");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem de ferro 3", "Ação", "2012");
        this.listaFilmes.add(filme);

        filme = new Filme("Thor Piadarok", "Ação", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("Vingadore Guerra Infinita", "Ação", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Vingadore Ultimato", "Ação", "2019");
        this.listaFilmes.add(filme);

    }

}
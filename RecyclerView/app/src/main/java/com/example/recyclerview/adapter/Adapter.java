package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Filme;

import java.util.List;

//o recyclerView recicla as visualizações ao rolar a tela

//passar viewholder
//mesmo ao rolar o scroll
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> lista;

    public Adapter(List<Filme> lista){
    this.lista = lista;
    }
    @NonNull
    @Override
    //metodo para criar as primeiras view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //passar adapter de um layout de item para ser exibido
        //converter item xml para view
        View item_lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_item_lista, parent, false);


        return new MyViewHolder(item_lista);
    }

    //metodo que exibe os itens
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //definindo objeto para recuperar os dados
        Filme filme = lista.get(position);
        //definindo valores
        holder.titulo.setText(filme.getFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());
    }

    //metodo que define quantidade de itens que serão exibidos
    @Override
    public int getItemCount() {
        return lista.size();
    }

    //inner class
    public class MyViewHolder extends RecyclerView.ViewHolder{
        //criar atributos que vao ser exibidos
        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //recuperar componentes de tela
            titulo= itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}

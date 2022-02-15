package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Postagem;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private List<Postagem> postagens;

    public PostAdapter(List<Postagem>postagems){
        this.postagens=postagems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_lista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post_view, parent, false);
        return new MyViewHolder(item_lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagem p = postagens.get(position);
       holder.nome.setText(p.getNome());
       holder.postagem.setText(p.getPostagem());
       holder.imagem.setImageResource(p.getImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView nome;
     private TextView postagem;
    private ImageView imagem;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNome);
            postagem = itemView.findViewById(R.id.textPostagem);
            imagem = itemView.findViewById(R.id.imagePostagem);
        }
    }
}

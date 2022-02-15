package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listlocais;
    //dados a exibir
    private String[] itens = {
            "Angra dos Reis", "Valparaiso", "Goias", "Brasilia", "São Paulo", "Florianopolis", "Petropolis", "Rio de janeiro"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlocais = findViewById(R.id.listLocais);

        //Criar adaptador para lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), //passando contexto da aplicação
                android.R.layout.simple_list_item_1, // passando layout / layout padrão porem voce pode criar o seu
                android.R.id.text1 // passando id do layout, local que vai ser exibido os itens
                , itens // passando dados
        );
        //adicionando adaptador para a lista
        listlocais.setAdapter(adaptador);

        //adicionar click na lista
        listlocais.setOnItemClickListener(
                //passando adaptador
                 new AdapterView.OnItemClickListener() {

                                              //passando adaptador
                                              //int position = posição do item
                                             //long id = id do item

                                              @Override
                                              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                  //recuperando posição do item
                                                  String valorSelecionado = listlocais.getItemAtPosition(position).toString();
                                                  //exibindo evento
                                                  Toast.makeText(getApplicationContext(), valorSelecionado,  Toast.LENGTH_SHORT).show();
                                              }
                                          }


        );
    }


}

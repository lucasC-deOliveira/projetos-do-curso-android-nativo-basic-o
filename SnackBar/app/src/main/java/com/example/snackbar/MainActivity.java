package com.example.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

//snackbar é muito semelhante ao toast
//porem ele pode realizar ações
public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;
    private Button buttonFechar;
    private Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);
        buttonFechar = findViewById(R.id.buttonFechar);

        //adicionando evento de click
        buttonAbrir.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //criando snackbar
                        //opcional guardar em variavel
                       snackbar  =    Snackbar.make(v,"Botão Pressionado",
                                Snackbar.LENGTH_INDEFINITE).setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                buttonAbrir.setText("Botão Abrir Alterado");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.design_default_color_primary_variant));
                        //mostrar
                        snackbar.show();

                        /*//remover
                        snackbar.dismiss();*/

                    }
                }
        );

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });

    }
}
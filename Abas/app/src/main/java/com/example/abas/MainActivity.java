package com.example.abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.abas.fragment.EmAltaFragment;
import com.example.abas.fragment.HomeFragment;
import com.example.abas.fragment.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    //recuperando referencia dos componentes

    //tabs
    private SmartTabLayout smartTabLayout;
    //conteudo
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        //remover elevação da abaPrincipal
        getSupportActionBar().setElevation(0);

        //configurar adapter para abas
        FragmentPagerItemAdapter adapter =  new FragmentPagerItemAdapter(
                //gerenciador de fragment
                getSupportFragmentManager(),
                FragmentPagerItems.with(this).
                        add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                        .create()
        );
        //passando adapter
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);

    }
}
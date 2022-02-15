package com.example.atmconsutoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsutoria.R;

import mehdi.sakout.aboutpage.AboutPage;


public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
        String descricao = " esta é uma descrição repetitiva  esta é uma descrição repetitiva  esta é uma descrição repetitiva  " +
                "esta é uma descrição repetitiva  esta é uma descrição repetitiva  esta é uma descrição repetitiva  esta é uma descrição repetitiva " +
                " esta é uma descrição repetitiva ";
        return new AboutPage(getActivity()).setImage(R.drawable.logo).setDescription(descricao)
                .addGroup("Entre em contato").addEmail("rogeriagatinha@gmail.com", "Envie um email")
                .addWebsite("www.google.com", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("lucasOliveira","Facebook")
                .addTwitter("lucasOliveira","Twitter")
                .addGitHub("lucasOliveira","github")
                .create();
    }
}
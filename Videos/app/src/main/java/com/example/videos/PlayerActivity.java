package com.example.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //esconde barra de status e de navegação
        View decorView = getWindow().getDecorView();
       int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
       decorView.setSystemUiVisibility(uiOptions);

        //esconde actionbar
        getSupportActionBar().hide();

        //executar video
        //configurar controles
        videoView.setMediaController( new MediaController(this));
        //adicionar caminho do video
        videoView.setVideoPath("android.resource://"+ getPackageName() + "/" + R.raw.video);
        videoView.start();
    }
}
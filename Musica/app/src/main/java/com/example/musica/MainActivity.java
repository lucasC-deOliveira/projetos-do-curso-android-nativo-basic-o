package com.example.musica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton play, stop, pause;
    private SeekBar seekVolume;

    //objeto que controla volume
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.buttonPlay);
        pause= findViewById(R.id.buttonPause);
        stop = findViewById(R.id.buttonStop);

        //classe que permite executar musica
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarSom();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarMusica();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararMusica();
            }
        });
        //chamando controle de volume
        inicializarSeekbar();




    }

    @Override
    protected void onStop() {
        super.onStop();
        pausarMusica();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            //liberar recursos
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void inicializarSeekbar(){
        seekVolume= findViewById(R.id.seekVolume);

        //configurar o audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //recupera valores de volume maximo e atual
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //configurar volume maximo para a seekbar
        seekVolume.setMax(volumeMax);

        //configurar progresso atual da seekbar
        seekVolume.setProgress(volumeAtual);

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void executarSom(){
        if(mediaPlayer != null){
            //inicia a musica
            mediaPlayer.start();
        }
    }

    public void pausarMusica(){
        //testar se musica esta sendo reproduzida
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void pararMusica(){
        //testar se musica esta sendo reproduzida
        if(mediaPlayer.isPlaying()){
            //mata a instancia da musica
            mediaPlayer.stop();
            //recriando instancia
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }
}
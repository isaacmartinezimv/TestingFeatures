package com.example.isaac.pruebam8uf2;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity  implements
FragmentReportarIncidencia.OnFragmentInteractionListener,
FragmentListaIncidencias.OnFragmentInteractionListener {

    //Declaracion de usables
    Toolbar toolbar; //Declaramos la toolBar
    FragmentReportarIncidencia reportarIncidencia;
    FragmentListaIncidencias listaIncidencias;
    MediaPlayer audioPlayer;
    boolean musicState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Desabilitimamos la rotacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Asociamos las variables a un new fargment (inicializamos)
        reportarIncidencia = new FragmentReportarIncidencia();
        listaIncidencias = new FragmentListaIncidencias();

        //Iniciamos la app con el fragment que elijamos
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, reportarIncidencia).commit();

        audioPlayer = new MediaPlayer(); //Instanciamos un nuevo MediaPlayer
        audioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String audioURL = "http://docs.google.com/uc?export=download&id=1SDCUlrEoxzcU2pehSMljEyxyAJkc3-mw";

        try {
            audioPlayer.setDataSource(audioURL);
            audioPlayer.prepare();
            audioPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Declaramos una variable de tipo fargment para substituir la pantalla en funcion del boton
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()){
            case R.id.musicItem:
                if (audioPlayer.isPlaying()) {
                    Toast.makeText(this, "Music Paused", Toast.LENGTH_SHORT).show();
                    audioPlayer.pause();
                    musicState = false;
                    toolbar.getMenu().getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp));
                } else {
                    Toast.makeText(this, "Music Playing", Toast.LENGTH_SHORT).show();
                    audioPlayer.start();
                    musicState = true;
                    toolbar.getMenu().getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_pause_black_24dp));
                }
                break;
            case R.id.item1:
                transaction.replace(R.id.contenedorFragment, reportarIncidencia);
                break;
            case R.id.item2:
                transaction.replace(R.id.contenedorFragment, listaIncidencias);
                break;
        }
        //Hacemos el commit independientemente del fragment pulsado
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        audioPlayer.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        audioPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        audioPlayer.pause();
    }
}

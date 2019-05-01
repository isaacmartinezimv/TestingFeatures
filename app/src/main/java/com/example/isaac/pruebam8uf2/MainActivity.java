package com.example.isaac.pruebam8uf2;

import android.content.pm.ActivityInfo;
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


public class MainActivity extends AppCompatActivity  implements
FragmentReportarIncidencia.OnFragmentInteractionListener,
FragmentListaIncidencias.OnFragmentInteractionListener {

    //Declaracion de usables
    Toolbar toolbar; //Declaramos la toolBar
    FragmentReportarIncidencia reportarIncidencia;
    FragmentListaIncidencias listaIncidencias;

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
                Toast.makeText(this, "play/pause musica", Toast.LENGTH_SHORT).show();
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


}

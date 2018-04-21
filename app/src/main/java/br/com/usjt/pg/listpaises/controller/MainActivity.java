package br.com.usjt.pg.listpaises.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import br.com.usjt.pg.listpaises.R;

/**
 * Tatiane do Nascimento Ayres 816118367
 */
public class MainActivity extends Activity {
    Spinner spinnerContinente;
    public static final String CHAVE = "br.com.usjt.pg.listpaises";
    String continente = "Todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                continente = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void listarPaises(View view) {
        Intent intent = new Intent(this, ListaPaisesActivity.class);
        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }
}

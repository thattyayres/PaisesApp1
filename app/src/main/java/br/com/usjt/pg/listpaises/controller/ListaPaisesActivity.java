package br.com.usjt.pg.listpaises.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.usjt.pg.listpaises.R;
import br.com.usjt.pg.listpaises.model.Data;
import br.com.usjt.pg.listpaises.model.Pais;
import br.com.usjt.pg.listpaises.model.PaisAdapter;

/**
 * Tatiane do Nascimento Ayres 816118367
 */

public class ListaPaisesActivity extends Activity {
    public static final String PAIS = "br.com.usjt.pg.listpaises";
    ArrayList<Pais> paises;
    ListView listView;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        context = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        paises = Data.listarPaisesByContinente(continente);
        listView = findViewById(R.id.lista_paises);
        PaisAdapter adapter = new PaisAdapter(this, paises);
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pais pais = paises.get(i);
                Intent intent = new Intent(context, DetalhePaisActivity.class);
                intent.putExtra(PAIS, pais);
                startActivity(intent);
            }
        });

    }
}

package br.com.usjt.pg.listpaises.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.usjt.pg.listpaises.R;
import br.com.usjt.pg.listpaises.model.Pais;
import br.com.usjt.pg.listpaises.model.Util;

/**
 * Tatiane do Nascimento Ayres 816118367
 */

public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(ListaPaisesActivity.PAIS);
        ImageView foto = (ImageView) findViewById(R.id.foto_pais_detalhe);
        Drawable drawable = Util.getDrawableDinamic(this, pais.getBandeira());
        foto.setImageDrawable(drawable);
        TextView nome = (TextView)findViewById(R.id.valor_nome_pais);
        nome.setText(pais.getNome());
        TextView regiao = (TextView)findViewById(R.id.valor_regiao_pais);
        regiao.setText(""+pais.getRegiao());
        TextView capital = (TextView)findViewById(R.id.valor_capital_pais);
        capital.setText(""+pais.getCapital());
    }
}

package br.com.usjt.pg.listpaises.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.usjt.pg.listpaises.R;

/**
 * Tatiane do Nascimento Ayres 816118367
 */

public class PaisAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pais> paises;
    private ImageView imagem;

    public PaisAdapter(Context context, ArrayList<Pais> paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int i) {
        return paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);
            ImageView imageView  = (ImageView) view.findViewById(R.id.imagem_pais);
            TextView nome = (TextView) view.findViewById(R.id.nome_pais);
            TextView regiao = (TextView) view.findViewById(R.id.regiao_pais);
            TextView capital = (TextView) view.findViewById(R.id.capital_pais);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setNome(nome);
            viewHolder.setRegiao(regiao);
            viewHolder.setCapital(capital);
            viewHolder.setImagem(imageView);
            view.setTag(viewHolder);
        }

        Pais pais = paises.get(position);
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.getImagem().setImageDrawable(Util.getDrawableDinamic(context, pais.getBandeira()));
        viewHolder.getNome().setText(pais.getNome());
        viewHolder.getRegiao().setText(pais.getRegiao());
        viewHolder.getCapital().setText(pais.getCapital());

        return view;
    }
}

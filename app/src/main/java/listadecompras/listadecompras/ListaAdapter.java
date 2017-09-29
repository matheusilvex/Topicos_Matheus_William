package listadecompras.listadecompras;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by matheuswilliamoliveira on 9/27/17.
 */

public class ListaAdapter extends ArrayAdapter<ListaCompras> {

    Context contexto;
    ArrayList<ListaCompras> lista;

    public ListaAdapter(Context context, int resource, ArrayList<ListaCompras> objects){
        super(context,resource,objects);
        this.contexto=context;
        this.lista=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View linhaView= LayoutInflater.from(contexto).inflate(R.layout.layout_vertical,parent,false);
        TextView Produto=(TextView) linhaView.findViewById(R.id.vertical_txtProduto);
        TextView Quantidade=(TextView) linhaView.findViewById(R.id.vertical_txtQtdLista);
        TextView Categoria=(TextView) linhaView.findViewById(R.id.vertical_txtCategoria);
        CheckBox Perecivel=(CheckBox) linhaView.findViewById(R.id.vertical_chkPerecivel);

        Produto.setText(lista.get(position).getProduto());
        Quantidade.setText(lista.get(position).getQuantidade());
        Categoria.setText(lista.get(position).getCategoria());
        Perecivel.setChecked(lista.get(position).isPerecivel());

        return linhaView;
    }
}

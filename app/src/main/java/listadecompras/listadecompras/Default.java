package listadecompras.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Default extends AppCompatActivity {

    private TextView nomeLista;
    private Spinner spiner;
    private List<String> categorias=new ArrayList<String>();
    ArrayList<ListaCompras> valores=new ArrayList<>();
    private Button Salvar;

    private TextView Produto;
    private TextView Quantidade;
    private String Categoria;
    private CheckBox Perecivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        nomeLista= (TextView) findViewById(R.id.default_lblNomeLista);
        Bundle receber=getIntent().getExtras();
        nomeLista.setText(receber.getString("nomeLista"));

        //Inicia Spinner
        //Populando o Spinner
        categorias.add("Armazem");
        categorias.add("Frios");
        categorias.add("Padaria");
        categorias.add("Açougue");
        //Identificando Spinner
        spiner=(Spinner) findViewById(R.id.default_spinerCategoria);
        //Criando um ArrayAdapter
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,categorias);
        ArrayAdapter<String> spinnerAdapter=arrayAdapter;
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spiner.setAdapter(spinnerAdapter);

        //Captura Item Selecionado Spinner
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Categoria=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Finaliza Spinner

        //Salvando as Informaçoe
        Produto=(TextView)findViewById(R.id.default_txtProduto);
        Quantidade=(TextView)findViewById(R.id.default_txtQuantidade);
        Perecivel=(CheckBox)findViewById(R.id.default_chkPerecivel);
        Salvar=(Button)findViewById(R.id.default_btnSalvar);
        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListaCompras itens=new ListaCompras(Produto.getText().toString(),Quantidade.getText().toString(),Perecivel.isChecked(),Categoria);
                valores.add(itens);
                ListView ItensSalvos=(ListView) findViewById(R.id.default_ListSave);
                ArrayAdapter Adapter=new ListaAdapter(Default.this, R.layout.layout_vertical,valores);
                ItensSalvos.setAdapter(Adapter);
                Produto.setText("");
                Quantidade.setText("");
                Perecivel.setChecked(false);

            }
        });
    }
}

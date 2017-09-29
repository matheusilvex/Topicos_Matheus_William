package listadecompras.listadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicial extends AppCompatActivity {

    private EditText nomeLista;
    private Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        nomeLista=(EditText) findViewById(R.id.inicial_txtNomeLista);
        iniciar=(Button)findViewById(R.id.inicial_btnIniciar);

        nomeLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeLista.setText("");
            }
        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DadosLista=new Intent(Inicial.this, Default.class);
                DadosLista.putExtra("nomeLista", nomeLista.getText().toString());
                startActivity(DadosLista);
            }
        });
    }
}

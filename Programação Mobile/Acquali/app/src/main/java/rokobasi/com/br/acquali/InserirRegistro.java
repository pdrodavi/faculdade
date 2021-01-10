package rokobasi.com.br.acquali;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class InserirRegistro extends AppCompatActivity {

    EditText etPrecipitacao;
    EditText vazao;
    EditText dbo;
    EditText ft;
    EditText nt;
    EditText cl;
    EditText cla;
    EditText od;
    EditText ph;
    EditText turbidez;
    EditText tipoDeCultura;
    EditText tipoDeIrrigacao;
    EditText metroQuadrado;
    Button salvarRegistro;

    private String agente;
    private String bacia;
    private String subBacia;
    private String acude;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agente_inserir_registro);

        // método action bar para botão back
        ActionBar bar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // titulo da actionbar
        ActionBar actionbarNome = getSupportActionBar();
        actionbarNome.setTitle("Inserir Registro");

        inicializarComponentesGraficos();
        inicializarFirebase();

        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null)
        {
            agente = params.getString("agente", agente);
            bacia = params.getString("bacia");
            subBacia = params.getString("subBacia");
            acude = params.getString("acude", acude);
        }

        salvarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirRegistro();
            }
        });
    }

    public void inicializarComponentesGraficos(){

        etPrecipitacao = (EditText) findViewById(R.id.et_precipitacao);
        vazao = (EditText) findViewById(R.id.et_vazao);
        dbo = (EditText) findViewById(R.id.et_dbo);
        ft = (EditText) findViewById(R.id.et_ft);
        nt = (EditText) findViewById(R.id.et_nt);
        cl = (EditText) findViewById(R.id.et_cl);
        cla = (EditText) findViewById(R.id.et_cla);
        od = (EditText) findViewById(R.id.et_od);
        ph = (EditText) findViewById(R.id.et_ph);
        turbidez = (EditText) findViewById(R.id.et_turbidez);
        tipoDeCultura = (EditText) findViewById(R.id.et_tipoDeCultura);
        tipoDeIrrigacao = (EditText) findViewById(R.id.et_tipoDeIrrigacao);
        metroQuadrado = (EditText) findViewById(R.id.et_metroquadrado);
        salvarRegistro = (Button) findViewById(R.id.bt_salvarParametrosAcude);

    }

    public String dataAtual(){
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        return currentDateTimeString;
    }

    public void inserirRegistro(){

            inicializarFirebase();

            Registro registro = new Registro();
            registro.setUid(UUID.randomUUID().toString());
            registro.setEmailAgente(agente);
            registro.setData(dataAtual());
            registro.setBacia(bacia);
            registro.setSubBacia(subBacia);
            registro.setAcude(acude);
            registro.setPrecipitacao(etPrecipitacao.getText().toString());
            registro.setVazao(vazao.getText().toString());
            registro.setDbo(dbo.getText().toString());
            registro.setFt(ft.getText().toString());
            registro.setNt(nt.getText().toString());
            registro.setCl(cl.getText().toString());
            registro.setCla(cla.getText().toString());
            registro.setOd(od.getText().toString());
            registro.setPh(ph.getText().toString());
            registro.setTurbidez(turbidez.getText().toString());
            registro.setTipoDeCultura(tipoDeCultura.getText().toString());
            registro.setTipoDeIrrigacao(tipoDeIrrigacao.getText().toString());
            registro.setMetroQuadrado(metroQuadrado.getText().toString());

            databaseReference.child("Registros").child(registro.getUid()).setValue(registro);

            limparCampos();

            Toast.makeText(this, "Registro Inserido!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, BaciasActivity.class));
            finish();
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(InserirRegistro.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void limparCampos(){

        etPrecipitacao.setText("");
        vazao.setText("");
        dbo.setText("");
        ft.setText("");
        nt.setText("");
        cl.setText("");
        cla.setText("");
        od.setText("");
        ph.setText("");
        turbidez.setText("");
        tipoDeCultura.setText("");
        tipoDeIrrigacao.setText("");
        metroQuadrado.setText("");

    }

    public boolean validaCampos(){

        if(etPrecipitacao.getText().toString().equals("")){
            Toast.makeText(this, "Campos acima do Perimetro Irrigado não podem ser vazios!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}

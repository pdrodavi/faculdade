package com.applicado.pedrodavi.applicado;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.applicado.pedrodavi.applicado.dao.AtividadeDAO;
import com.applicado.pedrodavi.applicado.modelo.Atividade;
import com.example.pedrodavi.applicado.model.Mask;

public class TelaFormActivity extends AppCompatActivity {

    EditText nomeAtividade;
    EditText nomeDisciplina;
    EditText nomeAssunto;
    EditText prazoEntrega;
    EditText formaEntrega;
    EditText anotacoes;
    Button btVariavel;

    Atividade atividade;
    Atividade altAtividade;
    AtividadeDAO atividadeDAO;
    long retornoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_form);

        // trocar cor da actionbar
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#800080")));

        ActionBar actionbarNome = getSupportActionBar();

        // método action bar para setinha
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent i = getIntent();
        altAtividade = (Atividade) i.getSerializableExtra("atividade-enviada");

        atividade = new Atividade();
        atividadeDAO = new AtividadeDAO(TelaFormActivity.this);

        nomeAtividade = (EditText) findViewById(R.id.et_nomeAtividade);
        nomeDisciplina = (EditText) findViewById(R.id.et_nomeDisciplina);
        nomeAssunto = (EditText) findViewById(R.id.et_nomeAssunto);
        prazoEntrega = (EditText) findViewById(R.id.et_prazoEntrega);
        prazoEntrega.addTextChangedListener(Mask.insert("##/##/####", prazoEntrega));
        formaEntrega = (EditText) findViewById(R.id.et_formaEntrega);
        anotacoes = (EditText) findViewById(R.id.et_anotacoes);
        btVariavel = (Button) findViewById(R.id.bt_variavel);

        if(altAtividade != null){

            actionbarNome.setTitle("Visualizar Atividade");

            btVariavel.setText("ALTERAR");

            nomeAtividade.setText(altAtividade.getAtividade());
            nomeDisciplina.setText(altAtividade.getDisciplina());
            nomeAssunto.setText(altAtividade.getAssunto());
            prazoEntrega.setText(altAtividade.getPrazo());
            formaEntrega.setText(altAtividade.getForma());
            anotacoes.setText(altAtividade.getAnotacoes());
            atividade.setId(altAtividade.getId());

        } else {

            actionbarNome.setTitle("Cadastrar Atividade");

            btVariavel.setText("Cadastrar");

        }

        btVariavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atividade.setAtividade(nomeAtividade.getText().toString());
                atividade.setDisciplina(nomeDisciplina.getText().toString());
                atividade.setAssunto(nomeAssunto.getText().toString());
                atividade.setPrazo(prazoEntrega.getText().toString());
                atividade.setForma(formaEntrega.getText().toString());
                atividade.setAnotacoes(anotacoes.getText().toString());

                if(btVariavel.getText().toString().equals("Cadastrar")){

                    retornoDB = atividadeDAO.inserirAtividade(atividade);
                    atividadeDAO.close();

                    if(retornoDB == -1){

                        alert("Erro ao cadastrar!");

                    } else {

                        alert("Atividade cadastrada!");

                    }

                } else {

                    retornoDB = atividadeDAO.alterarAtividade(atividade);
                    atividadeDAO.close();

                    if(retornoDB == -1){

                        alert("Erro ao alterar!");

                    } else {

                        alert("Alteração realizada!");

                    }

                }

                finish();

            }
        });
    }

    private void alert(String s){

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }


    // métodos para adicionar setinha de voltar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}

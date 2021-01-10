package com.applicado.pedrodavi.applicado;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.applicado.pedrodavi.applicado.dao.AtividadeDAO;
import com.applicado.pedrodavi.applicado.modelo.Atividade;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Atividade atividade;
    AtividadeDAO atividadeDAO;
    ArrayList<Atividade> arrayListAtividade;
    ArrayAdapter<Atividade> arrayAdapterAtividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // cor da action bar
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#800080")));

        listView = (ListView) findViewById(R.id.lv_listaAtividades);

        registerForContextMenu(listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Atividade atividadeEnviada = (Atividade) arrayAdapterAtividade.getItem(position);

                Intent i = new Intent(MainActivity.this, TelaFormActivity.class);
                i.putExtra("atividade-enviada", atividadeEnviada);
                startActivity(i);

            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                atividade = arrayAdapterAtividade.getItem(position);
                return false;

            }
        });

    }

    public void populaLista(){

        atividadeDAO = new AtividadeDAO(MainActivity.this);

        arrayListAtividade = atividadeDAO.selectAllAtividades();
        atividadeDAO.close();

        if(listView != null){

            arrayAdapterAtividade = new ArrayAdapter<Atividade>(MainActivity.this,
                    android.R.layout.simple_list_item_1, arrayListAtividade);

            listView.setAdapter(arrayAdapterAtividade);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        populaLista();
        alertCadastro();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem mDelete = menu.add("Excluir atividade");

        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                long retornoDB;

                atividadeDAO = new AtividadeDAO(MainActivity.this);

                retornoDB = atividadeDAO.excluirAtividade(atividade);
                atividadeDAO.close();

                if(retornoDB == -1){

                    alert("Não foi possível excluir!");

                } else {

                    alert("Atividade excluída!");

                }
                populaLista();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void alertCadastro(){

        atividadeDAO = new AtividadeDAO(MainActivity.this);
        atividadeDAO.close();

        if(atividadeDAO.selectAllAtividades().isEmpty()){
            Toast.makeText(this, "Nenhuma atividade cadastrada", Toast.LENGTH_LONG).show();
        }

    }

    // menu

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.acao_adiciona);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.acao_adiciona){

            Intent intent = new Intent(this, TelaFormActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    };
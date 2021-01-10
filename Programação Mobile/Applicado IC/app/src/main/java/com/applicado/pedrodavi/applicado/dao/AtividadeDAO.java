package com.applicado.pedrodavi.applicado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.applicado.pedrodavi.applicado.modelo.Atividade;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO extends SQLiteOpenHelper {

    // nome do banco, versao e a tabela
    private static final String NOME_BANCO = "DBAtividades.db";
    private static final int VERSION = 1;
    private static final String TABELA = "atividades";

    // colunas da tabela
    private static final String ID = "id";
    private static final String ATIVIDADE = "atividade";
    private static final String DISCIPLINA = "disciplina";
    private static final String ASSUNTO = "assunto";
    private static final String PRAZO = "prazo";
    private static final String FORMA = "forma";
    private static final String ANOTACOES = "anotacoes";

    public AtividadeDAO(Context context) {
        super(context, NOME_BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABELA + " ( " +
                " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " " + ATIVIDADE + " TEXT, " +
                " " + DISCIPLINA + " TEXT, " +
                " " + ASSUNTO + " TEXT, " +
                " " + PRAZO + " TEXT, " +
                " " + FORMA + " TEXT, " +
                " " + ANOTACOES + " TEXT );";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long inserirAtividade(Atividade atividade){

        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(ATIVIDADE, atividade.getAtividade());
        values.put(DISCIPLINA, atividade.getDisciplina());
        values.put(ASSUNTO, atividade.getAssunto());
        values.put(PRAZO, atividade.getPrazo());
        values.put(FORMA, atividade.getForma());
        values.put(ANOTACOES, atividade.getAnotacoes());

        retornoDB = getWritableDatabase().insert(TABELA, null, values);

        return retornoDB;
    }

    public long alterarAtividade(Atividade atividade){

        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(ATIVIDADE, atividade.getAtividade());
        values.put(DISCIPLINA, atividade.getDisciplina());
        values.put(ASSUNTO, atividade.getAssunto());
        values.put(PRAZO, atividade.getPrazo());
        values.put(FORMA, atividade.getForma());
        values.put(ANOTACOES, atividade.getAnotacoes());

        String[] args = {String.valueOf(atividade.getId())};

        retornoDB = getWritableDatabase().update(TABELA, values, "id=?", args);

        return retornoDB;
    }

    public long excluirAtividade(Atividade atividade){

        long retornoDB;

        String[] args = {String.valueOf(atividade.getId())};

        retornoDB = getWritableDatabase().delete(TABELA, ID+"=?", args);

        return retornoDB;
    }

    public ArrayList<Atividade> selectAllAtividades(){

        String[] coluns = {ID, ATIVIDADE, DISCIPLINA, ASSUNTO, PRAZO, FORMA, ANOTACOES};

        Cursor cursor = getWritableDatabase().query(TABELA, coluns, null, null, null, null, "prazo ASC", null);

        ArrayList<Atividade> listaAtivividades = new ArrayList<Atividade>();

        while(cursor.moveToNext()){

            Atividade atividade = new Atividade();

            atividade.setId(cursor.getInt(0));
            atividade.setAtividade(cursor.getString(1));
            atividade.setDisciplina(cursor.getString(2));
            atividade.setAssunto(cursor.getString(3));
            atividade.setPrazo(cursor.getString(4));
            atividade.setForma(cursor.getString(5));
            atividade.setAnotacoes(cursor.getString(6));

            listaAtivividades.add(atividade);

        }

        return listaAtivividades;
    }


}

package com.davidjulio.consultamedica.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    //Para facilitar caso haja alterações no código
    public static final String DB_NAME = "consulta.db"; //nome da bd
    public static final int VERSION = 1; //verão da bd

    //Tabela pacientes e colunas
    public static final String TABELA_PACIENTE = "tabela_paciente";

    public static final String ID_PACIENTE = "id_paciente";
    public static final String NOME_PACIENTE = "nome_paciente"; //nome do paciente
    public static final String TELE_PACIENTE = "tele_paciente"; //telemovel
    public static final String DATA_PACIENTE = "data_paciente"; //data de nascimento
    public static final String CIDADE_PACIENTE = "cidade_paciente"; //cidade
    public static final String RESULTADO_PACIENTE = "resultado_paciente"; //resultado ao teste COVID19


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criação tabela dos pacientes
        db.execSQL("CREATE TABLE " + TABELA_PACIENTE + " ("+
                ID_PACIENTE + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ //Incrementado automaticamente
                NOME_PACIENTE + " TEXT NOT NULL, "+
                TELE_PACIENTE + " TEXT NOT NULL, "+
                DATA_PACIENTE + " TEXT NOT NULL, "+
                CIDADE_PACIENTE + " TEXT NOT NULL, "+
                RESULTADO_PACIENTE + " TEXT NOT NULL "+
                ") ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PACIENTE);
        onCreate(db);
        */
    }

    public boolean insertDataPaciente (String nome, String tele, String data, String cidade, String resultado){ //adicionar os argumentos correspondentes à tabela
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues(); //instanciar a classe
        contentValues.put(NOME_PACIENTE, nome); //coluna (NOME_PACIENTE) e os value (nome), put para colocar na coluna
        contentValues.put(TELE_PACIENTE, tele);
        contentValues.put(DATA_PACIENTE, data);
        contentValues.put(CIDADE_PACIENTE, cidade);
        contentValues.put(RESULTADO_PACIENTE, resultado);

        long result = db.insert(TABELA_PACIENTE, null, contentValues); //inserir na tabela

        if(result == -1)
            return false;
        else
            return true;
    }
}

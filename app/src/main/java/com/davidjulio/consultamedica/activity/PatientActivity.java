package com.davidjulio.consultamedica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.davidjulio.consultamedica.R;
import com.davidjulio.consultamedica.adapter.AdapterPatients;
import com.davidjulio.consultamedica.helper.DbHelper;
import com.davidjulio.consultamedica.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    private SQLiteDatabase mydb; //chamar a db

    private RecyclerView recyclerViewPatients;
    private AdapterPatients adapterPatients; //devia ser patientsAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        DbHelper dbHelper = new DbHelper(this); //inicializar a dbHelper
        mydb = dbHelper.getWritableDatabase(); //como queremos inserir dados write

        recyclerViewPatients = findViewById(R.id.recyclerViewPatients); //chamar recycler
        recyclerViewPatients.setLayoutManager(new LinearLayoutManager(this));
        adapterPatients = new AdapterPatients(this, getAllPatients()); //passamos o contexto e chamamos o cursor da função getAllPatients
        recyclerViewPatients.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //divisor
        recyclerViewPatients.setAdapter(adapterPatients); //passamos o adapter na recyc

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) { //uso do itemTouchHelper de modo a apagar os registos sempre que desliza para a esquerda
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removePatient((long) viewHolder.itemView.getTag()); //chamar função que permite apagar o paciente a partir do id, num getTag()
            }
        }).attachToRecyclerView(recyclerViewPatients); //ligar ao recyc
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.mAdd) {
            Intent intentAddPatient = new Intent(this, AddPatientActivity.class);
            startActivity(intentAddPatient);
        }
        return super.onOptionsItemSelected(item);
    }


    public Cursor getAllPatients(){ //este cursor vai recolher todos os dados da nossa tabela
        return mydb.query(DbHelper.TABELA_PACIENTE, //passamos a tabela para saber a que tabela pertence
                null,
                null,
                null,
                null, //valores a null porque não são utilizados na query
                null,
                null);
    }

    private void removePatient(long id){ //função para receber o id e aproveitar a função delete da Sqlitadatabase que permite apagar o registo
        mydb.delete(DbHelper.TABELA_PACIENTE, DbHelper.ID_PACIENTE + "="+ id, null);//qual a linha apagar consoante o id passado
        adapterPatients.mudarCursor(getAllPatients()); //faz o "refresh" dos registos
    }

}

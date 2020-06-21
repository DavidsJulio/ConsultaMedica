package com.davidjulio.consultamedica.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.davidjulio.consultamedica.R;

public class PatientActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        recyclerViewPatients = findViewById(R.id.recyclerViewPatients); //chamar recycler

        //Configurar Adapter

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); //Pode ser linear/grid
        recyclerViewPatients.setLayoutManager( layoutManager );
        recyclerViewPatients.setHasFixedSize( true ); //otimizar o recyclerView com tamanho fixo, recomendado pela google
        //recyclerViewPatients.setAdapter(  ); //o adapter recebe os dados, formata e utiliza no Recycler
    }
}

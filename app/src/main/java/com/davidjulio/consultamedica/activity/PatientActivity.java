package com.davidjulio.consultamedica.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.davidjulio.consultamedica.R;
import com.davidjulio.consultamedica.adapter.AdapterPatients;
import com.davidjulio.consultamedica.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    private AdapterPatients adapterPatients; //devia ser patientsAdapter
    private List<Patient> patientList = new ArrayList<>(); //lista de pacientes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        recyclerViewPatients = findViewById(R.id.recyclerViewPatients); //chamar recycler


    }

    public void carregarListaPacientes(){
        //patient

        Patient patient = new Patient();
        patient.setNamePatient("David Julio");
        patient.setPhonePatient("961234567");
        patient.setbDatePatient("12/12/1997");
        patient.setCityPatient("Guarda");
        patient.setResultPatient("Positivo");
        patientList.add(patient);

        Patient patient1 = new Patient();
        patient1.setNamePatient("David Julio");
        patient1.setPhonePatient("931234567");
        patient1.setbDatePatient("12/03/2000");
        patient1.setCityPatient("Lisboa");
        patient1.setResultPatient("Negativo");
        patientList.add(patient1);



        //Configurar Adapter (para configurar o adapter primeiro é preciso criar uma class)
        adapterPatients = new AdapterPatients( patientList ); //passar a lista

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); //Pode ser linear/grid
        recyclerViewPatients.setLayoutManager( layoutManager );
        recyclerViewPatients.setHasFixedSize( true ); //otimizar o recyclerView com tamanho fixo, recomendado pela google
        recyclerViewPatients.setAdapter( adapterPatients ); //o adapter recebe os dados, formata e utiliza no Recycler
    }

    @Override
    protected void onStart() {
        carregarListaPacientes(); //chamar função
        super.onStart();

    }
}

package com.davidjulio.consultamedica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.davidjulio.consultamedica.R;
import com.davidjulio.consultamedica.adapter.AdapterPatients;
import com.davidjulio.consultamedica.helper.DbHelper;
import com.google.android.material.textfield.TextInputEditText;

public class AddPatientActivity extends AppCompatActivity {

    AdapterPatients adapterPatients;
    PatientActivity patientActivity;

    TextInputEditText tiName, tiPhone, tiBdate, tiCity, tiResult;
    DbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        myDb = new DbHelper(this); //instaciar a bd

        //buscar componentes da add patient
        tiName = (TextInputEditText) findViewById(R.id.tiName);
        tiPhone = (TextInputEditText)findViewById(R.id.tiPhone);
        tiBdate = (TextInputEditText)findViewById(R.id.tiBdate);
        tiCity = (TextInputEditText)findViewById(R.id.tiCity);
        tiResult = (TextInputEditText)findViewById(R.id.tiResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.mSave) {

            AddPatientData();

            Intent intentSavePatient = new Intent(this, PatientActivity.class);
            startActivity(intentSavePatient);

           // Toast.makeText(this, R.string.infoSaved, Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public void AddPatientData(){

        myDb.insertDataPaciente(tiName.getText().toString().trim(), //vai buscar o texto em string e sem espaços (trim)
                                tiPhone.getText().toString().trim(),
                                tiBdate.getText().toString().trim(),
                                tiCity.getText().toString().trim(),
                                tiResult.getText().toString().trim());
        //adapterPatients.mudarCursor(patientActivity.getAllPatients());//passar o novo cursor com a função para atualizar
    }
}
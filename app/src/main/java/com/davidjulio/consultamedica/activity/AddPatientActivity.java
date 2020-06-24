package com.davidjulio.consultamedica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.davidjulio.consultamedica.R;

public class AddPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
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
            Intent intentSavePatient = new Intent(this, PatientActivity.class);
            startActivity(intentSavePatient);
            Toast.makeText(this, R.string.infoSaved, Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
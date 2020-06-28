package com.davidjulio.consultamedica.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.davidjulio.consultamedica.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddAppointActivity extends AppCompatActivity {

    TextInputEditText tiDateAppoint, tiHourAppoint;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appoint);

        tiDateAppoint = (TextInputEditText) findViewById(R.id.tiDateAppoint);
        tiHourAppoint = (TextInputEditText) findViewById(R.id.tiHourAppoint);
        spinner = (Spinner) findViewById(R.id.spinnerPatient);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intentAppoint = new Intent(this, AppointmentActivity.class);
        startActivity( intentAppoint );
        return super.onOptionsItemSelected(item);
    }
}
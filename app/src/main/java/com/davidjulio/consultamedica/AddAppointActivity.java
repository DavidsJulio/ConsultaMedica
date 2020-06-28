package com.davidjulio.consultamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class AddAppointActivity extends AppCompatActivity {

    TextInputEditText tiDateAppoint, tiHourAppoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appoint);

        tiDateAppoint = (TextInputEditText) findViewById(R.id.tiDateAppoint);
        tiHourAppoint = (TextInputEditText) findViewById(R.id.tiHourAppoint);
    }
}
package com.davidjulio.consultamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPatient (View view){

        Intent intentPatient = new Intent (this, PatientActivity.class);
        //Intent intentAppointment = new Intent (this, PatientActivity.class);


        startActivity(intentPatient);
        //startActivity(intentAppointment);
    }
}

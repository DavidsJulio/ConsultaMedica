package com.davidjulio.consultamedica.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.davidjulio.consultamedica.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPatient (View view){

        Intent intentPatient = new Intent (this, PatientActivity.class);

        startActivity(intentPatient);

    }

    public void btnAppointment (View view){

        Intent intentAppointment = new Intent (this, AppointmentActivity.class);

        startActivity(intentAppointment);
    }
}
